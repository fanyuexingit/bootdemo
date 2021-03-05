/**
 * @description:
 * @author: Andy
 * @time: 2021/03/05 14:38
 */
package com.fan.bootdemo.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by fanyuexin on 2021/03/05
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class InfoControllerTest {

    private MockMvc mockMvc;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(new InfoController()).build();
    }

    @Test
    public void infoControllerTest() throws Exception {
        RequestBuilder requestBuilder;



        requestBuilder = get("/info/getUser");

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));
    }
}
