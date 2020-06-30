package com.kuang.dao;

import com.kuang.pojo.Department;
import com.kuang.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author creator hujw 2020/6/22 13:51
 * @author updater
 * @version 1.0.0
 */
@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees = null;

    @Autowired
    private DepartmentDao departmentDao;
    static {
        employees = new HashMap<Integer, Employee>();

        employees.put(1001,new Employee(1001,"A","123@qq.com",1,new Department(101,"教学部"),new Date()));
        employees.put(1002,new Employee(1002,"B","123@qq.com",1,new Department(102,"市场部"),new Date()));
        employees.put(1003,new Employee(1003,"C","123@qq.com",1,new Department(103,"开发部"),new Date()));
        employees.put(1004,new Employee(1004,"D","123@qq.com",1,new Department(104,"运维部"),new Date()));
        employees.put(1005,new Employee(1005,"E","123@qq.com",1,new Department(105,"后勤部"),new Date()));
    }
    //主键自增
    private static Integer initId = 1006;

    //增加一个员工
    public void save(Employee employee){
        if(employee.getId() == null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));

        employees.put(employee.getId(),employee);
    }

    //查询全部员工信息
    public Collection<Employee> getAll(){
        return employees.values();
    }

    //通过id查询员工
    public Employee getEmplpueeById(Integer id){
        return employees.get(id);
    }

    //删除数据库
    public void delete(Integer id){
        employees.remove(id);
    }
}














