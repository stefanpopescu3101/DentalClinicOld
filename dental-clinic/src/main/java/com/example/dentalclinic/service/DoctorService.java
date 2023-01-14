package com.example.dentalclinic.service;

import com.example.dentalclinic.Models.Doctor;
import com.example.dentalclinic.converters.DoctorConverter;
import com.example.dentalclinic.dalInterfaces.IDoctorDAL;
import com.example.dentalclinic.dto.DoctorDTO;
import com.example.dentalclinic.serviceInterfaces.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DoctorService implements IDoctorService {
    private final IDoctorDAL data;
    private final DoctorConverter converter;

    @Autowired
    public DoctorService(IDoctorDAL data, DoctorConverter converter)
    {
        this.data = data;
        this.converter = converter;
    }

    @Override
    public List<DoctorDTO> getAllDoctors() {
        return converter.entityToDto(data.getAllDoctors());
    }

    @Override
    public DoctorDTO getDoctorById(Integer id) {
        return converter.entityToDto(data.getDoctorById(id));
    }

    @Override
    public void addRole(Integer id, String roleName) {
         data.addRole(id,roleName);
    }

    @Override
    public boolean addDoctor(DoctorDTO doctor) {
        if(doctor != null)
        {
            Doctor entity = converter.dtoToEntity(doctor);
            data.addDoctor(entity);
            return true;
        }
        return false;
    }

    @Override
    public boolean editDoctor(DoctorDTO doctor) {
        if(doctor != null)
        {
            Doctor entity = converter.dtoToEntity(doctor);
            data.editDoctor(entity);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteDoctor(Integer id) {
        return data.deleteDoctor(id);
    }
}
