package com.example.dentalclinic.dalInterfaces;

import com.example.dentalclinic.Models.Doctor;

import java.util.List;

public interface IDoctorDAL {
    List<Doctor> getAllDoctors();
    Doctor getDoctorById(Integer id);
    boolean addDoctor(Doctor doctor);
    boolean editDoctor(Doctor doctor);
    boolean deleteDoctor(Integer id);
}
