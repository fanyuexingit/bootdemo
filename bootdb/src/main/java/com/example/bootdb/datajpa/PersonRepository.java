/**
 * @description:
 * @author: Andy
 * @time: 2021/03/08 10:01
 */
package com.example.bootdb.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by fanyuexin on 2021/03/08
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findByName(String name);

    Person findByNameAndAge(String name, Integer age);

    @Query("from Person u where u.name=:name")
    Person findUser(@Param("name") String name);
}
