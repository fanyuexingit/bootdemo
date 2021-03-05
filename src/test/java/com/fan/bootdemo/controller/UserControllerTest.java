/**
 * @description:
 * @author: Andy
 * @time: 2021/03/04 15:35
 */
package com.fan.bootdemo.controller;

import com.fan.bootdemo.entity.User;
import com.fan.bootdemo.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Created by fanyuexin on 2021/03/04
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    private MockMvc mvc;

    @Autowired
    private UserService userSerivce;

    @Before
    public void setUp() { }

    @Test
    public void restTest() throws Exception {

        mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();

        RequestBuilder request;

        request = get("/users/");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));



        request = post("/users/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1,\"name\":\"测试大师\",\"age\":20}");
        mvc.perform(request)
                .andExpect(content().string(equalTo("success")));



        request = get("/users/");
        ResultActions resultActions = mvc.perform(request);
        resultActions
                .andReturn()
                .getResponse()
                .setCharacterEncoding("UTF-8");
        resultActions
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"测试大师\",\"age\":20}]")));



        request = put("/users/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"测试终极大师\",\"age\":30}");
        mvc.perform(request)
                .andExpect(content().string(equalTo("success")));



        request = get("/users/1");
        resultActions = mvc.perform(request);
        resultActions
                .andReturn()
                .getResponse()
                .setCharacterEncoding("UTF-8");
        resultActions
                .andExpect(content().string(equalTo("{\"id\":1,\"name\":\"测试终极大师\",\"age\":30}")));



        request = delete("/users/1");
        mvc.perform(request)
                .andExpect(content().string(equalTo("success")));



        request = get("/users/");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));

    }

    @Test
    public void jdbcTemplateTest() throws Exception {

        userSerivce.deleteAllUser();

        for (int i=0; i < 5; i++){
            User user = new User();
            user.setId((long) i);
            user.setName("fan" + i);
            user.setAge(i);
            user.setEmail("123@mail.com" + i);
            userSerivce.createUser(user);
        }

        User user = userSerivce.getUserById(new Long("3"));
        Assert.assertEquals("fan3",user.getName());

        Assert.assertEquals(5, userSerivce.getAllUser().size());

    }
}
