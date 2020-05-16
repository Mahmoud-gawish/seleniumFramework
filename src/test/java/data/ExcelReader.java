package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelReader {
	
	
	static FileInputStream fis = null;
	public FileInputStream getFileInputStram() {
		
		String filePath = System.getProperty("user.dir")+"\\src\\test\\java\\data\\userData.xlsx";
		File srcFile = new File(filePath);
		
		try {
			fis = new FileInputStream(srcFile);
		} catch (FileNotFoundException e) {
			System.out.println("test file data not file terminata process :  check file path of test data" );
			System.exit(0);
		}
		return fis;
	}
	
	public Object [][]getExcelData() throws IOException{
		
		fis = getFileInputStram();
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		
		int totalNumberOfRrows = (sheet.getLastRowNum()+1);
		int totalNumberOfCols = 4;
		
		String[][] arrayExcelData = new String[totalNumberOfRrows][totalNumberOfCols];
		
		for (int i = 0; i < totalNumberOfRrows; i++) {
			for (int j = 0; j < totalNumberOfCols; j++) {
				
				XSSFRow row = sheet.getRow(i);
				arrayExcelData[i][j] = row.getCell(j).toString();
				
			}
			
		}
		
		wb.close();
		return arrayExcelData;
		
		
	}

}
