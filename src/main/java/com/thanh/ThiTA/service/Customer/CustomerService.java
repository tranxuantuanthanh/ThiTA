package com.thanh.ThiTA.service.Customer;

import java.util.List;

import org.springframework.stereotype.Service;

import com.thanh.ThiTA.entity.Customer;

@Service
public interface CustomerService {
    List<Customer> getAllCustomer();

    List<Customer> findByName(String searchValue);

    List<Customer> findByCompany(String searchValue);

    int addCustomer(Customer customer);

    int editCustomer(int custId, Customer customer);

    int deleteCustomer(int CustomerId);
}