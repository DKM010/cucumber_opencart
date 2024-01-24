package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




public class DataReader {
	
public static List<HashMap<String,String>> data(String utilpath,String sheetname) throws IOException {
	 HashMap <String,String> map=new HashMap<String,String>();
	 List<HashMap <String,String>> mydata=new ArrayList<>();
	
	FileInputStream file=new FileInputStream(utilpath);
	XSSFWorkbook workbook = new XSSFWorkbook(file) ;
		XSSFSheet sheet=workbook.getSheet(sheetname);
		int row_no=sheet.getPhysicalNumberOfRows();
		int cell_no=sheet.getRow(0).getPhysicalNumberOfCells();
        Row Header_row=sheet.getRow(0);
		
		for(int i=1;i<row_no;i++) {
			HashMap<String,String> map_data=new HashMap<>();
			
		 for(int c=0;c<cell_no;c++) {
			 
		Cell cell_value=sheet.getRow(i).getCell(c);
		 map_data.put(Header_row.getCell(c).getStringCellValue(),cell_value.getStringCellValue());
		 }	
		
		mydata.add(map_data);
		}	
		return mydata;
}
}