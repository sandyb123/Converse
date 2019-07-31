package com.pc.generalUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import net.bytebuddy.asm.Advice.Return;

public class Fetchdata extends baseTest {
	public static ArrayList<String> excelData(String path, String sheetName, String Scenario) throws IOException
	{
		ArrayList<String> a= new ArrayList<String>();
	
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+path);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		int sheets=workbook.getNumberOfSheets();
		for(int i=0;i<sheets;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase(sheetName))
			{
				
				XSSFSheet sheet=workbook.getSheetAt(i);
				for(int j=0;j<=sheet.getLastRowNum();j++)
				{
					
					
					Row excelRows = sheet.getRow(j);
					
					if(excelRows.getCell(0).getStringCellValue().equalsIgnoreCase(Scenario))
					{
						for(int k=0;k<excelRows.getLastCellNum();k++)
						{
						Cell cellValue = excelRows.getCell(k);
							if(cellValue == null)
							{
								break;
							}
							else if(cellValue.getCellTypeEnum()==CellType.STRING)
							{
								
								a.add(cellValue.getStringCellValue());
								
							}	
							else if(cellValue.getCellType()==CellType.NUMERIC)
							{
								
								a.add(NumberToTextConverter.toText(cellValue.getNumericCellValue()));
								
							}
							
							else
							{
								
								a.add(Boolean.toString(cellValue.getBooleanCellValue()));
								
							}
						}
					}
				}
			}
		}
		
		workbook.close();
		
		
		return a;	
		
	}
	
	public static ArrayList<String> cardData(String path, String sheetName, String Scenario) throws IOException
	{
		ArrayList<String> a= new ArrayList<String>();
	
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+path);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		int sheets=workbook.getNumberOfSheets();
		for(int i=0;i<sheets;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase(sheetName))
			{
				
				XSSFSheet sheet=workbook.getSheetAt(i);
				for(int j=0;j<=sheet.getLastRowNum();j++)
				{
					
					
					Row excelRows = sheet.getRow(j);
					
					if(excelRows.getCell(0).getStringCellValue().equalsIgnoreCase(Scenario))
					{
						for(int k=0;k<excelRows.getLastCellNum();k++)
						{
						Cell cellValue = excelRows.getCell(k);
							if(cellValue == null)
							{
								break;
							}
							else if(cellValue.getCellTypeEnum()==CellType.STRING)
							{
								
								a.add(cellValue.getStringCellValue());
								
							}	
							else if(cellValue.getCellType()==CellType.NUMERIC)
							{
								
								a.add(NumberToTextConverter.toText(cellValue.getNumericCellValue()));
								
							}
							
							else
							{
								
								a.add(Boolean.toString(cellValue.getBooleanCellValue()));
								
							}
						}
					}
				}
			}
		}
		
		workbook.close();
		
		
		return a;	
		
	}
	
	public static ArrayList<String> getLocaleInfo(String path, String sheetName) throws IOException {
		ArrayList<String> b= new ArrayList<String>();
		Cell cell = null;
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+path);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		int sheets=workbook.getNumberOfSheets();
		for(int i=0;i<sheets;i++) 
		
		{
			if(workbook.getSheetName(i).equalsIgnoreCase(sheetName))
			{
		XSSFSheet sheet=workbook.getSheetAt(i);
		for (int rowIndex = 0; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
			  XSSFRow row = sheet.getRow(rowIndex);
			  if (row != null) {
			     cell = row.getCell(0);
			     b.add(cell.getStringCellValue());
			    if (cell != null) {
			      // Found column and there is value in the cell.
			      String cellValueMaybeNull = cell.getStringCellValue();
			      // Do something with the cellValueMaybeNull here ...
			    }
			  }
			}
		totalRow = sheet.getLastRowNum();
		}
		}
		
		return b;
	}
	
	public static ArrayList<String> getcardInfo(String path, String sheetName) throws IOException {
		ArrayList<String> c= new ArrayList<String>();
		Cell cell = null;
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+path);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		int sheets=workbook.getNumberOfSheets();
		for(int i=0;i<sheets;i++) 
		
		{
			if(workbook.getSheetName(i).equalsIgnoreCase(sheetName))
			{
		XSSFSheet sheet=workbook.getSheetAt(i);
		for (int rowIndex = 0; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
			  XSSFRow row = sheet.getRow(rowIndex);
			  if (row != null) {
			     cell = row.getCell(0);
			     c.add(cell.getStringCellValue());
			    if (cell != null) {
			      // Found column and there is value in the cell.
			      String cellValueMaybeNull = cell.getStringCellValue();
			      // Do something with the cellValueMaybeNull here ...
			    }
			  }
			}
		totalCard = sheet.getLastRowNum();
		}
		}
		
		return c;
	}
	
}
