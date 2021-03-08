/**
 * @description:
 * @author: Andy
 * @time: 2021/03/08 14:16
 */
package com.example.bootdb.bootjdbc;

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
public class BootJdbcTest {

    @Autowired
    private UserService userService;

    @Test
    public void jdbcTemplateTest() throws Exception {

        userService.deleteAllUser();

        for (int i=0; i < 5; i++){
            User user = new User();
            user.setId((long) i);
            user.setName("fan" + i);
            user.setAge(i);
            user.setEmail("123@mail.com" + i);
            userService.createUser(user);
        }

        User user = userService.getUserById(new Long("3"));
        Assert.assertEquals("fan3",user.getName());

        Assert.assertEquals(5, userService.getAllUser().size());

    }
}
