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
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by whz on 2017/9/3.
 */
public class ImportAndExportExcelUtil<T> {

    public static final int MAX_NUM_PER_SHEET = 50000;

    public static final String EXCEL_SUFFIX_XLS = ".xls";

    public static final String EXCEL_SUFFIX_XLSX = ".xlsx";

    public static final String FILE_SEPARATOR = System.getProperties().getProperty("file.separator");

    /**
     * 在应用根目录下创建一个文件夹，用于保存Excel文件
     *
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
     * 创建Excel文件，数据导入Excel，然后保存到指定的服务器路径
     *
     * @param headFields 表头信息
     * @param records    要导出的数据
     * @param sheetName  表示Excel页签
     * @param filepath   表示文件路径（路径 + 文件名 + 文件后缀）
     * @return Excel文件是否创建成功
     */
    public static boolean createExcelFile(List<String> headFields, Map<String, Integer> setWidth,
                                          List<Map<String, String>> records, String sheetName, String filepath) {
        boolean flag;

        try {
            OutputStream os = new FileOutputStream(filepath);
            XSSFWorkbook workbook = new XSSFWorkbook();
            createSheet(workbook, sheetName, headFields, setWidth, records);
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
     *
     * @param sheetHeadFields
     * @param sheetRecords
     * @param sheetNames
     * @param filePath
     * @return
     */
    public static boolean createExcelFile(List<List<String>> sheetHeadFields,
                                          List<Map<String, Integer>> setWidths,
                                          List<List<Map<String, String>>> sheetRecords,
                                          List<String> sheetNames, String filePath) {
        boolean flg;
        try {
            OutputStream os = new FileOutputStream(filePath);
            XSSFWorkbook workbook = new XSSFWorkbook();

            int sheetNum = sheetNames.size();
            for (int sheetIndex = 0; sheetIndex < sheetNum; sheetIndex++) {
                Map<String, Integer> setWidth = setWidths == null ? null : setWidths.get(sheetIndex);
                createSheet(workbook, sheetNames.get(sheetIndex), sheetHeadFields.get(sheetIndex),
                        setWidth, sheetRecords.get(sheetIndex));
            }

            workbook.write(os);
            os.close();
            flg = true;
        } catch (Exception e) {
            flg = false;
            e.printStackTrace();
        }
        return flg;
    }

    /**
     * 导出Excel文件，直接将records数据写入客户端，效率相对较高
     * @param headFields    导出列表的表头
     * @param setWidth      设置列宽
     * @param records       要导出的数据
     * @param sheetName     页签名称
     * @param exportFileName    导出的文件名称（如：统计.xlsx）
     * @param response
     * @return
     */
    public static boolean exportExcelFile(List<String> headFields,
                                          Map<String, Integer> setWidth, List<Map<String, String>> records,
                                          String sheetName, String exportFileName, HttpServletResponse response) {
        boolean flag;

        try {
            OutputStream os = response.getOutputStream();
            response.reset();
            response.setHeader("Content-disposition", "attachment; filename="
                    + URLEncoder.encode(exportFileName, "UTF-8"));
            response.setContentType("application/msexcel");
            XSSFWorkbook workbook = new XSSFWorkbook();
            createSheet(workbook, sheetName, headFields, setWidth, records);
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
     * 导出多个页签的excel表,解决xls格式行数65535的限制
     * @param headFields
     * @param records
     * @param sheetName
     * @param response
     * @throws Exception
     */
    public void exportExcelFile(LinkedHashMap<String, String> headFields, Map<String, Integer> setWidth,
                        List<T> records, String sheetName, String exportFileName, HttpServletResponse response)
            throws Exception {
        OutputStream os = response.getOutputStream();
        response.reset();
        response.setHeader("Content-disposition", "attachment; filename="
                + URLEncoder.encode(exportFileName, "UTF-8"));
        response.setContentType("application/msexcel");

        HSSFWorkbook workbook = new HSSFWorkbook();

        Map<Integer, List<T>> sheetMap = pagination(records);
        Set<Integer> keys = sheetMap.keySet();

        for(Integer SheetKey : keys){
            HSSFSheet sheet = workbook.createSheet(sheetName + SheetKey);

            HSSFRow row = sheet.createRow(0);
            int cell = 0;
            for (String columnName : headFields.keySet()) {
                row.createCell(cell).setCellValue(columnName);
                if (setWidth != null) {
                    Integer width = setWidth.get(columnName);
                    if (width == null || width.equals(0)) {
                        int length = columnName.getBytes().length * 256;
                        // 仅适用中文
                        sheet.setColumnWidth(cell, length);
                        // 不适用中文
                        //sheet.autoSizeColumn(cell);
                    } else {
                        sheet.setColumnWidth(cell, width * 2 * 256);
                    }
                }
                cell++;
            }

            List<T> sheetRows = sheetMap.get(SheetKey);
            for (int i = 0, len = sheetRows.size(); i < len; i++) {
                T en = sheetRows.get(i);
                List<Object> dataList = reflectEntity(en, headFields.values());
                row = sheet.createRow(i + 1);
                for (int m = 0; m < dataList.size(); m++) {
                    row.createCell(m).setCellValue(dataList.get(m).toString());
                }
            }
        }
        workbook.write(os);
    }

    /**
     * 将服务器上的文件下载到客户端（用户浏览器）
     *
     * @param path     服务器上的文件路径（路径 + 文件名 + 后缀）
     * @param response
     */
    public static void downloadFromService(String path, HttpServletResponse response) throws IOException {
        File file = new File(path);
        String fileName = file.getName();
        InputStream fis = new BufferedInputStream(new FileInputStream(path));
        byte[] buffer = new byte[fis.available()];
        fis.read(buffer);
        fis.close();

        response.reset();
        response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        response.addHeader("Content-Length", "" + file.length());
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
        toClient.write(buffer);
        toClient.flush();
        toClient.close();
        file.delete();
    }

    /**
     * 创建一个页签
     *
     * @param workbook
     * @param sheetName
     * @param headFields
     * @param setWidth
     * @param records
     * @return
     */
    private static XSSFSheet createSheet(XSSFWorkbook workbook, String sheetName, List<String> headFields,
                                         Map<String, Integer> setWidth, List<Map<String, String>> records) {

        XSSFSheet sheet = workbook.createSheet(sheetName);
        XSSFRow row = sheet.createRow(0);

        int cell = 0;
        for (String columnName : headFields) {
            row.createCell(cell).setCellValue(columnName);
            if (setWidth != null) {
                Integer width = setWidth.get(columnName);
                if (width == null || width.equals(0)) {
                    // 仅适用中文
                    sheet.setColumnWidth(cell, columnName.getBytes().length * 256);
                    // 不适用中文
                    //sheet.autoSizeColumn(cell);
                } else {
                    sheet.setColumnWidth(cell, width * 2 * 256);
                }
            }

            cell++;
        }

        int rw = 1;
        for (Map<String, String> record : records) {
            XSSFRow xRow = sheet.createRow(rw);
            cell = 0;
            for (String columnName : headFields) {
                xRow.createCell(cell).setCellValue(record.get(columnName));
                cell++;
            }
            rw++;
        }

        return sheet;
    }

    /**
     * 使用反射技术，返回一行Excel记录
     * @param model
     * @param <T>
     * @return
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     * @throws SecurityException
     * @throws NoSuchFieldException
     */
    private static <T> List<Object> reflectEntity(T model, Collection<String> fields)
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Object> list = new ArrayList<Object>();

        for (String name : fields) {
            name = name.substring(0, 1).toUpperCase() + name.substring(1);

            Method m = model.getClass().getMethod("get" + name);
            Object value = m.invoke(model);
            list.add(value == null ? "" : value.toString());
        }

        return list;
    }

    /**
     * 将大集合分成多个子集合
     * @param allRecords
     * @return
     */
    private Map<Integer, List<T>> pagination(List<T> allRecords) {
        int totalPage = allRecords.size() / MAX_NUM_PER_SHEET;
        int mod = allRecords.size() % MAX_NUM_PER_SHEET;
        Map<Integer, List<T>> map = new HashMap();
        for (int i = 0; i < totalPage; i++) {
            List<T> subRecords;
            if (i == totalPage) {
                subRecords = allRecords.subList(i * MAX_NUM_PER_SHEET, MAX_NUM_PER_SHEET * i + mod);
            } else {
                subRecords = allRecords.subList(i * MAX_NUM_PER_SHEET, MAX_NUM_PER_SHEET * (i + 1));
            }
            map.put(i, subRecords);
        }
        return map;
    }




    /**
     * 获取第一个页签的第一行的表头信息
     *
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
     *
     * @param is
     * @return key：表示数据的索引；value：表示行数据，用“-”分割
     * @throws IOException
     */
    @Deprecated
    public Map<Integer, String> readExcelContent(InputStream is) throws IOException {
        String str = "";
        Map<Integer, String> content = new HashMap<Integer, String>();

        POIFSFileSystem poifsFileSystem = new POIFSFileSystem(is);
        ;
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
     *
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

        createExcelFile(headFields, null, records, titles, filePath);
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
        boolean flag = createExcelFile(headFields, null, records, "sheet1", filePath);
        if (flag) {
            // 将服务器上的文件下载到客户端（用户浏览器）
            downloadFromService(filePath, response);
        } else {
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().print("下载文件失败");
        }
    }
}
