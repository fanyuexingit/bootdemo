/**
 * @description:
 * @author: Andy
 * @time: 2021/03/09 10:17
 */
package com.example.bootcache;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by fanyuexin on 2021/03/09
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class EhCacheTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CacheManager cacheManager;

    @Test
    public void test() throws Exception {
        // 创建1条记录
        userRepository.save(new User("AAA", 10, "AAA"));

        User u1 = userRepository.findByName("AAA");
        System.out.println("第一次查询：" + u1.getAge());

        User u2 = userRepository.findByName("AAA");
        System.out.println("第二次查询：" + u2.getAge());
    }

}
