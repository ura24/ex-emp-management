package com.example.exempmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
     * 従業員情報を取得し、詳細画面に表示
     * @param model 画面にデータを渡す
     * @param form IDを取得する
     * @return 従業員詳細画面
     */
    @GetMapping("/showDetail")
    public String showDetail(String id, Model model, UpdateEmployeeForm form) {
        Employee employee = employeeService.showDetail(Integer.valueOf(id));
        form.setName(employee.getName());
        form.setImage(employee.getImage());
        form.setGender(employee.getGender());
        form.setHireDate(String.valueOf(employee.getHireDate()));
        form.setMailAddress(employee.getMailAddress());
        form.setZipCode(employee.getZipCode());
        form.setAddress(employee.getAddress());
        form.setTelephone(employee.getTelephone());
        form.setSalary(String.valueOf(employee.getSalary()));
        form.setCharacteristics(employee.getCharacteristics());
        form.setDependentsCount(String.valueOf(employee.getDependentsCount()));

        model.addAttribute("updateEmployeeForm", form);
        return "employee/detail";
    }

    /**
     * 従業員詳細(扶養人数)を更新する
     * @param form 従業員のIDと扶養人数
     * @return 従業員一覧画面
     */
    @PostMapping("update")
    public String update(@Validated UpdateEmployeeForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return showDetail(form.getId(), model, form);
        }
        Employee employee = employeeService.showDetail(Integer.valueOf(form.getId()));
        employee.setDependentsCount(Integer.valueOf(form.getDependentsCount()));
        employeeService.update(employee);
        return "redirect:/employee/showList";
    }
}
