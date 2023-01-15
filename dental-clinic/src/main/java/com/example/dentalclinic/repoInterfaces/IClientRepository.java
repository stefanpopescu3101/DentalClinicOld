package com.example.dentalclinic.repoInterfaces;

import com.example.dentalclinic.Models.Client;
import com.example.dentalclinic.Models.Lottery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IClientRepository extends JpaRepository<Client, Integer> {
    Client findByUsername(String username);
}
