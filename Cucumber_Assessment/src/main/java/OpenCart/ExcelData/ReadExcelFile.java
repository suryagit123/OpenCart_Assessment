package OpenCart.ExcelData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcelFile {

	@Test
	public ArrayList<String> getdata(String Testcasename) throws IOException {
		ArrayList<String> data = new ArrayList<String>();

		FileInputStream fis = new FileInputStream("C:\\Users\\surya k\\Documents\\TestDocument.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {
			
			if (workbook.getSheetName(i).equalsIgnoreCase("OpenCart")) {
				
				XSSFSheet sheet = workbook.getSheetAt(i);

				Iterator<Row> rows = sheet.iterator();// sheet is collection of rows
				
				while(rows.hasNext()) {
					
					 Row row1=rows.next();
					 
						Iterator<Cell> cell = row1.cellIterator();
						int k = 0;
						int coloumn = 0;
						
						while(cell.hasNext()) {
							Cell value=cell.next();
							  
							if(value.getStringCellValue().equalsIgnoreCase("OpenCartPages")) {
							      coloumn = k;
							}
								
							 
							  k++;
				}
						
						
						System.out.println(coloumn);
				
				/*
				 * Iterator<Cell> ce = firstrow.cellIterator();// row is collection of cells
				 * 
				 * int k = 0; int coloumn = 0; while (ce.hasNext()) {
				 * 
				 * Cell value = ce.next();
				 * 
				 * if (value.getStringCellValue().equalsIgnoreCase("TestCase")) { coloumn = k;
				 * 
				 * }
				 * 
				 * k++; */

						
//// scan entire testcase coloum 
				while (rows.hasNext()) {

					Row row2 = rows.next();
					
					if (row2.getCell(coloumn).getStringCellValue().equalsIgnoreCase(Testcasename)) {

//// pull all the data of that row 

						Iterator<Cell> cv = row2.cellIterator();
						while (cv.hasNext()) {
							Cell c = cv.next();

							
							  if(c.getCellTypeEnum()==CellType.STRING) {
							  
							data.add(c.getStringCellValue()); 
							  }
							  else{
							 
							 data.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							  }

						}
					}
				}

			}

		}}
	/*
	 * System.out.println(data.get(0)); System.out.println(data.get(1));
	 * System.out.println(data.get(2));
	 */
		 
return data;
	
	}}
