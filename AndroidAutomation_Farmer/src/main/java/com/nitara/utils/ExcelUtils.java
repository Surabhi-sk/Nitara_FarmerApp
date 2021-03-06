package com.nitara.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;

public class ExcelUtils{
	
	public static List<Map<String,String>> getTestDetails(String sheetname) throws IOException{
		
		List<Map<String,String>> list = null;
		FileInputStream fs = null;
		
		String absPath = new File("src\\\\main\\\\resources\\\\TestData_FarmerAPK.xlsx").getAbsolutePath();
		
		
		try {
			fs = new FileInputStream(absPath);
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			System.out.println(workbook);
			XSSFSheet sheet = workbook.getSheet(sheetname);
			System.out.println(sheet);
			
			int lastrow = sheet.getLastRowNum();
			int lastcol = sheet.getRow(0).getLastCellNum();
			
			
			Map<String,String> map = null;
			list = new ArrayList<>();
			
			for(int i=1; i<=lastrow;i++) {
				map = new HashMap<>();
				for(int j=0;j<lastcol; j++) {
					String key = sheet.getRow(0).getCell(j).getStringCellValue();
					System.out.println(key);
					if( sheet.getRow(i).getCell(j) == null ||sheet.getRow(i).getCell(j).getCellType() == CellType.BLANK) {
						continue;
					}
					if(sheet.getRow(i).getCell(j).getCellType() == CellType.STRING) {
						String value = sheet.getRow(i).getCell(j).getStringCellValue();
						map.put(key, value);
					}
					else if( DateUtil.isCellDateFormatted(sheet.getRow(i).getCell(j))){
						SimpleDateFormat format = new SimpleDateFormat("ddmmmyyyy");
						String dateValue = format.format(sheet.getRow(i).getCell(j).getDateCellValue());
						map.put(key, dateValue);
					}
					else {
					
				}
				
			}
				list.add(map);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			try {
				if(Objects.nonNull(fs)) {
					fs.close();
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	
	public  Map<String,String> getTestData(String sheetname, String scenario) throws IOException {

		FileInputStream fs = null;
		Map<String,String> map = null;
		
		String absPath = new File("src\\\\main\\\\resources\\\\TestData_FarmerAPK.xlsx").getAbsolutePath();
		
			fs = new FileInputStream(absPath);
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			System.out.println(workbook);
			XSSFSheet sheet = workbook.getSheet(sheetname);
			System.out.println(sheet);
			

			XSSFCell cell ;

			int  row = findRow(sheet,scenario);

			if(row==-1) {
				System.out.println("No such test data available");
				workbook.close();
				return null;
			}
			
			
			int lastrow = sheet.getLastRowNum();
			int lastcol = sheet.getRow(0).getLastCellNum();
			
			map = new HashMap<>();
				for(int j=1;j<lastcol; j++) {
				
					String key = sheet.getRow(0).getCell(j).getStringCellValue();
					System.out.println(key);
				
				if( sheet.getRow(row).getCell(j) == null ||sheet.getRow(row).getCell(j).getCellType() == CellType.BLANK) {
					continue;
				}
				if(sheet.getRow(row).getCell(j).getCellType() == CellType.STRING) {
					String value = sheet.getRow(row).getCell(j).getStringCellValue();
					System.out.println(value);
					System.out.println(key);
					map.put(key, value);
				}
				else if( DateUtil.isCellDateFormatted(sheet.getRow(row).getCell(j))){
					SimpleDateFormat format = new SimpleDateFormat("ddmmmyyyy");
					String dateValue = format.format(sheet.getRow(row).getCell(j).getDateCellValue());
					System.out.println(dateValue);
					map.put(key, dateValue);
				}
				
				System.out.println(map);

				}
			workbook.close();
		return(map);		

	}

	
	public static int findRow(XSSFSheet sheet, String cellContent) {
	for (Row row : sheet) {
		for (Cell cell : row) {
			if (cell.getCellType() == CellType.STRING) {
				if (cell.getRichStringCellValue().getString().trim().equals(cellContent)) {
					return row.getRowNum();  
				}
			}
		}
	}               
	return -1;
}
	

}
