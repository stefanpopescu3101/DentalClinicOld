package com.example.dentalclinic.serviceInterfaces;


import com.example.dentalclinic.dto.DoctorDTO;

import java.util.List;

public interface IDoctorService {
    List<DoctorDTO> getAllDoctors();
    DoctorDTO getDoctorById(Integer id);
    void addRole(Integer id, String roleName);
    boolean addDoctor(DoctorDTO doctor);
    boolean editDoctor(DoctorDTO doctor);
    boolean deleteDoctor(Integer id);
}
