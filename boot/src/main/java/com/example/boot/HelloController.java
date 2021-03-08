package com.example.boot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {

    @Value("${db}")
    private String db;

    @Value("${mq}")
    private String mq;

    @RequestMapping("/index")
    public String index() {
        log.info("db：" + db);
        log.info("mq：" + mq);
        return "";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World";
    }

}