package generic_libraries;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {
	/**
	 * this method is used to Read Data From Excel
	 * @param sheetName
	 * @param rowNo
	 * @param celNo
	 * @return
	 * @throws Exception
	 */
	public String readDataFromExcel(String sheetName ,int rowNo,int celNo) throws Exception
	{
		FileInputStream fis = new FileInputStream(IPathConstants.excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		String value = sh.getRow(rowNo).getCell(celNo).getStringCellValue();
		return value;
	}
	/**
	 * this method is used to read Multiple Data from Excel
	 * @param sheetName
	 * @return
	 * @throws Exception
	 */
	public  ArrayList<String> readMultipleDataExcel(String sheetName) throws Exception
	{
		FileInputStream fis = new FileInputStream(IPathConstants.excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int rowCount = sh.getLastRowNum();
		int lastCellNum = sh.getRow(1).getLastCellNum();

		ArrayList<String> list = new ArrayList<String>();

		for(int i=0; i<=rowCount;i++)
		{
			for (int j=0;j<lastCellNum;j++)
			{
				String value = sh.getRow(i).getCell(j).getStringCellValue();
				list.add(value);
			}
		}
		return list;

	}
	/**
	 * this method is used to read Total Number Of RowCount
	 * @param sheetName
	 * @return
	 * @throws Exception
	 */
	public int readTotalNumberOfRowCount(String sheetName) throws Exception
	{
		FileInputStream fis = new FileInputStream(IPathConstants.excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int rowCount = sh.getLastRowNum();
		return rowCount;

	}
	/**
	 * this method is used to get Cell Count
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getCellCount(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IPathConstants.excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		short cellcount = sh.getRow(1).getLastCellNum();
		return cellcount;
	}
	/**
	 * this method is used to write Data Into Excel
	 * @param sheetName
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String sheetName,String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IPathConstants.excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(1);
		Cell cel = row.createCell(0);
		cel.setCellType(CellType.STRING);
		cel.setCellValue(value);

		FileOutputStream fos = new FileOutputStream(IPathConstants.excelpath);
		wb.write(fos);
		wb.close();
	}
}

//Note: only For String values--  //setCellType(CellType.STRING)  -- //setCellValue(String value)