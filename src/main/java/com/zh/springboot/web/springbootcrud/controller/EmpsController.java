package com.zh.springboot.web.springbootcrud.controller;

import com.zh.springboot.web.springbootcrud.dao.DepartmentDao;
import com.zh.springboot.web.springbootcrud.dao.EmployeeDao;
import com.zh.springboot.web.springbootcrud.entities.Department;
import com.zh.springboot.web.springbootcrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @Auther: Administrator
 * @Date: 2018/11/14 20:04
 * @Description:
 */
@Controller
public class EmpsController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employee = employeeDao.getAll();
        model.addAttribute("emps",employee);
        //System.out.println("访问了");
        return "emps/list";
    }

    @GetMapping("/emp")
    public String showAdd(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emps/add";
    }


    @PutMapping("/emp")
    public String goAdd(Employee employee,Model model){
//        if(employee.getId()!=0 &&employee.getId()!=null){
//            model.addAttribute("emp",employee);
//        }
        //System.out.println(employee.toString());
        System.out.println("修改的员工数据："+employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String update(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emps/add";
    }
    @PostMapping("/emp")
    public String goUpdate(Employee employee,Model model){
        System.out.println("修改的员工数据："+employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String goDelete(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        System.out.println(id);
        return "redirect:/emps";
    }
}
