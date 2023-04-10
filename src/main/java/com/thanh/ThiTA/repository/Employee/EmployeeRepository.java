package com.thanh.ThiTA.repository.Employee;

import com.thanh.ThiTA.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;

@Repository
public class EmployeeRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    String sql = "";

    public List<Employee> getAllEmployees() {
        sql = "Select * from employee;";
        return jdbcTemplate.query(sql, new EmployeeRowMapper());
    }

    public List<Employee> findEmployees(String searchValue) {
        sql = "Select * from employee where lower(firstName) like ? or lower(lastName) like ?";
        return jdbcTemplate.query(sql,
                new Object[]{'%' + searchValue + '%', '%' + searchValue + '%'},
                new int[]{Types.VARCHAR, Types.VARCHAR},
                new EmployeeRowMapper());
    }

    public int addEmployee(Employee employee) {
        sql = "INSERT INTO `employee`(`lastname`, `firstname`, `title`, `titleOfCourtesy`, `birthDate`, `hireDate`, `address`, `city`, `region`, `postalCode`, `country`, `phone`, `mobile`, `email`, `password`,`photoPath`)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                employee.getLastname(),
                employee.getFirstname(),
                employee.getTitle(),
                employee.getTitleOfCourtesy(),
                employee.getBirthDate(),
                employee.getHireDate(),
                employee.getAddress(),
                employee.getCity(),
                employee.getRegion(),
                employee.getPostalCode(),
                employee.getCountry(),
                employee.getPhone(),
                employee.getMobile(),
                employee.getEmail(),
                employee.getPassword(),
                employee.getPhotoPath());
    }

    public int editEmployee(Employee employee) {
        sql = "UPDATE `employee` SET `lastname`= ?,`firstname`= ?,`title`=?,`titleOfCourtesy`=?,`birthDate`=?,`hireDate`=?,`address`=?,`city`=?,`region`=?,`postalCode`=?,`country`=?,`phone`=?,`mobile`=?,`email`=?,`password`=?, `photoPath`=? WHERE employeeId = ?";
        return jdbcTemplate.update(sql,
                employee.getLastname(),
                employee.getFirstname(),
                employee.getTitle(),
                employee.getTitleOfCourtesy(),
                employee.getBirthDate(),
                employee.getHireDate(),
                employee.getAddress(),
                employee.getCity(),
                employee.getRegion(),
                employee.getPostalCode(),
                employee.getCountry(),
                employee.getPhone(),
                employee.getMobile(),
                employee.getEmail(),
                employee.getPassword(),
                employee.getPhotoPath(),
                employee.getEmployeeId());
    }

    public int deleteEmployee(int employeeId) {
        sql = "Delete from Employee where employeeId = ?";
        return jdbcTemplate.update(sql, employeeId);
    }

    public int checkUniqueEmail(String email) {
        sql = "Select count(*) from employee where email like ?;";
        var integer = jdbcTemplate.queryForObject(sql, new Object[]{email}, new int[]{Types.VARCHAR}, int.class);
        if (integer != null) {
            return integer;
        }
        return 0;
    }

    public int checkEmployee(int employeeId) {
        sql = "Select count(*) from employee where employeeId = ?;";
        var integer = jdbcTemplate.queryForObject(sql, new Object[]{employeeId}, new int[]{Types.INTEGER}, int.class);
        if (integer != null) {
            return integer;
        }
        return 0;
    }
}
