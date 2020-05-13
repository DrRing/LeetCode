package constructor;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class operateExcel {
	public static List<Map<String, Object>> excel_re_map(String url, String sheetname) {
		XSSFWorkbook book;
		XSSFSheet sheet;
		Row row = null;
		Row row2 = null;
		ArrayList<Map<String, Object>> list_questsArrayList = new ArrayList<Map<String, Object>>();
		File xlsFile = new File(url);
		try {
			InputStream stream = new FileInputStream(xlsFile);
			book = new XSSFWorkbook(stream);
			sheet = book.getSheet(sheetname);
			String title[] = null;
			String cotent[] = null;
			for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
				row = sheet.getRow(0);
				row2 = sheet.getRow(i);
				if (row != null) {
					title = new String[row.getLastCellNum()];
					cotent = new String[row.getLastCellNum()];
					Map<String, Object> m = new HashMap<String, Object>();
					for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {
						title[y] = row.getCell(y).toString();
						if (row2.getCell(y) != null) {
							cotent[y] = row2.getCell(y).toString();
						} else {
							cotent[y] = null;
						}
						m.put(title[y], cotent[y]);
					}
					list_questsArrayList.add(m);
				}
			}
		} catch (Exception e) {

			System.out.println(e);
		}
		return list_questsArrayList;
	}

	public static List<Map<String, Object>> excel_re_map2(String url) {
		XSSFWorkbook book;
		XSSFSheet sheet;
		Row row = null;
		Row row2 = null;
		ArrayList<Map<String, Object>> list_questsArrayList = new ArrayList<Map<String, Object>>();
		File xlsFile = new File(url);

		try {
			InputStream stream = new FileInputStream(xlsFile);

			book = new XSSFWorkbook(stream);
			sheet = book.getSheetAt(0);
			// sheet = book.getSheet(sheetname);
			String title[] = null;
			String cotent[] = null;
			for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
				row = sheet.getRow(0);
				row2 = sheet.getRow(i);
				if (row != null) {
					title = new String[row.getLastCellNum()];
					cotent = new String[row.getLastCellNum()];
					Map<String, Object> m = new HashMap<String, Object>();
					for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {
						title[y] = row.getCell(y).toString();
						if (row2.getCell(y) != null) {
							cotent[y] = row2.getCell(y).toString();
						} else {
							cotent[y] = null;
						}
						m.put(title[y], cotent[y]);
					}
					list_questsArrayList.add(m);
				}
			}
		} catch (Exception e) {

			System.out.println(e);
		}
		return list_questsArrayList;
	}

//	public static void main(String[] args) {
//
//
//	}
}
