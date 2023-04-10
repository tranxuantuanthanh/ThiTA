package com.thanh.ThiTA.repository.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.thanh.ThiTA.entity.Customer;

public class CustomerRowMapper implements RowMapper<Customer> {
    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException{
        Customer customer = new Customer();
        customer.setCustId(rs.getInt(1));
        customer.setCompanyName(rs.getString(2));
        customer.setContactName(rs.getString(3));
        customer.setContactTitle(rs.getString(4));
        customer.setAddress(rs.getString(5));
        customer.setCity(rs.getString(6));
        customer.setRegion(rs.getString(7));
        customer.setPostalCode(rs.getString(8));
        customer.setCountry(rs.getString(9));
        customer.setPhone(rs.getString(10));
        customer.setMobile(rs.getString(11));
        customer.setEmail(rs.getString(12));
        customer.setFax(rs.getString(13));
        customer.setPassword(rs.getString(14));
        return customer;
    }
}
