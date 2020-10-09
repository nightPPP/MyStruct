package com.example.mvplib.net;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.HashMap;

/**
 * 网络管理请求
 */
public class RequestManager {
    private RequestQueue queue;
    private static volatile RequestManager instance;
    public static RequestManager getInstance(){
        if (instance == null){
            synchronized (RequestManager.class){
                if (instance == null){
                    instance = new RequestManager();
                }
            }
        }
        return instance;
    }
    public RequestQueue getRequestQueue(){
        return queue;
    }

    public void sendGet(String url, Class clazz, final MyListerner listener){
        MyRequest request = new MyRequest(url, clazz, new Response.Listener() {
            @Override
            public void onResponse(Object response) {
                listener.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onError(error.getMessage());
            }
        });
        addToRequestQueue(request);
    }

    public void sendPost(String url,
                         Class clazz,
                         final HashMap map,
                         final MyListerner listerner){
        MyRequest request = new MyRequest(Request.Method.POST,
                url, clazz,
                new Response.Listener() {
                    @Override
                    public void onResponse(Object response) {
                        listerner.onSuccess(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listerner.onError(error.getMessage());
            }
        });
        addToRequestQueue(request);

    }
    public void addToRequestQueue(Request req){
        getRequestQueue().add(req);
    }
}
