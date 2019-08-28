package com.example.hjmtest.logic.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class test {

    public static void main(String[] args) {
        interUitl("http://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=18737873431", "");
    }
public  static void interUitl(String path,String data){
    try {
        //新建链接地址
        URL url=new URL(path);
        //打开和地址之间连接
        HttpURLConnection conn= (HttpURLConnection) url.openConnection();
        PrintWriter out=null;
        //设置请求头
        //conn.setRequestMethod("post");
        //设置请求属性
        conn.setRequestProperty("accept","*/*");
        conn.setRequestProperty("connection","keep-Alive");
        conn.setRequestProperty("Accept","application/json");
        conn.setRequestProperty("Accept-Language","zh-CN,zh;q=0.9");
        conn.setRequestProperty("user-agnet", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");
        conn.setDoOutput(true);
        conn.setDoInput(true);
        //获取conn对应的输出流
        out=new PrintWriter(conn.getOutputStream());
        out.print(data);
        out.flush();
        //获取conn对应的输入流
        InputStream is=conn.getInputStream();
        //构造一个字符流缓存
        BufferedReader br=new BufferedReader(new InputStreamReader(is,"gbk"));
        String str="";
        while ((str=br.readLine())!=null){
            System.out.println(str);
        }
        //关闭流
        is.close();
        //断开连接
        conn.disconnect();
        System.out.println("结束");
    } catch (Exception e) {
        e.printStackTrace();
    }
}

}
