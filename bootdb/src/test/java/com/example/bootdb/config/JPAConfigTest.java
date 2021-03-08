/**
 * @description:
 * @author: Andy
 * @time: 2021/03/08 15:56
 */
package com.example.bootdb.config;

import com.example.bootdb.datajpa.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by fanyuexin on 2021/03/08
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class JPAConfigTest {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Test
    public void test() throws Exception {
        personRepository.save(new Person("aaa", 10));
        personRepository.save(new Person("bbb", 20));
        personRepository.save(new Person("ccc", 30));
        personRepository.save(new Person("ddd", 40));
        personRepository.save(new Person("eee", 50));

        Assert.assertEquals(5, personRepository.findAll().size());

        messageRepository.save(new Message("o1", "aaaaaaaaaa"));
        messageRepository.save(new Message("o2", "bbbbbbbbbb"));
        messageRepository.save(new Message("o3", "cccccccccc"));

        Assert.assertEquals(3, messageRepository.findAll().size());
    }

}
