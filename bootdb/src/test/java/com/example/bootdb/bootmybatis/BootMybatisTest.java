/**
 * @description:
 * @author: Andy
 * @time: 2021/03/08 14:51
 */
package com.example.bootdb.bootmybatis;

import com.example.bootdb.bootjdbc.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by fanyuexin on 2021/03/08
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class BootMybatisTest {

//    @Autowired
    @Resource
    private UserMapper userMapper;

    @Test
    @Rollback
    public void test() throws Exception {
        userMapper.deleteByName("AAA");
        userMapper.insert("AAA", 20, "asdfg");
        User u = userMapper.findByName("AAA");
        Assert.assertEquals(20, u.getAge().intValue());
    }

    @Test
    @Rollback
    public void testUserMapper() throws Exception {
        List<User> userList = userMapper.findAll();
        for(User user : userList) {
            Assert.assertEquals(null, user.getId());
            Assert.assertNotEquals(null, user.getName());
        }
    }
}
