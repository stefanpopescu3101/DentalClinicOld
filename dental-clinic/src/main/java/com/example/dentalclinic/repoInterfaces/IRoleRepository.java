package com.example.dentalclinic.repoInterfaces;

import com.example.dentalclinic.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role,String> {
    Role findByName(String name);
}

