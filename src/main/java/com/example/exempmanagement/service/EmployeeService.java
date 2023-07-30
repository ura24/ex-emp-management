package com.example.exempmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.exempmanagement.domain.Employee;
import com.example.exempmanagement.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * 従業員情報を全件取得する
     * @return 従業員情報全件
     */
    public List<Employee> showList() {
        return employeeRepository.findAll();
    }
    
}
