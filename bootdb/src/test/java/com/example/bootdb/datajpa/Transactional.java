/**
 * @description:
 * @author: Andy
 * @time: 2021/03/08 16:22
 */
package com.example.bootdb.datajpa;

import lombok.extern.slf4j.Slf4j;
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
public class Transactional {

    @Autowired
    private PersonRepository personRepository;

    @Test
    @org.springframework.transaction.annotation.Transactional
    public void test() throws Exception {

        personRepository.deleteAll();

        // 创建10条记录
        personRepository.save(new Person("AAA", 10));
        personRepository.save(new Person("BBB", 20));
        personRepository.save(new Person("CCC", 30));
        personRepository.save(new Person("DDD", 40));
        personRepository.save(new Person("EEE", 50));
        personRepository.save(new Person("FFF", 60));
        personRepository.save(new Person("GGG", 70));
        personRepository.save(new Person("HHH", 80));
        personRepository.save(new Person("III", 90));
        personRepository.save(new Person("JJJ", 100));

        // 省略后续的一些验证操作
    }
}
