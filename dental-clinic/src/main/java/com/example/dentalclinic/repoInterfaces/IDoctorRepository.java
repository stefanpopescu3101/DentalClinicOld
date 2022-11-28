package com.example.dentalclinic.repoInterfaces;

import com.example.dentalclinic.Models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {
}
