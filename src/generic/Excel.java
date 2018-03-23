 package generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;

public class Excel {

	//writing data into Excel sheet
	
	
	public static String getcellValue(String excelpath,String sheet,int r,int c)
	{
		String v="";
		try {
			Workbook wb=WorkbookFactory.create(new FileInputStream(excelpath));
			v=wb.getSheet(sheet).getRow(r).getCell(c).toString();
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
			
			e.printStackTrace();
		}
		return v;
	}

	

	
}
