package com.example.dentalclinic.converters;




import com.example.dentalclinic.Models.Treatment;
import com.example.dentalclinic.dto.TreatmentDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TreatmentConverter {
    public TreatmentDTO entityToDto(Treatment treatment)
    {
        TreatmentDTO dto  = new TreatmentDTO();
        dto.setId(treatment.getId());
        dto.setTitle(treatment.getTitle());
        dto.setDoctorID(treatment.getDoctorID());
        dto.setDoctorName(treatment.getDoctorName());
        dto.setDuration(treatment.getDuration());
        dto.setPrice(treatment.getPrice());
        dto.setDescription(treatment.getDescription());


        return dto;

    }
    public List<TreatmentDTO> entityToDto(List<Treatment> treatments)
    {
        return treatments.stream().map(this::entityToDto).collect(Collectors.toList());

    }
    public Treatment dtoToEntity(TreatmentDTO dto)
    {
        Treatment entity = new Treatment();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setDoctorID(dto.getDoctorID());
        entity.setDoctorName(dto.getDoctorName());
        entity.setDuration(dto.getDuration());
        entity.setPrice(dto.getPrice());
        entity.setDescription(dto.getDescription());

        return entity;

    }
    public List<Treatment> dtoToEntity(List<TreatmentDTO> treatmentDTOS)
    {
        return treatmentDTOS.stream().map(this::dtoToEntity).collect(Collectors.toList());

    }
}
