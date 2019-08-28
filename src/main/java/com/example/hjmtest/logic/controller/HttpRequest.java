package com.example.hjmtest.logic.controller;

import java.io.IOException;
import java.io.InputStream;

public class HttpRequest {
    private   String url;

    public String getUrl() {
        return url;
    }

    public HttpRequest(InputStream in){
    resolverRequest(in);
}
public void resolverRequest(InputStream in){
    byte[] buff=new byte[1024];
    int legth=0;
    try {
        legth=in.read(buff);
        if (legth>0){
            String msg=new String(buff,0,legth);
            System.out.println("客户端请求信息："+msg+"******");
            url=msg.substring(msg.indexOf("/"),msg.indexOf("HTTP/1.1")-1);
        }else {
            System.out.println("Bad Requst *****");
        }
    }catch (IOException e){
        e.printStackTrace();
    }
}
}
