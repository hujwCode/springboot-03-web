package com.kuang.controller;

import com.kuang.dao.DepartmentDao;
import com.kuang.dao.EmployeeDao;
import com.kuang.pojo.Department;
import com.kuang.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

/**
 * @author : hujiawei
 * @version : 1.0.0
 * @date : 2020/6/22 10:08 下午
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model) {
        Collection<Department> deps = departmentDao.getDepartments();
        model.addAttribute("departments", deps);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        // 添加
        System.out.println("save=》" + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toUpdateEmp(@PathVariable("id") Integer id, Model model) {
        Employee emplpueeById = employeeDao.getEmplpueeById(id);
        model.addAttribute("emp", emplpueeById);
        Collection<Department> deps = departmentDao.getDepartments();
        model.addAttribute("departments", deps);
        return "emp/update";
    }

    @RequestMapping("/updateEmp")
    public String updateEmp(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @RequestMapping("/delemp/{id}")
    public String delEmp(@PathVariable("id") Integer id, Employee employee) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }

}
