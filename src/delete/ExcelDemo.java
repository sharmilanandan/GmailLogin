package delete;

import generic.Excel;

public class ExcelDemo {
	public static void main(String[] args) {
		Excel.writeDataToExcel("./data/input.xlsx", "Sheet1");
		String v=Excel.getcellValue("./data/input.xlsx", "Sheet1",0, 0);
		System.out.println(v);
		String b=Excel.getcellValue("./data/input.xlsx", "Sheet1",0, 1);
		System.out.println(b);
	}

}
