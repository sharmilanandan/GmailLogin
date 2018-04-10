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
	public static void writeDataToExcel(String exlpath,String sheet){
		Scanner sc=new Scanner(System.in);
		Reporter.log("Enter your username or mobile no",true);
	   String userEmail=sc.nextLine();
	   Reporter.log("Enter your password ",true);
	    String pwd=sc.nextLine(); 
		try {
			Workbook wb=WorkbookFactory.create(new FileInputStream(exlpath));
			wb.getSheet(sheet).createRow(0).createCell(0).setCellValue(userEmail);
			wb.getSheet(sheet).getRow(0).createCell(1).setCellValue(pwd);
			wb.write(new FileOutputStream(exlpath));
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
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
