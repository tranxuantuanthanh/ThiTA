package com.thanh.ThiTA.service.Employee;

import com.thanh.ThiTA.entity.Employee;
import com.thanh.ThiTA.exception.NotFoundException;
import com.thanh.ThiTA.exception.NotUniqueException;
import com.thanh.ThiTA.repository.Employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    @Override
    public List<Employee> findByName(String searchValue) {
        var list = employeeRepository.findEmployees(searchValue);
        if (list.size() > 0){
            return list;
        }
        throw new NotFoundException("Employee not found");
    }

    @Override
    public int addEmployee(Employee employee) {
        if(employeeRepository.checkUniqueEmail(employee.getEmail()) == 1){
            throw new NotUniqueException("Email already exist");
        }
        return employeeRepository.addEmployee(employee);
    }

    @Override
    public int editEmployee(int employeeId, Employee employee) {
        employee.setEmployeeId(employeeId);
        if(employeeRepository.checkUniqueEmail(employee.getEmail()) == 1){
            throw new NotUniqueException("Email already exist");
        }
        if(employeeRepository.checkEmployee(employeeId) == 0){
            throw new NotFoundException("Wrong employee information");
        }
        return employeeRepository.editEmployee(employee);
    }

    @Override
    public int deleteEmployee(int employeeId) {
        if(employeeRepository.checkEmployee(employeeId) == 0){
            throw new NotFoundException("Wrong employee information");
        }
        return employeeRepository.deleteEmployee(employeeId);
    }
}
