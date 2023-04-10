package com.thanh.ThiTA.service.Employee;

import com.thanh.ThiTA.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    List<Employee> getAllEmployees();

    List<Employee> findByName(String searchValue);

    int addEmployee(Employee Employee);

    int editEmployee(int employeeId, Employee Employee);

    int deleteEmployee(int employeeId);
}
