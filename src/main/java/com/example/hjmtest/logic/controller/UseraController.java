package com.example.hjmtest.logic.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hjmtest.logic.bean.Usera;
import com.example.hjmtest.logic.service.UseraService;
import com.example.hjmtest.logic.service.impl.UseraServiceImpl;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.SerializationUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.concurrent.CountDownLatch;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hjm
 * @since 2019-08-19
 */
@RestController
public class UseraController {

    @Autowired
    UseraServiceImpl useraService;
    @Autowired
    UseraService useraService1;

    @RequestMapping(value = "/test")
    public String test() {
        return useraService.list().toString();
    }

    @RequestMapping(value = "/test1")
    public String test1(Usera useras) {
        Usera usera1 = new Usera();
        int a = 2;
        Usera usera = useraService.test();
        return usera.toString();
    }

    private static List list = new Vector();

    public static void main(String[] args) throws InterruptedException {
    for (int i=1;i<10;i++){
        tests();
        list.clear();
    }
    }

    private static void tests() throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 1; i < 10000; i++) {
                list.add(i);
            }
        };
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println(list.size());
    }

    @RequestMapping(value = "/testa")
    public String testa() {
        return "asdsada";
    }

}



