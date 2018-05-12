package com.maple.web.carserver.utils;


import com.maple.web.carserver.dao.SaleDao;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelUtil {
    public static void exportSale(ServletOutputStream out, List<SaleDao> data) throws IOException {
        if (out == null || data == null || data.isEmpty()) {
            return;
        }
        final String titles[] = new String[]{"ID", "商品ID", "商品名称", "商品原价", "销售人员", "实际售价", "售出数量", "商品简介", "销售时间"};
        // 第一步，创建一个workbook，对应一个Excel文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = workbook.createSheet("sheet1");
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        HSSFRow row = sheet.createRow(0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        //居中样式
        cellStyle.setAlignment(HorizontalAlignment.CENTER);

        for (int i = 0; i < titles.length; i++) {
            HSSFCell cell = row.createCell(i);//列索引从0开始
            cell.setCellStyle(cellStyle);//列居中显示
            cell.setCellValue(titles[i]);//列名1
        }

        // 第五步，写入实体数据
        for (int i = 0; i < data.size(); i++) {
            row = sheet.createRow(i + 1);
            row.setRowStyle(cellStyle);
            SaleDao sale = data.get(i);

            // 第六步，创建单元格，并设置值
            row.createCell(0).setCellValue(sale.getId());
            row.createCell(1).setCellValue(sale.getGoodsId());
            row.createCell(2).setCellValue(sale.getName());
            row.createCell(3).setCellValue(sale.getPrice());
            row.createCell(4).setCellValue(sale.getSalerName());
            row.createCell(5).setCellValue(sale.getAmount());
            row.createCell(6).setCellValue(sale.getCount());
            row.createCell(7).setCellValue(sale.getIntroduction());
            row.createCell(8).setCellValue(sale.getDate());
        }

        // 第七步，将文件输出到客户端浏览器
        workbook.write(out);
        out.flush();
        out.close();
    }
}
