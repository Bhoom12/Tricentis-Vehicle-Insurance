package basePackage;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/***
 * 
 * @author Bhomika
 *
 */
public class DataReader {
	/**
	 * used to fetch Vaule of the key passed
	 * 
	 * @param key provid keyname
	 * @return returns keyValue in String form
	 */
	public static String fromPropertyFile(String key) {
		File absPath = new File("./src/test/resources/Url.properties");
		FileInputStream fis;
		Properties properties = null;
		try {
			fis = new FileInputStream(absPath);
			properties = new Properties();
			properties.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties.getProperty(key);
	}

	/**
	 * used to fetch stringValueData from Excel
	 * 
	 * @param sheetname provide sheetName
	 * @param rownum   provide row Number of the cell
	 * @param cellnum  provide column Number of the cell
	 * @return returns StringValue present in the cell
	 */
	public static String fromExcelFileForString(String sheetname, int rownum, int cellnum) {
		FileInputStream fis;
		Workbook workbook = null;
		try {
			fis = new FileInputStream("./src/test/resources/TestData.xlsx");
			workbook = WorkbookFactory.create(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return workbook.getSheet(sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
	}

	/**
	 * used to fetch NumericValueData from Excel
	 * 
	 * @param sheetname provide sheetName
	 * @param rownum   provide row Number of the cell
	 * @param cellnum  provide column Number of the cell
	 * @return returns Numeric0Value present in the cell in the double form
	 */
	public static double fromExcelFileForNumber(String sheetname, int rownum, int cellnum) {
		FileInputStream fis;
		Workbook workbook = null;
		try {
			fis = new FileInputStream("./src/test/resources/TestData.xlsx");
			workbook = WorkbookFactory.create(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return workbook.getSheet(sheetname).getRow(rownum).getCell(cellnum).getNumericCellValue();
	}

	/**
	 * used to fetch booleanValueData from Excel
	 * 
	 * @param sheetname provide sheetName
	 * @param rownum   provide row Number of the cell
	 * @param cellnum  provide column Number of the cell
	 * @return returns booleanValue present in the cell
	 */
	public static boolean fromExcelFileForBoolean(String sheetname, int rownum, int cellnum) {
		FileInputStream fis;
		Workbook workbook = null;
		try {
			fis = new FileInputStream("./src/test/resources/TestData.xlsx");
			workbook = WorkbookFactory.create(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return workbook.getSheet(sheetname).getRow(rownum).getCell(cellnum).getBooleanCellValue();
	}

	/**
	 * used to fetch LocalDateTimeValueData from Excel
	 * 
	 * @param sheetnum provide sheetName
	 * @param rownum   provide row Number of the cell
	 * @param cellnum  provide column Number of the cell
	 * @return returns LocalDateTimeValue present in the cell
	 */
	public static LocalDateTime fromExcelFileForDateTime(String sheetnum, int rownum, int cellnum) {
		FileInputStream fis;
		Workbook workbook = null;
		try {
			fis = new FileInputStream("./src/test/resources/TestData.xlsx");
			workbook = WorkbookFactory.create(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return workbook.getSheet(sheetnum).getRow(rownum).getCell(cellnum).getLocalDateTimeCellValue();
	}

	/**
	 * used to fetch multiple data from excel sheet in 2D from
	 * @param SheetName provide sheetName
	 * @return data in the form of 2D string array
	 */
	public static String[][] ToReadMultipleDataFromExcel2D(String SheetName) {
		FileInputStream fis;
		Workbook workbook = null;
		try {
			fis = new FileInputStream("./src/test/resources/TestData.xlsx");
			workbook = WorkbookFactory.create(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		Sheet sheet = workbook.getSheet(SheetName);
		int row = sheet.getPhysicalNumberOfRows() -1;
		int col = sheet.getRow(0).getPhysicalNumberOfCells();
		String data[][] = new String[row][col];
		for (int i = 1, h = 0; i <= row; i++, h++) {
			for (int j = 0; j < col; j++) {
				data[h][j] = sheet.getRow(i).getCell(j).toString();
			}
		}
		return data;
	}
	
	/**
	 * used to fetch single column data from excel in string array form
	 * @param SheetName provide shhet name
	 * @return returns string array
	 */
	public String[] ToRead1columnDataFromExcel(String SheetName) {
		FileInputStream fis;
		Workbook workbook = null;
		try {
			fis = new FileInputStream("./src/test/resources/TestData.xlsx");
			workbook = WorkbookFactory.create(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		Sheet sheet = workbook.getSheet(SheetName);
		int row = sheet.getPhysicalNumberOfRows() - 1;
		
		String data[] = new String[row];
		for (int i = 0; i < row; i++) {
				data[i] = sheet.getRow(i+1).getCell(0).toString();
		}
		return data;
	}
	public static String getTestData(String TestCaseName,String SheetName) {
		//String testNo = "TC3";
		String TestData=null;
		String[][] h = DataReader.ToReadMultipleDataFromExcel2D(SheetName);
		for (int i = 0; i < h.length; i++) {
			if (h[i][0].equals(TestCaseName)) {
				TestData= h[i][1];
			}
		}
		return TestData;
		
	}
	public static String[] getTestDataForDataProvider(String TestCaseName, String SheetName) {
		int count = 0;
		String[][] h = DataReader.ToReadMultipleDataFromExcel2D(SheetName);
		int index = 0;
		for (int i = 0; i < h.length; i++) {
			if (h[i][0].equals(TestCaseName)) {
				count++;

			}
		}
		String d[] = new String[count];
		for (int i = 0; i < h.length; i++) {
			if (h[i][0].equals(TestCaseName)) {
				count++;
				System.out.println((h[i][1]));
				d[index++] = (h[i][1]).toString();
			}
		}
		return d;
	}
	public static String[][] ToReadDataBasedOnTC(String SheetName,String testNo) {
		FileInputStream fis;
		Workbook workbook = null;
		try {
			fis = new FileInputStream("./src/test/resources/TestData.xlsx");
			workbook = WorkbookFactory.create(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		Sheet sheet = workbook.getSheet(SheetName);
		int row = sheet.getPhysicalNumberOfRows();
		int colAr = 0;
		int rowAr = 0;
		for (int i = 0; i < row; i++) {
			String cellValue = workbook.getSheet(SheetName).getRow(i).getCell(0).toString();
			if (cellValue.equals(testNo)) {
				rowAr++;
				colAr = sheet.getRow(i).getPhysicalNumberOfCells();
			}
		}
		String data[][] = new String[rowAr][colAr];
		for (int i = 0, h = 0; i < row; i++) {
			String cellValue = sheet.getRow(i).getCell(0).toString();
			if (cellValue.equals(testNo)) {
				for (int j = 0; j < colAr; j++) {
					data[h][j] = sheet.getRow(i).getCell(j).toString();
				}
				h++;
			}
		}
		return data;
	}
	
}
