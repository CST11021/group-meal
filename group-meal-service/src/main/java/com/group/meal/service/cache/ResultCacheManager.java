package com.group.meal.service.cache;

import com.google.common.collect.Maps;
import com.group.meal.dao.dataobject.GroupItemCategoryDO;
import com.group.meal.dao.mapper.GroupItemCategoryDao;
import com.group.meal.dao.query.BaseQueryDO;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static com.group.meal.service.cache.CacheKeyPrefix.GROUP_ITEM_CATEGORY;


@Service("resultCacheManager")
public class ResultCacheManager {

	private static final Logger logger = LoggerFactory.getLogger(ResultCacheManager.class);

	private static Map<String, CacheResult> resultCaches = Maps.newConcurrentMap();

	@Autowired
	private GroupItemCategoryDao categoryDao;

	public static <T> T get(String key, ProceedingJoinPoint<T> pjp){
		if(StringUtils.isBlank(key)){
			return pjp.proceed();
		}

		T object;
		CacheResult result = resultCaches.get(key);
		if(result == null){
			object = pjp.proceed();
			resultCaches.put(key, new CacheResult(object));
		} else {
			object = (T)result.getResult();
			logger.info("获取到缓存信息：{}", key);
		}
		return object;
	}

	public static void put(String key, Object object) {
		resultCaches.put(key, new CacheResult(object));
	}
	
	// 定制spring-job.xml中定制的任务。用来删除过期的结果缓存
	public void deleteResultCache(long timeToLiveMinutes){
		//自己写过滤方法，不使用google的Maps的过滤方法，google的过滤方法返回的不是ConcurrentMap对象
		Set<String> resultKeys = new HashSet();
		long now = new Date().getTime();
		for(String resultKey : resultCaches.keySet()){
			CacheResult result = resultCaches.get(resultKey);
			if(now - result.getCreateTime() > timeToLiveMinutes * 60 * 1000){
				resultKeys.add(resultKey);
			}
		}
		synchronized (resultCaches) {
			for(String resultKey : resultKeys){
				resultCaches.remove(resultKey);
			}
		}
		logger.info("清理掉{}个结果缓存", resultKeys.size());
	}

	public interface ProceedingJoinPoint<T> {
		T proceed();
	}

	public static class CacheResult {
		
		private Object result;
		private long createTime;
		
		public CacheResult(Object result){
			this.result = result;
			this.createTime = new Date().getTime();
		}

		public Object getResult() {
			return result;
		}

		public void setResult(Object result) {
			this.result = result;
		}

		public long getCreateTime() {
			return createTime;
		}

		public void setCreateTime(long createTime) {
			this.createTime = createTime;
		}
	}
	
}

