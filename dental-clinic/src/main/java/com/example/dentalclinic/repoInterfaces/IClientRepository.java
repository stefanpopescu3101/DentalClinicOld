package com.example.dentalclinic.repoInterfaces;

import com.example.dentalclinic.Models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientRepository extends JpaRepository<Client, Integer> {
}
