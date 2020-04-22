//package config_util;
//
//import okhttp3.*;
//import org.apache.commons.lang3.exception.ExceptionUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.alibaba.fastjson.JSON;
//import com.google.gson.Gson;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.Iterator;
//import java.util.Map;
//
//public class OkHttpUtil1 {
//	// private static final Logger logger =
//	// LoggerFactory.getLogger(OkHttpUtil.class);
//
//	private static OkHttpClient okHttpClient = new OkHttpClient();
//
//	private static final MediaType jsonMediaType = MediaType.parse("application/json; charset=utf-8");
//
//	private static Gson gson = new Gson();
//
//	public OkHttpUtil1(OkHttpClient okHttpClient) {
//		OkHttpUtil1.okHttpClient = okHttpClient;
//	}
//
//	public static String get(String url, Map<String, String> queries) {
//		String responseBody = "";
//		StringBuffer sb = new StringBuffer(url);
//		if (queries != null && queries.keySet().size() > 0) {
//			boolean firstFlag = true;
//			Iterator iterator = queries.entrySet().iterator();
//			while (iterator.hasNext()) {
//				Map.Entry entry = (Map.Entry<String, String>) iterator.next();
//				if (firstFlag) {
//					sb.append("?" + entry.getKey() + "=" + entry.getValue());
//					firstFlag = false;
//				} else {
//					sb.append("&" + entry.getKey() + "=" + entry.getValue());
//				}
//			}
//		}
//		Request request = new Request.Builder().url(sb.toString()).build();
//		Response response = null;
//		try {
//			response = okHttpClient.newCall(request).execute();
//			if (response.isSuccessful()) {
//				return response.body().string();
//			}
//		} catch (Exception e) {
//			// logger.error("okhttp3 put error >> ex = {}",
//			// ExceptionUtils.getStackTrace(e));
//		} finally {
//			if (response != null) {
//				response.close();
//			}
//		}
//	}
//}
