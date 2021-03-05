/**
 * @description:
 * @author: Andy
 * @time: 2021/03/04 15:32
 */
package com.fan.bootdemo.controller;

import com.fan.bootdemo.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

/**
 * Created by fanyuexin on 2021/03/04
 */
@Api(tags = {"用户tag"})
@RestController //@Controller + @ResponseBody
@RequestMapping(value = "/user")
public class UserController {

    // 创建线程安全的Map，模拟users信息的存储
    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<>());


    // GET
    @ApiOperation(value = "获取user", notes="detail notes")
    @GetMapping(value = "/")
    public List<User> getUsers() {
        List<User> list = new ArrayList<User>(users.values());
        return list;
    }

    // GET
    // url中的id可通过@PathVariable绑定到函数的参数中
    // 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
    @ApiOperation(value = "获取user", notes="detail notes")
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return users.get(id);
    }

    // POST
    // @Valid JSR-303 校验
    // @RequestBody注解用来绑定通过http请求中application/json类型上传的数据
    @ApiOperation(value = "新增user", notes="detail notes")
    @PostMapping(value = "/")
    public String postUser(@Valid @RequestBody User user) {
        users.put(user.getId(), user);
        return "success";
    }

    // PUT
    @ApiOperation(value = "更改user", notes="detail notes")
    @PutMapping("/{id}")
    public String putUserById(@PathVariable Long id, @RequestBody User user) {
        User u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id, u);
        return "success";
    }

    // DELETE
    @ApiOperation(value = "删除user", notes="detail notes")
    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable Long id) {
        users.remove(id);
        return "success";
    }
}
