package com.example.dentalclinic.serviceInterfaces;


import com.example.dentalclinic.dto.DoctorDTO;

import java.util.List;

public interface IDoctorService {
    List<DoctorDTO> getAllDoctors();
    DoctorDTO getDoctorById(Integer id);
    boolean addDoctor(DoctorDTO doctor);
    boolean editDoctor(DoctorDTO doctor);
    boolean deleteDoctor(Integer id);
}
