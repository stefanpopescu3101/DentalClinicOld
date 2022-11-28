package com.example.dentalclinic.repoInterfaces;

import com.example.dentalclinic.Models.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceRepository extends JpaRepository<Service, Integer> {
}
