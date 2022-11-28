package com.example.dentalclinic.Interfaces;

import com.example.dentalclinic.Models.Customer;
import com.example.dentalclinic.Models.Doctor;

import java.util.List;

public interface IDoctor {

    List<Doctor> getAllDoctors();
    Doctor getDoctorById(Integer id);
    boolean addDoctor(Doctor doctor);
    boolean editDoctor(Doctor doctor);
    boolean deleteDoctor(Integer id);
}
