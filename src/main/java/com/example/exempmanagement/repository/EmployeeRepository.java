package com.example.exempmanagement.repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.exempmanagement.domain.Employee;

@Repository
public class EmployeeRepository {
    
    @Autowired
    private NamedParameterJdbcTemplate template;

    private final static RowMapper<Employee> EMPLOYEE_ROW_MAPPER = (rs, i) -> {
        Employee employee = new Employee();
        employee.setId(rs.getInt("id"));
        employee.setName(rs.getString("name"));
        employee.setImage(rs.getString("image"));
        employee.setGender(rs.getString("gender"));
        employee.setHireDate(Date.valueOf(rs.getString("hire_date")));
        employee.setMailAddress(rs.getString("mail_address"));
        employee.setZipCode(rs.getString("zip_code"));
        employee.setAddress(rs.getString("address"));
        employee.setSalaly(rs.getInt("salary"));
        employee.setCharacteristics(rs.getString("characteristics"));
        employee.setDependentsCount(rs.getInt("dependents_count"));
        return employee;
    };

    /**
     * 従業員情報を入社日順(降順)で取得する
     * 従業員が存在しない場合はサイズ0の従業員一覧を返す
     * @return
     */
    public List<Employee> findAll() {
        String findAllSql = 
            "SELECT id, name, image, gender, hire_date, mail_address, zip_code, adderss, salary, charracteristics, dependents_count " + 
            "FROM employees ORDER BY hire_date DISC";
        List<Employee> employeeList = new ArrayList<>();
        employeeList = template.query(findAllSql, EMPLOYEE_ROW_MAPPER);
        return employeeList;
    }

    /**
     * 主キーから従業員情報を取得する
     * 従業員が存在しない場合はSpringが自動的に例外を発生
     * @param id
     * @return
     */
    public Employee load(Integer id) {
        String loadSql = 
            "SELECT id, name, image, gender, hire_date, mail_address, zip_code, adderss, salary, charracteristics, dependents_count " + 
            "FROM employees WHERE id = :id";
        SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
        Employee employee = template.queryForObject(loadSql, param, EMPLOYEE_ROW_MAPPER);
        return employee;
    }

    /**
     * 従業員情報を変更する
     * id カラムを除いた従業員情報の全てのカラムを更新
     * @param employee
     */
    public void update(Employee employee) {
        String updateSql = 
            "UPDATE employees " + 
            "SET name = :name, image = :image, gender = :gender, hire_date = :hireDate, mail_address = :mailAddress, zip_code = :zipCode, " +
                "address = :address, salary = :salary, charracteristics = :charracteristics, dependents_count = :dependentsCount" + 
            "WHERE id = :id";
        SqlParameterSource param = 
            new MapSqlParameterSource()
                .addValue("name", employee.getName())
                .addValue("image", employee.getImage())
                .addValue("gender", employee.getGender())
                .addValue("hireDate", employee.getHireDate())
                .addValue("mailAddress", employee.getMailAddress())
                .addValue("zipCode", employee.getZipCode())
                .addValue("address", employee.getAddress())
                .addValue("salary", employee.getSalaly())
                .addValue("charracteristics", employee.getCharacteristics())
                .addValue("dependentsCount", employee.getDependentsCount())
                .addValue("id", employee.getId());
        template.update(updateSql, param);
    }
}
