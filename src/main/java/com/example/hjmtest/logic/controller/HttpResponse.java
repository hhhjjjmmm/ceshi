package com.example.hjmtest.logic.controller;

import java.io.*;

public class HttpResponse {
    private OutputStream os=null;
    public HttpResponse(OutputStream os){
        this.os=os;
    }

    public  void writerFile(String path) throws IOException {
        FileInputStream fis=new FileInputStream(path);
        byte[] bytes=new byte[1024];
        int len=0;
        StringBuffer sb=new StringBuffer();
        sb.append("HTTP/1.1 200 OK\n");
        sb.append("Content-Type:text/html;charset=UTF-8\n");
        sb.append("\r\n");

        os.write(sb.toString().getBytes());
        while ((len=fis.read(bytes))!=-1){
            os.write(bytes,0,len);
        }
        fis.close();
        os.flush();
        os.close();
    }
}
