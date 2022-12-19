package com.example.dentalclinic.service;

import com.example.dentalclinic.Models.Treatment;
import com.example.dentalclinic.converters.TreatmentConverter;
import com.example.dentalclinic.dalInterfaces.ITreatmentDAL;
import com.example.dentalclinic.dto.TreatmentDTO;
import com.example.dentalclinic.serviceInterfaces.ITreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class TreatmentService implements ITreatmentService {
    private final ITreatmentDAL data;
    private final TreatmentConverter converter;
    @Autowired
    public TreatmentService(ITreatmentDAL data, TreatmentConverter converter)
    {
        this.data = data;
        this.converter = converter;
    }

    @Override
    public List<TreatmentDTO> getAllTreatments() {
        return converter.entityToDto(data.getAllTreatments());
    }

    @Override
    public TreatmentDTO getTreatmentById(Integer id) {
        return converter.entityToDto(data.getTreatmentById(id));
    }

    @Override
    public boolean addTreatment(TreatmentDTO service) {
        if(service != null)
        {
            Treatment entity = converter.dtoToEntity(service);
            data.addTreatment(entity);
            return true;
        }
        return false;
    }

    @Override
    public boolean editTreatment(TreatmentDTO service) {
        if(service != null)
        {
            Treatment entity = converter.dtoToEntity(service);
            data.editTreatment(entity);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteTreatment(Integer id) {
        return data.deleteTreatment(id);
    }
}
