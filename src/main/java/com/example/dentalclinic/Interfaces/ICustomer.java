package com.example.dentalclinic.Interfaces;

import com.example.dentalclinic.Models.Customer;

import java.util.List;

public interface ICustomer {

    List<Customer> getAllCustomers();
    Customer getCustomerById(Integer id);
    boolean addCustomer(Customer customer);
    boolean editCustomer(Customer customer);
    boolean deleteCustomer(Integer id);

}
