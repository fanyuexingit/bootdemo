/**
 * @description:
 * @author: Andy
 * @time: 2021/03/08 10:19
 */
package com.fan.bootdemo.datajpa;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by fanyuexin on 2021/03/08
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() throws Exception {

        // 创建10条记录
        userRepository.save(new Person("AAA", 10));
        userRepository.save(new Person("BBB", 20));
        userRepository.save(new Person("CCC", 30));
        userRepository.save(new Person("DDD", 40));
        userRepository.save(new Person("EEE", 50));
        userRepository.save(new Person("FFF", 60));
        userRepository.save(new Person("GGG", 70));
        userRepository.save(new Person("HHH", 80));
        userRepository.save(new Person("III", 90));
        userRepository.save(new Person("JJJ", 100));

        // 测试findAll, 查询所有记录
        Assert.assertEquals(10, userRepository.findAll().size());

        // 测试findByName, 查询姓名为FFF的User
        Assert.assertEquals(60, userRepository.findByName("FFF").getAge().longValue());

        // 测试findUser, 查询姓名为FFF的User
        Assert.assertEquals(60, userRepository.findUser("FFF").getAge().longValue());

        // 测试findByNameAndAge, 查询姓名为FFF并且年龄为60的User
        Assert.assertEquals("FFF", userRepository.findByNameAndAge("FFF", 60).getName());

        // 测试删除姓名为AAA的User
        userRepository.delete(userRepository.findByName("AAA"));

        // 测试findAll, 查询所有记录, 验证上面的删除是否成功
        Assert.assertEquals(9, userRepository.findAll().size());

    }

}
