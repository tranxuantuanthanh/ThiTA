package com.thanh.ThiTA.controller;

import com.thanh.ThiTA.entity.Employee;
import com.thanh.ThiTA.service.Employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping(path = "/list")
    ResponseEntity<?> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping(path = "/search")
    ResponseEntity<?> findEmployee(@RequestParam String name) {
        return ResponseEntity.ok(employeeService.findByName(name));
    }

    @PostMapping(path = "/add")
    ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
        System.out.println(employee);
        employeeService.addEmployee(employee);
        return ResponseEntity.ok(ResponseFinal.INSERT);
    }

    @PutMapping(path = "/edit/{id}")
    ResponseEntity<?> editEmployee(@PathVariable int id, @RequestBody Employee employee) {
        employeeService.editEmployee(id, employee);
        return ResponseEntity.ok(ResponseFinal.UPDATE);
    }

    @DeleteMapping(path = "/delete/{id}")
    ResponseEntity<?> deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok(ResponseFinal.DELETE);
    }
}
