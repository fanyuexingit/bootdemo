package com.example.boot;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
class BootApplicationTests {

    private MockMvc mvc;

    @Before
    public void setUp() {}

    @Test
    public void restTest() throws Exception {

        mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();

        RequestBuilder request;

        request = get("/hello");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hello World")));
    }

}
