package com.group.meal.service.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;


public class UniqId {

    private static final Logger log = LoggerFactory.getLogger(UniqId.class);

    private static char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8',
            '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static Map<Character, Integer> rDigits = new HashMap<Character, Integer>(16);
    private static UniqId me = new UniqId();

    static {
        for (int i = 0; i < digits.length; ++i) {
            rDigits.put(digits[i], i);
        }
    }

    private String hostAddr;
    private Random random = new SecureRandom();
    private MessageDigest mHasher;
    private UniqTimer timer = new UniqTimer();

    private ReentrantLock opLock = new ReentrantLock();

    private UniqId() {
        try {
            InetAddress addr = InetAddress.getLocalHost();

            hostAddr = addr.getHostAddress();
        } catch (IOException e) {
            log.error("[UniqId]Get HostAddr Error", e);
            hostAddr = String.valueOf(System.currentTimeMillis());
        }

        if (StringUtils.isBlank(hostAddr) || "127.0.0.1".equals(hostAddr)) {
            hostAddr = String.valueOf(System.currentTimeMillis());
        }

        if (log.isDebugEnabled()) {
            log.debug("[UniqId]hostAddr is:" + hostAddr);
        }

        try {
            mHasher = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException nex) {
            mHasher = null;
            log.error("[UniqId]new MD5 Hasher error", nex);
        }
    }

    /**
     * ��ȡUniqIDʵ��
     *
     * @return UniqId
     */
    public static UniqId getInstance() {
        return me;
    }

    /**
     * ��ò����ظ��ĺ�����
     *
     * @return
     */
    public long getUniqTime() {
        return timer.getCurrentTime();
    }

    /**
     * ���UniqId
     *
     * @return uniqTime-randomNum-hostAddr-threadId
     */
    public String getUniqID() {
        StringBuffer sb = new StringBuffer();
        long t = timer.getCurrentTime();

        sb.append(t);

        sb.append("-");

        sb.append(random.nextInt(8999) + 1000);

        sb.append("-");
        sb.append(hostAddr);

        sb.append("-");
        sb.append(Thread.currentThread().hashCode());

        if (log.isDebugEnabled()) {
            log.debug("[getUniqID]" + sb.toString());
        }

        return sb.toString();
    }

    /**
     * ��ȡMD5֮���uniqId string
     *
     * @return uniqId md5 string
     */
    public String getUniqIDHashString() {
        return hashString(getUniqID());
    }

    /**
     * ��ȡMD5֮���uniqId
     *
     * @return byte[16]
     */
    public byte[] getUniqIDHash() {
        return hash(getUniqID());
    }

    /**
     * ���ַ�������md5
     *
     * @param str
     * @return md5 byte[16]
     */
    public byte[] hash(String str) {
        opLock.lock();
        try {
            byte[] bt = mHasher.digest(str.getBytes("UTF-8"));
            if (null == bt || bt.length != 16) {
                throw new IllegalArgumentException("md5 need");
            }
            return bt;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("unsupported utf-8 encoding", e);
        } finally {
            opLock.unlock();
        }
    }

    /**
     * �Զ��������ݽ���md5
     *
     * @return md5 byte[16]
     */
    public byte[] hash(byte[] data) {
        opLock.lock();
        try {
            byte[] bt = mHasher.digest(data);
            if (null == bt || bt.length != 16) {
                throw new IllegalArgumentException("md5 need");
            }
            return bt;
        } finally {
            opLock.unlock();
        }
    }

    /**
     * ���ַ�������md5 string
     *
     * @param str
     * @return md5 string
     */
    public String hashString(String str) {
        byte[] bt = hash(str);
        return bytes2string(bt);
    }

    /**
     * ���ֽ�������md5 string
     *
     * @param str
     * @return md5 string
     */
    public String hashBytes(byte[] str) {
        byte[] bt = hash(str);
        return bytes2string(bt);
    }

    /**
     * ��һ���ֽ�����ת��Ϊ�ɼ����ַ���
     *
     * @param bt
     * @return
     */
    public String bytes2string(byte[] bt) {
        int l = bt.length;

        char[] out = new char[l << 1];

        for (int i = 0, j = 0; i < l; i++) {
            out[j++] = digits[(0xF0 & bt[i]) >>> 4];
            out[j++] = digits[0x0F & bt[i]];
        }

        if (log.isDebugEnabled()) {
            log.debug("[hash]" + (new String(out)));
        }

        return new String(out);
    }

    /**
     * ���ַ���ת��Ϊbytes
     *
     * @param str
     * @return byte[]
     */
    public byte[] string2bytes(String str) {
        if (null == str) {
            throw new NullPointerException("��������Ϊ��");
        }
        if (str.length() != 32) {
            throw new IllegalArgumentException("�ַ������ȱ�����32");
        }
        byte[] data = new byte[16];
        char[] chs = str.toCharArray();
        for (int i = 0; i < 16; ++i) {
            int h = rDigits.get(chs[i * 2]).intValue();
            int l = rDigits.get(chs[i * 2 + 1]).intValue();
            data[i] = (byte) ((h & 0x0F) << 4 | (l & 0x0F));
        }
        return data;
    }

    /**
     * ʵ�ֲ��ظ���ʱ��
     *
     * @author dogun
     */
    private static class UniqTimer {
        private AtomicLong lastTime = new AtomicLong(System.currentTimeMillis());

        /**
         * @return
         */
        public long getCurrentTime() {
            return this.lastTime.incrementAndGet();
        }
    }
}
