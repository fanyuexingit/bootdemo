/**
 * @description:
 * @author: Andy
 * @time: 2021/02/26 14:32
 */
package com.fan.bootdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by fanyuexin on 2021/02/26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private Integer id;
    private String name;
    private Integer gender;
    private Date birthday;
    private String email;
    private Department department;

}
