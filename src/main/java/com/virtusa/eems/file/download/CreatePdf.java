package com.virtusa.eems.file.download;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.virtusa.eems.beans.Voucher;
import com.virtusa.eems.service.EmployeeService;

public class CreatePdf {
	
	
	
		
	private Font TIME_ROMAN = new Font(Font.FontFamily.TIMES_ROMAN, 18,Font.BOLD);
	private Font TIME_ROMAN_SMALL = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
	
	
	@Autowired
	private EmployeeService employeeService;
	
	public Document createPDF(String file,Voucher voucher) {

		Document document = null;
		
		try {
			document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(file));
			document.open();

			addMetaData(document,voucher);

			addTitlePage(document,voucher);

			createTable(document,voucher);

			document.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return document;

	}

	private void addMetaData(Document document,Voucher voucher) {
		document.addTitle("Voucher-"+voucher.getVoucherId());
		document.addSubject("Voucher-"+voucher.getVoucherId());
		document.addAuthor("Voucher-"+voucher.getVoucherId());
		document.addCreator("Voucher-"+voucher.getVoucherId());
	}

	private void addTitlePage(Document document,Voucher voucher)
			throws DocumentException {
		
		//Employee employee = employeeService.getEmployee(voucher.getEmployeeId());
		
		Paragraph preface = new Paragraph();
		createEmptyLine(preface, 1);
		preface.add(new Paragraph("Voucher Details", TIME_ROMAN));

		createEmptyLine(preface, 1);
		//SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
		//preface.add(new Paragraph( "Employee Name : "+employee.getName(), TIME_ROMAN_SMALL));
		preface.add(new Paragraph( "Employee Id : "+voucher.getEmployeeId(), TIME_ROMAN_SMALL));
		document.add(preface);

	}

	private void createEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}

	private void createTable(Document document,Voucher voucher) throws DocumentException {
		Paragraph paragraph = new Paragraph();
		createEmptyLine(paragraph, 2);
		document.add(paragraph);
		PdfPTable table = new PdfPTable(6);

		PdfPCell c1 = new PdfPCell(new Phrase("Voucher Id"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Title"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Description"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		
		c1 = new PdfPCell(new Phrase("Amount"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		
		c1 = new PdfPCell(new Phrase("Date"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		
		c1 = new PdfPCell(new Phrase("Status"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		
		table.setHeaderRows(1);

			table.setWidthPercentage(100);
		
			//table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
			//table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(""+voucher.getVoucherId());
			table.addCell(""+voucher.getTitle());
			table.addCell(""+voucher.getDescription());
			table.addCell(""+voucher.getAmount());
			table.addCell(""+voucher.getDate());
			table.addCell(""+voucher.getStatus());

		document.add(table);
	}
	
	public ByteArrayOutputStream convertPDFToByteArrayOutputStream(String fileName) {

		InputStream inputStream = null;
		ByteArrayOutputStream baos =null;
		try {

			inputStream = new FileInputStream(fileName);
			byte[] buffer = new byte[1024];
			baos = new ByteArrayOutputStream();

			int bytesRead;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				baos.write(buffer, 0, bytesRead);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return baos;
	}
}
