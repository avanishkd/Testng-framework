package com.mindtree.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class XLutil {

	Workbook workBook;
	Sheet sheet;
	String path;
	int r;
	int c;

	public Object[][] getInputs(String path) throws EncryptedDocumentException, InvalidFormatException, IOException {

		this.path = path;
		this.workBook = WorkbookFactory.create(new File(path));
		this.sheet = workBook.getSheetAt(0);
		this.r = sheet.getLastRowNum();
		this.c = sheet.getRow(1).getLastCellNum();

		String[][] arr = new String[r][c-1];

		int row = 0;
		int col = 0;
		for (int i = 1; i <= r; i++) {
			for (int j = 1; j < c; j++) {
				arr[row][col++] = sheet.getRow(i).getCell(j) + "";
			}
			col = 0;
			row++;
		}

		return arr;
	}
	
	public Object[][] getInputsAsMap(String path) throws EncryptedDocumentException, InvalidFormatException, IOException{
		
		this.path = path;
		this.workBook = WorkbookFactory.create(new File(path));
		this.sheet = workBook.getSheetAt(0);
		this.r = sheet.getLastRowNum();
		this.c = sheet.getRow(0).getLastCellNum();
		
	    Object[][] obj = new Object[r][1];

	    for (int i = 0; i < r; i++) {
	      Map<Object, Object> datamap = new HashMap<>();
	      for (int j = 0; j < c; j++) {
	        datamap.put(sheet.getRow(0).getCell(j).toString(), sheet.getRow(i+1).getCell(j).toString());
	      }
	      obj[i][0] = datamap;

	    }
	    
	    return obj;

	}

	public void writeStatus(String status, int row)
			throws IOException, EncryptedDocumentException, InvalidFormatException {

		FileInputStream fi = new FileInputStream(new File(path));
		workBook = WorkbookFactory.create(fi);
		Sheet sheet = workBook.getSheetAt(0);

		Cell cell = sheet.getRow(row).createCell(c);
		cell.setCellType(CellType.STRING);
		cell.setCellValue(status);

		FileOutputStream fout = new FileOutputStream(path);
		workBook.write(fout);
		fout.close();
	}
}
