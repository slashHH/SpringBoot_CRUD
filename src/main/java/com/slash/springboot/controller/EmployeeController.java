package com.slash.springboot.controller;

import com.slash.springboot.dao.DepartmentDao;
import com.slash.springboot.dao.EmployeeDao;
import com.slash.springboot.entities.Department;
import com.slash.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();

        model.addAttribute("emps", employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmployee(Employee employee) {
        System.out.println("保存的员工信息为:" + employee
        );
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //跳转到编辑界面
    @GetMapping("/emp/{id}")
    public String toEdit(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    //edit功能
    @PutMapping("/emp/{id}")
    public String updateEmployee(Employee employee) {
        System.out.println("修改的员工为:" + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

}
