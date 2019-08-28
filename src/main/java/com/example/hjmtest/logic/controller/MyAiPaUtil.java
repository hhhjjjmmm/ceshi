package com.example.hjmtest.logic.controller;

import cn.yueshutong.util.AiPaUtil;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class MyAiPaUtil extends AiPaUtil {
    @Override
    public Document getHtmlDocument(String link) throws IOException {
        // 你可以不用JSOUP，可以使用其它方法进行HTTP请求，但最后需要转为Document格式
        // 你也可以使用Jsoup实现定制属性
        Connection connection = Jsoup.connect(link).method(Connection.Method.GET);
      //  String body = connection.execute().charset("GBK").body();

        return Jsoup.parse(null);
    }

}
