package com.example.dentalclinic.dalInterfaces;

import com.example.dentalclinic.Models.Treatment;

import java.util.List;

public interface ITreatmentDAL {
    List<Treatment> getAllTreatments();
    Treatment getTreatmentById(Integer id);
    boolean addTreatment(Treatment treatment);
    boolean editTreatment(Treatment treatment);
    boolean deleteTreatment(Integer id);
}
