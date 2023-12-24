package com.tutorialNinja.Utils;

import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.microsoft.schemas.office.visio.x2012.main.CellType;

public class Utilities {
	
	public static final int IMPLICIT_WAIT_TIME=10;
	public static final int PAGE_LOAD_TIME=10;
public static  String   genrateEmailTimeStamp() {
	

	
		
		Date date = new Date();
		String timeStamp = date.toString().replace(" ", "_").replace(":", "_");
			return "PavanMishra" +timeStamp + "@gmail.com";

}

/*public static void getTestDataFromExcel(String sheetName) {
	
	XSSFWorkbook    wb = new XSSFWorkbook();
	XSSFSheet sheet = wb.getSheet(sheetName);
	int rows =sheet.getLastRowNum();
	int cols = sheet.getRow(0).getLastCellNum();
	
	Object[][] data  = new 	Object[rows][cols];
	
	
	for(int i =0;i<rows;i++) {
		
	XSSFRow row = sheet.getRow(i+1);
		
		for(int j=0;j<cols;j++) {
			
			XSSFCell cT = row.getCell(j);
                 int  cellType = cT.getCellType()
			
			switch(cellType) {
		
			case INT:
			}
	*/		
		
			
			
		}
		
	
