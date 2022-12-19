package com.example.dentalclinic.repoInterfaces;

import com.example.dentalclinic.Models.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITreatmentRepository extends JpaRepository<Treatment, Integer> {
}
