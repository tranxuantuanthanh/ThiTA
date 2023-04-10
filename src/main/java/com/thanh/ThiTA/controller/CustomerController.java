package com.thanh.ThiTA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thanh.ThiTA.entity.Customer;
import com.thanh.ThiTA.service.Customer.CustomerService;

@RestController
@RequestMapping(path = "/api/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping(path = "/list")
    ResponseEntity<?> listCustomers() {
        var list = customerService.getAllCustomer();
        return ResponseEntity.ok(list);
    }

    @GetMapping(path = "/search")
    ResponseEntity<?> findCustomer(
            @RequestParam(value = "contact-name", required = false, defaultValue = "") String contactName,
            @RequestParam(value = "company-name", required = false, defaultValue = "") String companyName) {
        if (!contactName.isBlank()) {
            return ResponseEntity.ok(customerService.findByName(contactName));
        }
        if (!companyName.isBlank()) {
            return ResponseEntity.ok(customerService.findByCompany(companyName));
        }
        var list = customerService.getAllCustomer();
        return ResponseEntity.ok(list);
    }

    @PostMapping(path = "/add")
    ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
        return ResponseEntity.ok(ResponseFinal.INSERT);
    }
    
    @PutMapping(path = "/edit/{id}")
    ResponseEntity<?> editCustomer(@PathVariable int id, @RequestBody Customer customer) {
        customerService.editCustomer(id, customer);
        return ResponseEntity.ok(ResponseFinal.UPDATE);
    }
    
    @DeleteMapping(path = "delete/{id}")
    ResponseEntity<?> deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok(ResponseFinal.DELETE);
    }
}
