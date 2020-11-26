package com.example.mvplib.net;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;


/**
 * @author smart
 */
public class RequestNet<T> extends Request<T>{

    private Gson mGSon;
    private Class mClass;
    private Response.Listener mListener;
    public RequestNet(String url,
                      Class clazz,
                      Response.Listener listener,
                      Response.ErrorListener errorListener){
        this(Request.Method.GET,url,clazz,listener,errorListener);
    }
    public RequestNet(int method,
                      String url,
                      Class clazz,
                      Response.Listener listener,
                      Response.ErrorListener errorListener){
        super(method,url,errorListener);
        mGSon=new Gson();
        mClass=clazz;
        mListener=listener;
    }
    @Override
    protected Response parseNetworkResponse(NetworkResponse response){
        try{
            String json=new String(response.data,
                    HttpHeaderParser.parseCharset(response.headers));
            return Response.success(mGSon.fromJson(json,mClass),
                    HttpHeaderParser.parseCacheHeaders(response));
        }catch(UnsupportedEncodingException e){
            return Response.error(
                    new ParseError(e));
        }
    }
    @Override
    protected void deliverResponse(T response){
        mListener.onResponse(response);
    }
}
