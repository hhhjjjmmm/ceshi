package com.example.hjmtest.logic.controller;



import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket=null;
        Socket client=null;
        try {
            serverSocket=new ServerSocket(9999);
            System.out.println("服务器初始化完成。端口9999");

            while (true){
                client=serverSocket.accept();

                InputStream in=client.getInputStream();
                HttpRequest request = new HttpRequest(in);
                String url=request.getUrl();
                OutputStream outputStream=client.getOutputStream();
                HttpResponse response=new HttpResponse(outputStream);
                System.out.println(url.substring(1)+"sssssfsfs");
                response.writerFile(url.substring(1));
                client.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
