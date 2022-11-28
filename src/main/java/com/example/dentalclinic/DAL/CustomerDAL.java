package com.example.dentalclinic.DAL;

import com.example.dentalclinic.Interfaces.ICustomer;
import com.example.dentalclinic.Models.Customer;
import com.example.dentalclinic.repoInterfaces.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAL implements ICustomer {
    @Autowired
    ICustomerRepository repo;

    public CustomerDAL(ICustomerRepository repo)
    {
        this.repo=repo;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return repo.findAll();
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return repo.findById(id).get();
    }

    @Override
    public boolean addCustomer(Customer customer) {
        if(customer==null)
        {
            repo.save(customer);
            return true;
        }
        return  false;
    }

    @Override
    public boolean editCustomer(Customer customer) {
        Customer updatedCustomer= this.getCustomerById(customer.getId());
        if(updatedCustomer != null) {
            updatedCustomer.setFirstName(customer.getFirstName());
            updatedCustomer.setLastName(customer.getLastName());
            updatedCustomer.setPhone(customer.getPhone());
            updatedCustomer.setEmail(customer.getEmail());
            repo.save(updatedCustomer);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCustomer(Integer id) {
        if(getCustomerById(id).getId() == id)
        {
            repo.delete(getCustomerById(id));
            return true;
        }
        return false;
    }
}
