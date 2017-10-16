package com.group.meal.utils;

import com.google.common.collect.Lists;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by whz on 2017/9/3.
 */
public class ImportAndExportExcelUtil {

    public static final String EXCEL_SUFFIX_XLS = ".xls";

    public static final String EXCEL_SUFFIX_XLSX = ".xlsx";

    public static final String FILE_SEPARATOR = System.getProperties().getProperty("file.separator");

    /**
     * 在应用根目录下创建一个文件夹，用于保存Excel文件
     * @param request
     * @param folderName 要创建的文件夹名称
     */
    public static String createSaveExcelFolder(HttpServletRequest request, String folderName) {
        // 创建一个文件夹，用来保存Excel文件
        String folderPath = request.getSession().getServletContext().getRealPath(folderName);
        File file = new File(folderPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        return folderPath;
    }

    /**
     * 创建Excel文件，数据导入Excel，然后保存到指定的服务器路
     * @param headFields    表头信息
     * @param records       要导出的数据
     * @param sheetName     表示Excel页签
     * @param filepath      表示文件路径（路径 + 文件名 + 文件后缀）
     * @return Excel文件是否创建成功
     */
    public static boolean createExcelFile(List<String> headFields, List<Map<String, String>> records, String sheetName, String filepath) {
        boolean flag;

        try {
            OutputStream os = new FileOutputStream(filepath);
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet(sheetName);
            XSSFRow row = sheet.createRow(0);

            int cell = 0;
            for (String columnName : headFields) {
                row.createCell(cell).setCellValue(columnName);
                sheet.setColumnWidth(cell, columnName.getBytes().length*256);// 仅适用中文
                cell++;
            }

            int rw = 1;
            for (Map<String, String> record : records) {
                XSSFRow xRow = sheet.createRow(rw);
                cell = 0;
                for (String columnName : headFields) {
                    xRow.createCell(cell).setCellValue(record.get(columnName));
                    sheet.autoSizeColumn(cell);// 不适用中文
                    cell++;
                }
                rw++;
            }

            workbook.write(os);
            os.close();
            flag = true;
        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 创建Excel文件，数据导入Excel，然后保存到指定的服务器路(支持多个页签数据)
     * @param sheetHeadFields
     * @param sheetRecords
     * @param sheetNames
     * @param filePath
     * @return
     */
    public static boolean createExcelFile(List<List<String>> sheetHeadFields, List<List<Map<String,String>>> sheetRecords, List<String> sheetNames, String filePath) {
        boolean flg;
        try {
            OutputStream os = new FileOutputStream(filePath);
            XSSFWorkbook wb = new XSSFWorkbook();

            int sheetNum = sheetNames.size();
            for(int sheetIndex = 0; sheetIndex < sheetNum; sheetIndex++) {

                XSSFSheet sheet = wb.createSheet(sheetNames.get(sheetIndex));
                XSSFRow row = sheet.createRow(0);

                int cell = 0;
                for (String columnName : sheetHeadFields.get(sheetIndex)) {
                    Cell tempCell = row.createCell(cell);
                    tempCell.setCellType(CellType.STRING);
                    tempCell.setCellValue(columnName);
                    sheet.setColumnWidth(cell, columnName.getBytes().length*256);// 仅适用中文
                    cell++;
                }

                int rw = 1;
                if(sheetRecords != null) {
                    for (Map<String, String> record : sheetRecords.get(sheetIndex)) {
                        XSSFRow xRow = sheet.createRow(rw);
                        cell = 0;
                        for (String columnName : sheetHeadFields.get(sheetIndex)){
                            Cell tempCell = xRow.createCell(cell);
                            tempCell.setCellType(CellType.STRING);
                            tempCell.setCellValue(record.get(columnName));
                            sheet.autoSizeColumn(cell);// 不适用中文
                            cell++;
                        }
                        rw++;
                    }
                }

            }

            wb.write(os);
            os.close();
            flg = true;
        } catch (Exception e) {
            flg = false;
        }
        return flg;
    }

    /**
     * 将服务器上的文件下载到客户端（用户浏览器）
     * @param path 服务器上的文件路径（路径 + 文件名 + 后缀）
     * @param response
     */
    public static void downloadFromService(String path, HttpServletResponse response) {
        try {
            File file = new File(path);
            String fileName = file.getName();
            InputStream fis = new BufferedInputStream(new FileInputStream(path));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            response.reset();
            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            response.addHeader("Content-Length", "" + file.length());
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 获取第一个页签的第一行的表头信息
     * @param is
     * @return
     */
    @Deprecated
    public String[] readExcelTitle(InputStream is) throws IOException {
        POIFSFileSystem poifsFileSystem = new POIFSFileSystem(is);
        HSSFWorkbook workbook = new HSSFWorkbook(poifsFileSystem);

        // 获取第一个页签
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(0);
        // 标题总列数
        int colNum = row.getPhysicalNumberOfCells();
        String[] headFields = new String[colNum];
        for (int i = 0; i < colNum; i++) {
            headFields[i] = getCellFormatValue(row.getCell((short) i));
        }
        return headFields;
    }

    /**
     * 获取表格数据（从第二行开始，）
     * @param is
     * @return key：表示数据的索引；value：表示行数据，用“-”分割
     * @throws IOException
     */
    @Deprecated
    public Map<Integer, String> readExcelContent(InputStream is) throws IOException {
        String str = "";
        Map<Integer, String> content = new HashMap<Integer, String>();

        POIFSFileSystem poifsFileSystem = new POIFSFileSystem(is);;
        Workbook workbook = new HSSFWorkbook(poifsFileSystem);

        Sheet sheet = workbook.getSheetAt(0);
        // 得到总行数
        int rowNum = sheet.getLastRowNum();
        Row row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();

        // 正文内容应该从第二行开始,第一行为表头的标题
        for (int i = 1; i <= rowNum; i++) {
            row = sheet.getRow(i);
            int j = 0;
            while (j < colNum) {
                // 每个单元格的数据内容用"-"分割开，以后需要时用String类的replace()方法还原数据
                // 也可以将每个单元格的数据设置到一个javabean的属性中，此时需要新建一个javabean
                // str += getStringCellValue(row.getCell((short) j)).trim() +
                // "-";
                str += getCellFormatValue(row.getCell((short) j)).trim() + "    ";
                j++;
            }
            content.put(i, str);
            str = "";
        }
        return content;
    }

    /**
     * 获取单元格数据内容为字符串类型的数据
     *
     * @param cell Excel单元格
     * @return String 单元格数据内容
     */
    @Deprecated
    private static String getStringCellValue(Cell cell) {
        String strCell = "";
        switch (cell.getCellType()) {
            case HSSFCell.CELL_TYPE_STRING:
                strCell = cell.getStringCellValue();
                break;
            case HSSFCell.CELL_TYPE_NUMERIC:
                strCell = String.valueOf(cell.getNumericCellValue());
                break;
            case HSSFCell.CELL_TYPE_BOOLEAN:
                strCell = String.valueOf(cell.getBooleanCellValue());
                break;
            case HSSFCell.CELL_TYPE_BLANK:
                strCell = "";
                break;
            default:
                strCell = "";
                break;
        }
        if (strCell.equals("") || strCell == null) {
            return "";
        }
        if (cell == null) {
            return "";
        }
        return strCell;
    }

    /**
     * 根据HSSFCell类型设置数据
     * @param cell
     * @return
     */
    @Deprecated
    private static String getCellFormatValue(Cell cell) {
        String cellvalue = "";
        if (cell != null) {
            // 判断当前Cell的Type
            switch (cell.getCellType()) {
                // 如果当前Cell的Type为NUMERIC
                case HSSFCell.CELL_TYPE_NUMERIC:
                case HSSFCell.CELL_TYPE_FORMULA: {
                    // 判断当前的cell是否为Date
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
                        // 如果是Date类型则，转化为Data格式

                        //方法1：这样子的data格式是带时分秒的：2011-10-12 0:00:00
                        //cellvalue = cell.getDateCellValue().toLocaleString();

                        //方法2：这样子的data格式是不带带时分秒的：2011-10-12
                        Date date = cell.getDateCellValue();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        cellvalue = sdf.format(date);

                    }
                    // 如果是纯数字
                    else {
                        // 取得当前Cell的数值
                        cellvalue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                }
                // 如果当前Cell的Type为STRIN
                case HSSFCell.CELL_TYPE_STRING:
                    // 取得当前的Cell字符串
                    cellvalue = cell.getRichStringCellValue().getString();
                    break;
                // 默认的Cell值
                default:
                    cellvalue = " ";
            }
        } else {
            cellvalue = "";
        }
        return cellvalue;

    }

    public static void main(String[] args) {

        String filePath = "D:" + FILE_SEPARATOR + "测试Excel" + EXCEL_SUFFIX_XLSX;
        List<String> titles = Lists.newArrayList(new String[]{"11111", "22222"});
        List<List<String>> headFields = Lists.newArrayList();
        headFields.add(Lists.newArrayList(new String[]{"序号","姓名"}));
        headFields.add(Lists.newArrayList(new String[]{"ID11111111"}));

        List<List<Map<String,String>>> records = Lists.newArrayList();
        List<Map<String,String>> record1 = Lists.newArrayList();
        Map<String, String> recordMap1 = new HashMap<>();
        recordMap1.put("序号","1");
        recordMap1.put("姓名","1");
        record1.add(recordMap1);
        records.add(record1);

        List<Map<String,String>> record2 = Lists.newArrayList();
        Map<String, String> recordMap2 = new HashMap<>();
        recordMap2.put("ID11111111","111111111111111111111111111111");
        record2.add(recordMap2);
        records.add(record2);

        createExcelFile(headFields, records, titles, filePath);
    }

    public void test(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // 创建表头
        List<String> headFields = new ArrayList<String>();
        headFields.add("序号");
        headFields.add("姓名");

        // 构建表格数据
        List<Map<String, String>> records = new ArrayList<Map<String, String>>();
        for (int i = 1; i <= 5; i++) {
            Map<String, String> record = new HashMap<String, String>();
            record.put("序号", i + "");
            record.put("姓名", "姓名" + i);
            records.add(record);
        }

        // 创建一个保存Excel的文件夹
        String folderPath = createSaveExcelFolder(request, "exportDocs");
        String filePath = folderPath + FILE_SEPARATOR + "人员信息" + EXCEL_SUFFIX_XLSX;

        // 创建Excel文件，数据导入Excel，然后保存到指定的服务器路径
        boolean flag = createExcelFile(headFields, records, "sheet1", filePath);
        if (flag) {
            // 将服务器上的文件下载到客户端（用户浏览器）
            downloadFromService(filePath, response);
        } else {
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().print("下载文件失败");
        }
    }
}
