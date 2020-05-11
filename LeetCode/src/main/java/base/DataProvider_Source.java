package base;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import config_util.getProperty;
import constructor.operateExcel;

public class DataProvider_Source {
	@Test
	@DataProvider(name = "SendSms")
	private Iterator<Object[]> SendSmsProvider() throws IOException {
		List<Object[]> result = new ArrayList<Object[]>();
		String sheetname = "test";
		String pathString = "C:\\Users\\Administrator\\Desktop\\0312.xlsx";
		String url = getProperty.getProperty("testhost") + getProperty.getProperty("login_url");
		List<Map<String, Object>> cases_list = operateExcel.excel_re_map(pathString, sheetname);
		Iterator it = cases_list.iterator();
		while (it.hasNext()) {
			result.add(new Object[] { it.next() });
		}
		return result.iterator();
	}
//	@DataProvider(name="loginData")
//	private Iterator<Object[]> LoginDataProvider() throws IOException {
//	    List<Object[]> result=new ArrayList<Object[]>();
//	    SqlSession session=DatabaseUtil.getSqlSession();
//	    List<Object> alldata=session.selectList("loginTestAll");
//	    Iterator it=alldata.iterator();
//	    while(it.hasNext()){
//	    result.add(new Object[] { it.next() });
//	    }
//	    return  result.iterator();
//
//	}

	public static void main(String[] args) {
		List<Object[]> result = new ArrayList<Object[]>();
		String sheetname = "Case_sendsms";
		String pathString = "C:\\Users\\Administrator\\Desktop\\0312.xlsx";
		String url = getProperty.getProperty("testhost") + getProperty.getProperty("login_url");
		List<Map<String, Object>> cases_list = operateExcel.excel_re_map(pathString, sheetname);
		// System.out.println(cases_list);

		Iterator it = cases_list.iterator();
		while (it.hasNext()) {
			result.add(new Object[] { it.next() });
		}
		System.out.println(result.size());
	}
}
