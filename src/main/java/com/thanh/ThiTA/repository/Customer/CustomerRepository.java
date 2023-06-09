package com.thanh.ThiTA.repository.Customer;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.thanh.ThiTA.entity.Customer;

@Repository
public class CustomerRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Customer> getAllCustomer() {
        List<Customer> listCategories;
        listCategories = jdbcTemplate.query("Select * from customer;", new CustomerRowMapper());
        return listCategories;
    }

    public List<Customer> findByName(String searchValue) {
        List<Customer> list;
        String sql = "SELECT * FROM `Customer` WHERE contactName COLLATE UTF8_GENERAL_CI LIKE ?;";
        list = jdbcTemplate.query(
                sql,
                new Object[]{'%' + searchValue + '%'},
                new int[]{Types.VARCHAR},
                new CustomerRowMapper());
        return list;
    }

    public List<Customer> findByCompany(String searchValue) {
        List<Customer> list;
        String sql = "SELECT * FROM `Customer` WHERE companyName COLLATE UTF8_GENERAL_CI LIKE ?;";
        list = jdbcTemplate.query(
                sql,
                new Object[]{'%' + searchValue + '%'},
                new int[]{Types.VARCHAR},
                new CustomerRowMapper());
        return list;
    }

    public int addCustomer(Customer customer) {
        String sql = "INSERT INTO `customer`(`companyName`, `contactName`, `contactTitle`, `address`, `city`, `region`, `postalCode`, `country`, `phone`, `mobile`, `email`, `fax`, `password`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(
                sql,
                customer.getCompanyName(),
                customer.getContactName(),
                customer.getContactTitle(),
                customer.getAddress(),
                customer.getCity(),
                customer.getRegion(),
                customer.getPostalCode(),
                customer.getCountry(),
                customer.getPhone(),
                customer.getMobile(),
                customer.getEmail(),
                customer.getFax(),
                customer.getPassword());
    }

    public int editCustomer(Customer customer) {
        String sql = "UPDATE `customer` SET `companyName`=?,`contactName`=?,`contactTitle`=?,`address`=?,`city`=?,`region`=?,`postalCode`=?,`country`=?,`phone`=?,`mobile`=?,`email`=?,`fax`=? WHERE custId = ?";
        return jdbcTemplate.update(
                sql,
                customer.getCompanyName(),
                customer.getContactName(),
                customer.getContactTitle(),
                customer.getAddress(),
                customer.getCity(),
                customer.getRegion(),
                customer.getPostalCode(),
                customer.getCountry(),
                customer.getPhone(),
                customer.getMobile(),
                customer.getEmail(),
                customer.getFax(),
                customer.getCustId());
    }

    public int deleteCustomer(int customerId) {
        String sql = "delete from Customer where custId = ? and Not exists(Select * from SalesOrder where custId = ?)";
        return jdbcTemplate.update(sql, customerId, customerId);
    }
}
