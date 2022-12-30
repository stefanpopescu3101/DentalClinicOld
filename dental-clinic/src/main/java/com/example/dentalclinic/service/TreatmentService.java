package com.example.dentalclinic.service;

import com.example.dentalclinic.Models.Doctor;
import com.example.dentalclinic.Models.Treatment;
import com.example.dentalclinic.converters.DoctorConverter;
import com.example.dentalclinic.converters.TreatmentConverter;
import com.example.dentalclinic.dalInterfaces.IDoctorDAL;
import com.example.dentalclinic.dalInterfaces.ITreatmentDAL;
import com.example.dentalclinic.dto.DoctorDTO;
import com.example.dentalclinic.dto.TreatmentDTO;
import com.example.dentalclinic.serviceInterfaces.ITreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class TreatmentService implements ITreatmentService {
    private final ITreatmentDAL treatments;
    private final TreatmentConverter converter;
    private final IDoctorDAL doctors;
    private final DoctorConverter doctorConverter;
    @Autowired
    public TreatmentService(ITreatmentDAL treatments, TreatmentConverter converter, IDoctorDAL doctors, DoctorConverter doctorConverter)
    {
        this.treatments = treatments;
        this.converter = converter;
        this.doctors = doctors;
        this.doctorConverter = doctorConverter;
    }

    @Override
    public List<TreatmentDTO> getAllTreatments() {
        return converter.entityToDto(treatments.getAllTreatments());
    }

    @Override
    public TreatmentDTO getTreatmentById(Integer id) {
        return converter.entityToDto(treatments.getTreatmentById(id));
    }

    @Override
    public boolean addTreatment(TreatmentDTO service) {
        Doctor doctor = this.doctors.getDoctorById(service.getDoctorID());
        if(service != null)
        {
            Treatment entity = converter.dtoToEntity(service);
            entity.setDoctor(doctor);
            treatments.addTreatment(entity);
            doctor.getTreatments().add(entity);
            return true;
        }
        return false;
    }

    @Override
    public boolean editTreatment(TreatmentDTO service) {
        if(service != null)
        {
            Treatment entity = converter.dtoToEntity(service);
            treatments.editTreatment(entity);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteTreatment(Integer id) {
        return treatments.deleteTreatment(id);
    }
}
