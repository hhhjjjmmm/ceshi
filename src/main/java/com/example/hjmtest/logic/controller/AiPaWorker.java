package com.example.hjmtest.logic.controller;

import cn.yueshutong.util.AiPaUtil;
import org.jsoup.nodes.Document;

public interface AiPaWorker<T,S> {
    T run(Document doc, AiPaUtil util);
    S fail(String link);
}
