package com.example.exempmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.exempmanagement.domain.Employee;
import com.example.exempmanagement.form.UpdateEmployeeForm;
import com.example.exempmanagement.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;

    /**
     * 従業員リストを取得し、一覧画面に表示
     * @param model 画面にデータを渡す
     * @return 従業員一覧画面
     */
    @GetMapping("/showList")
    public String showList(Model model) {
        List<Employee> employeeList = employeeService.showList();
        model.addAttribute("employeeList", employeeList);
        return "employee/list";
    }
    
    /**
     * 従業員情報を取得し、週際画面に表示
     * @param model 画面にデータを渡す
     * @param form IDを取得する
     * @return 従業員詳細画面
     */
    @GetMapping("/showDetail")
    public String showDetail(String id, Model model, UpdateEmployeeForm form) {
        Employee employee = employeeService.showDetail(Integer.valueOf(id));
        model.addAttribute("employee", employee);
        return "employee/detail";
    }
}
