package com.example.dentalclinic.repoInterfaces;

import com.example.dentalclinic.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
}
