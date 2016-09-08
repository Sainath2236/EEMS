package com.virtusa.eems.file.download;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.virtusa.eems.beans.Voucher;
 
/**
 * This class builds an Excel spreadsheet document using Apache POI library.
 * @author www.codejava.net
 *
 */
public class VoucherListExcelBuilder extends AbstractExcelView {
 
    @SuppressWarnings("unchecked")
	@Override
    protected void buildExcelDocument(Map<String, Object> vouchers,
            HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // get data model which is passed by the Spring container
        List<Voucher> vouchers1 = (List<Voucher>) vouchers.get("vouchersList");
         
        // create a new Excel sheet
        HSSFSheet sheet = workbook.createSheet("Vouchers");
        sheet.setDefaultColumnWidth(30);
         
        // create style for header cells
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Arial");
        style.setFillForegroundColor(HSSFColor.BLUE.index);
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setColor(HSSFColor.WHITE.index);
        style.setFont(font);
         
        // create header row
        HSSFRow header = sheet.createRow(0);
         
        header.createCell(0).setCellValue("Voucher Id");
        header.getCell(0).setCellStyle(style);
         
        header.createCell(1).setCellValue("Employee Id");
        header.getCell(1).setCellStyle(style);
        
        header.createCell(2).setCellValue("Title");
        header.getCell(2).setCellStyle(style);
         
        header.createCell(3).setCellValue("Description");
        header.getCell(3).setCellStyle(style);
        
        header.createCell(4).setCellValue("Amount");
        header.getCell(4).setCellStyle(style);
         
        header.createCell(5).setCellValue("Date");
        header.getCell(5).setCellStyle(style);
        
        header.createCell(6).setCellValue("Status");
        header.getCell(6).setCellStyle(style);
         
        header.createCell(7).setCellValue("Level");
        header.getCell(7).setCellStyle(style);
       
        // create data rows
        int rowCount = 1;
         
        for (Voucher voucher : vouchers1) {
            HSSFRow aRow = sheet.createRow(rowCount++);
            aRow.createCell(0).setCellValue(voucher.getVoucherId());
            aRow.createCell(1).setCellValue(voucher.getEmployeeId());
            aRow.createCell(2).setCellValue(voucher.getTitle());
            aRow.createCell(3).setCellValue(voucher.getDescription());
            aRow.createCell(4).setCellValue(voucher.getAmount());
            aRow.createCell(5).setCellValue(voucher.getDate());
            aRow.createCell(6).setCellValue(voucher.getStatus());
            aRow.createCell(7).setCellValue(voucher.getLevel());
           
        }
    }
 
}