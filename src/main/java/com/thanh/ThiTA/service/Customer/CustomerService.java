package com.thanh.ThiTA.service.Customer;

import java.util.List;

import org.springframework.stereotype.Service;

import com.thanh.ThiTA.entity.Customer;

@Service
public interface CustomerService {
    public List<Customer> getAllCustomer();

    public List<Customer> findByName(String searchValue);

    public List<Customer> findByCompany(String searchValue);

    public int addCustomer(Customer customer);

    public int editCustomer(Customer customer);

    public int deleteCustomer(int CustomerId);
}