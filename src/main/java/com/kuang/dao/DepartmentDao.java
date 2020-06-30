package com.kuang.dao;

import com.kuang.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author creator hujw 2020/6/22 13:46
 * @author updater
 * @version 1.0.0
 */
@Repository
public class DepartmentDao {
    private static Map<Integer, Department> departments = null;
    static {
        departments = new HashMap<Integer, Department>();

        departments.put(101,new Department(101,"教学部"));
        departments.put(102,new Department(102,"市场部"));
        departments.put(103,new Department(103,"开发部"));
        departments.put(104,new Department(104,"运维部"));
        departments.put(105,new Department(105,"后勤部"));
    }

    /**
     * 获取所有部门信息
     * @return 结果
     */
    public Collection<Department> getDepartments(){
        return departments.values();
    }

    /**
     * 通过id获取部门信息
     * @param id
     * @return 结果
     */
    Department getDepartmentById(Integer id){
        return departments.get(id);
    }
}
