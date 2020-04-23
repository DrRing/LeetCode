package base;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpUtil {

  private static Logger logger = LoggerFactory.getLogger(OkHttpUtil.class);
  private static final OkHttpClient client = new OkHttpClient();

  private static final MediaType jsonMediaType = MediaType.parse("application/json; charset=utf-8");
  private static final MediaType xmlMediaType = MediaType.parse("application/xml; charset=utf-8");

  /**
   * @param connectionTime 设置连接超时时间
   * @param readTime       设置读取超时时间
   */
  public static String postJson(String path, String json, Integer connectionTime, Integer readTime) {
    OkHttpClient client = new OkHttpClient();
    client.newBuilder().connectTimeout(connectionTime, TimeUnit.SECONDS)
        .readTimeout(readTime, TimeUnit.SECONDS)
        .build();
    RequestBody body = RequestBody.create(jsonMediaType, json);
    // 3 创建请求方式
    Request request = new Request.Builder().url(path).post(body).build();
    try {
      return client.newCall(request).execute().body().string();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
  /**
   * @param connectionTime 设置连接超时时间
   * @param readTime       设置读取超时时间
   */
  public static String postJsonWithConnectionTime(String path, String json,Long connectionTime,Long readTime,Long writeTime) {
	  OkHttpClient client = new OkHttpClient.Builder()
//		        .connectTimeout(60 * 1000, TimeUnit.MILLISECONDS)
//		        .readTimeout(5 * 60 * 1000, TimeUnit.MILLISECONDS)
//		        .writeTimeout(5 * 60 * 1000, TimeUnit.MILLISECONDS)
		        .connectTimeout(connectionTime, TimeUnit.MILLISECONDS)
		        .readTimeout(readTime, TimeUnit.MILLISECONDS)
		        .writeTimeout(writeTime, TimeUnit.MILLISECONDS)
		        .build();
    RequestBody body = RequestBody.create(jsonMediaType, json);
    // 3 创建请求方式
    Request request = new Request.Builder().url(path).post(body).build();
    try {
      return client.newCall(request).execute().body().string();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
  /**
   * @param connectionTime 设置连接超时时间
   * @param readTime       设置读取超时时间
   */
  public static String putJson(String path, String json) {
    OkHttpClient client = new OkHttpClient();
    client.newBuilder().build();
    RequestBody body = RequestBody.create(jsonMediaType, json);
    // 3 创建请求方式
    Request request = new Request.Builder().url(path).put(body).build();
    try {
      return client.newCall(request).execute().body().string();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
  /**
   * execute
   */
  public static String execute(Request request) {
    try {
      return client.newCall(request).execute().body().string();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * get
   */
  public static String get(String url) {
    return execute(new Request.Builder().url(url).get().build());
  }

  public static String getMethod(String url, Map<String, Object> urlParams, Map<String, Object> headerParams) {
    Request request = new Request.Builder()
        .url(url + setUrlParams(urlParams))
        .headers(setHeaders(headerParams)).get().build();
    Call call = client.newCall(request);
    logger.info("Http info:" + request.toString());
    //logger.info("Http Header:" + request.headers().toString());
    try {
      Response response = call.execute();
      String result = response.body().string();
      ;
      //logger.info("Http Result:" + result);
      if (response.isSuccessful()) {
        return result;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
  /**
   * @param connectionTime 设置连接超时时间
   * @param readTime       设置读取超时时间
   */
  public static String postJsonWithHeader(String path, String json,Map<String, Object> headerParams) {
    OkHttpClient client = new OkHttpClient();
    RequestBody body = RequestBody.create(jsonMediaType, json);
    // 3 创建请求方式
    Request request = new Request.Builder().url(path).headers(setHeaders(headerParams)).post(body).build();
    try {
      return client.newCall(request).execute().body().string();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
  /**
   * 设置Header头
   */
  private static Headers setHeaders(Map<String, Object> headersParams) {
    /*Map<String,Object> headers = new HashMap<String,Object>();
    headers.put("Content-Type","application/json");
    headers.put("Connection","Upgrade, HTTP2-Settings");
    headers.put("Upgrade","h2c");*/
    Headers headers = null;
    Headers.Builder headerBuilder = new Headers.Builder();
    if (headersParams != null) {
      for (String key : headersParams.keySet()) {
        headerBuilder.add(key, headersParams.get(key).toString());
      }
    }
    headers = headerBuilder.build();
    return headers;
  }

  /**
   * 设置get连接拼接参数
   */
  private static String setUrlParams(Map<String, Object> params) {
    StringBuffer param = new StringBuffer();
    int i = 0;
    if (params == null) {
      return param.toString();
    }
    for (String key : params.keySet()) {
      if (i == 0) {
        param.append("?");
      } else {
        param.append("&");
      }
      try {
        param.append(key).append("=").append(URLEncoder.encode(params.get(key).toString(), "UTF-8"));  //字符串拼接
      } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
      }
      i++;
    }
    return param.toString();
  }

  /**
   * post
   */
  public static String post(String url, RequestBody body) {
    return execute(new Request.Builder().url(url).post(body).build());
  }


  /**
   * post
   */
  public static String post(String url, Map<String, Object> formMap) {
    FormBody.Builder form = new FormBody.Builder();
    if (formMap != null && !formMap.isEmpty()) {
      for (String key : formMap.keySet()) {
        form.add(key, formMap.get(key).toString());
      }
      return post(url, form.build());
    }
    return null;
  }

  /**
   * post
   */
  public static String post(String url, String body, MediaType mediaType) {
    return post(url, RequestBody.create(mediaType, body));
  }

  /**
   * post (json)
   */
  public static String postJson(String url, String body) {
    return post(url, body, jsonMediaType);
  }

  /**
   * post (xml)
   */
  public static String postXml(String url, String body) {
    return post(url, body, xmlMediaType);
  }

  /**
   *
   * @param url
   * @param body
   * @param timeout
   */
  public static void asyncPostJson(String url, String body, Long timeout) {
    if (timeout == null) {
      timeout = 3L;
    }
    OkHttpClient client = new OkHttpClient.Builder().readTimeout(timeout, TimeUnit.SECONDS).build();
    Request request = new Request.Builder().url(url)
        .post(RequestBody.create(jsonMediaType, body)).build();
    Call call = client.newCall(request);
    call.enqueue(new Callback() {
      @Override
      public void onFailure(Call call, IOException e) {
        logger.info("异步请求失败");
        //System.out.println("Fail");
        //stringBuilder.append("异步请求失败");
      }

      @Override
      public void onResponse(Call call, Response response) throws IOException {
        //stringBuilder.append(response.body().string());
        logger.info(response.body().string());
        //System.out.println(response.body().string());
        //stringBuilder.append(response.body().string());
      }
    });

  }
  /**
  *
  * @param url
  * @param body
  * @param timeout
  */
 public static void asyncPostJson(String url, String body, Long timeout,Callback callback) {
   if (timeout == null) {
     timeout = 3L;
   }
   OkHttpClient client = new OkHttpClient.Builder().readTimeout(timeout, TimeUnit.SECONDS).build();
   Request request = new Request.Builder().url(url)
       .post(RequestBody.create(jsonMediaType, body)).build();
   Call call = client.newCall(request);
   call.enqueue(callback);
 }
}