//package com.example.mvplib.net;
//
//import android.util.Log;
//
//import java.io.IOException;
//import java.util.concurrent.TimeUnit;
//
//public class ApiRetrofit {
//
//    //        public final String BASE_SERVER_URL = "http://172.16.15.37:8020/";
//    private static ApiRetrofit apiRetrofit;
//    private Retrofit retrofit;
//    private OkHttpClient client;
//    private ApiServer apiServer;
//    private String TAG = "ApiRetrofit2";
//    public String token = "";
//
//    public OkHttpClient getClient() {
//        return client;
//    }
//
//    /**
//     * 请求访问quest
//     * response拦截器
//     */
//    private Interceptor interceptor = new Interceptor() {
//        @Override
//        public Response intercept(Chain chain) throws IOException {
//            Request request = chain.request()
//                    .newBuilder()
//                    .headers(chain.request().headers())
//                    .addHeader("Authorization", token==null?"":token)
//                    .build();
//
//            return chain.proceed(request);
//        }
//    };
//    private HttpLoggingInterceptor logInterceptor =
//            new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
//                @Override
//                public void log(String message) {
//                    try {
//                        logs(TAG, message);
////                        Log.i(TAG, message);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                        logs(TAG, message);
////                        Log.e(TAG, message);
//                    }
//                }
//            });
//
//
//    public void logs(String tag, String msg) {  //信息太长,分段打印
//        //因为String的length是字符数量不是字节数量所以为了防止中文字符过多，
//        //  把4*1024的MAX字节打印长度改为2001字符数
//        int max_str_length = 2001 - tag.length();
//        //大于4000时
//        while (msg.length() > max_str_length) {
//            Log.i(tag, msg.substring(0, max_str_length));
//            msg = msg.substring(max_str_length);
//        }
//        //剩余部分
//        Log.i(tag, msg);
//    }
//
//    public ApiRetrofit() {
//        logInterceptor.level(HttpLoggingInterceptor.Level.BODY);
//        RequestInterceptor requestInterceptor = new RequestInterceptor();
//        requestInterceptor.printLevel = AppConfig.IS_DUBUG ? RequestInterceptor.Level.ALL : RequestInterceptor.Level.NONE;
//        client = ProgressManager.getInstance().with(new OkHttpClient.Builder()
//                //添加log拦截器
//                .addInterceptor(interceptor)
//                .addNetworkInterceptor(requestInterceptor)
//                .connectTimeout(60, TimeUnit.SECONDS)
//                .readTimeout(60, TimeUnit.SECONDS))
//                .build();
//
//        retrofit = new Retrofit.Builder()
//                .baseUrl(ConstantsUtils.BASE_URL)
//                //去除Mutipart string 带有引号的问题
//                .addConverterFactory(ScalarsConverterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create())
//                //支持RxJava2
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .client(client)
//                .build();
//
//        apiServer = retrofit.create(ApiServer.class);
//    }
//
//    public static ApiRetrofit getInstance() {
//        if (apiRetrofit == null) {
//            synchronized (Object.class) {
//                if (apiRetrofit == null) {
//                    apiRetrofit = new ApiRetrofit();
//                }
//            }
//        }
//        return apiRetrofit;
//    }
//
//    public ApiServer getApiService() {
//        return apiServer;
//    }
//
//    public void setToken(String token) {
//        this.token = token;
//    }
//
//
//}
