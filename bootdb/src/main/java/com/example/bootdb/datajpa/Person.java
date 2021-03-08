/**
 * @description:
 * @author: Andy
 * @time: 2021/03/08 9:57
 */
package com.example.bootdb.datajpa;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;

/**
 * Created by fanyuexin on 2021/03/08
 */
//@Entity注解标识了User类是一个持久化的实体
@Entity
@Data
@NoArgsConstructor
public class Person {

    //@Id和@GeneratedValue用来标识User对应对应数据库表中的主键
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Max(50)
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}