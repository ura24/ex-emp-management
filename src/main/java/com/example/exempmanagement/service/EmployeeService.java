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
    
    /**
     * IDから従業員情報を取得する
     * @param id 取得したい従業員のID
     * @return IDに合致した従業員情報
     */
    public Employee showDetail(Integer id) {
        return employeeRepository.load(id);
    }
}
