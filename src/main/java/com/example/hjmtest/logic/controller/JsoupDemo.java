package com.example.hjmtest.logic.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.PrintWriter;


public class JsoupDemo {
    public static void main(String[] args) {
        try {
            //通过jsoup 的Connect获取document类
            Document document=Jsoup.connect("http://www.haie.edu.cn/xyxw.htm").get();
            System.out.println("打印网页标题:"+document.title());
            //根据class获取Element类
            Elements elements=document.getElementsByClass("c125126");
            Elements elements1=document.getElementsByClass("timestyle125126");
            //指定文件名及路径
            File file=new File("D:\\Jsoup\\title.txt");
            File file1=new File("D:\\Jsoup\\content.txt");
            if (!file.exists()){
                file.createNewFile();
            }
            if (!file1.exists()){
                file.createNewFile();
            }
            //写入本地
            PrintWriter pw=new PrintWriter("D:\\Jsoup\\title.txt");
            PrintWriter pw1=new PrintWriter("D:\\Jsoup\\content.txt");
            for (int i=0;i<elements.size();i++){
                pw.println(elements.get(i).text());
                pw.println(elements.get(i).attr("href"));
                pw.println(elements1.get(i).text());
                pw.println("-----------");
            }
            pw.close();
            for (int i=0;i<elements.size();i++){
                String href=elements.get(i).attr("href");
                String schoolhref="http://www.haie.edu.cn/";
                //因为取出来的新闻url不规范，直接访问不了，需要将其拼接成正常的网页url
                String contentHref = schoolhref+href;
                //重复第一步的内容，根据URL取Documet类
                Document contentDoc = Jsoup.connect(contentHref).get();
                //继续观察网页，取出新闻详细页面的文字。
                Elements contentElement = contentDoc.getElementsByClass("contentstyle125127");
                Elements authorElement = contentDoc.getElementsByClass("authorstyle125127");
                String content = contentElement.text();
                String author = authorElement.text();
                //打印出作者，新闻详细内容
                pw1.println(author);
                pw1.println(content);
                pw1.println("---------------------------");
            }
            pw1.close();
        }catch (Exception e){

            e.printStackTrace();
        }
    }
}
