/**
 * CopyRight DuHong on 12:54:21 AM. All rights reversed. Declared in GitHub and Local both!
 */
package du.tech.xls;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class testxls {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(new FileInputStream("C:/Programs/a_test/info.xls"));
		HSSFSheet sheet = hssfWorkbook.getSheet("Sheet1"); 

		for (Row row : sheet) {
			for (Cell cell : row) {
				if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
					System.out.println(cell.getStringCellValue());
				} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
					System.out.println(cell.getNumericCellValue());
				}
			}
		}

		
		
		
	}

}


