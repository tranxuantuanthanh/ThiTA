package com.thanh.ThiTA.service.Customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thanh.ThiTA.entity.Customer;
import com.thanh.ThiTA.exception.NotFoundException;
import com.thanh.ThiTA.repository.Customer.CustomerRepository;

@Component
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.getAllCustomer();
    }

    @Override
    public List<Customer> findByName(String searchValue) {
        var list = customerRepository.findByName(searchValue);
        if (list.size() > 0) {
            return list;
        }
        throw new NotFoundException("Not founded Customer");
    }

    @Override
    public List<Customer> findByCompany(String searchValue) {
        var list = customerRepository.findByCompany(searchValue);
        if (list.size() > 0) {
            return list;
        }
        throw new NotFoundException("Not founded Customer");
    }

    @Override
    public int addCustomer(Customer customer) {
        return customerRepository.addCustomer(customer);
    }

    @Override
    public int editCustomer(int custId, Customer customer) {
        customer.setCustId(custId);
        return customerRepository.editCustomer(customer);
    }

    @Override
    public int deleteCustomer(int customerId) {
        return customerRepository.deleteCustomer(customerId);
    }

}
