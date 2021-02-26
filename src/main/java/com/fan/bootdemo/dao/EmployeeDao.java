/**
 * @description:
 * @author: Andy
 * @time: 2021/02/26 14:42
 */
package com.fan.bootdemo.dao;

import com.fan.bootdemo.entity.Department;
import com.fan.bootdemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Created by fanyuexin on 2021/02/26
 */
@Repository
public class EmployeeDao {

    private  static Map<Integer, Employee> employees = null;

    @Autowired
    private DepartmenDao departmenDao;

    static {
        employees = new HashMap<>();

        employees.put(101, new Employee(1001, "fanyeuxin1", 1, new Date(), "@163", new Department(101, "教学部")));
        employees.put(102, new Employee(1002, "fanyeuxin2", 0, new Date(), "@163", new Department(102, "市场部")));
        employees.put(103, new Employee(1003, "fanyeuxin3", 1, new Date(), "@163", new Department(103, "教研部")));
        employees.put(104, new Employee(1004, "fanyeuxin4", 0, new Date(), "@163", new Department(104, "运营部")));
        employees.put(105, new Employee(1005, "fanyeuxin5", 1, new Date(), "@163", new Department(105, "后勤部")));
    }

    private static Integer initId = 1006;

    public void save(Employee employee){
        if (employee.getId() == null) {
            employee.setId(initId++);
        }

        employees.put(employee.getId(), employee);
    }

    public Collection<Employee> getAll(){
        return employees.values();
    }

    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    public void deleteById(Integer id){
        employees.remove(id);
    }
}
