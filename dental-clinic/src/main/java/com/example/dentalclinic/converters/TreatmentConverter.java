package com.example.dentalclinic.converters;

import com.example.dentalclinic.Models.Treatment;
import com.example.dentalclinic.dto.TreatmentDTO;
import org.modelmapper.ModelMapper;
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
        dto.setDuration(treatment.getDuration());
        dto.setPrice(treatment.getPrice());
        dto.setDescription(treatment.getDescription());
        dto.setDoctorID(treatment.getDoctor().getId());

        return dto;

    }
    public List<TreatmentDTO> entityToDto(List<Treatment> treatments)
    {
        return treatments.stream().map(this::entityToDto).collect(Collectors.toList());

    }
    public Treatment dtoToEntity(TreatmentDTO dto)
    {
        ModelMapper mapper = new ModelMapper();

        return mapper.map(dto, Treatment.class);
    }
    public List<Treatment> dtoToEntity(List<TreatmentDTO> treatmentDTOS)
    {
        return treatmentDTOS.stream().map(this::dtoToEntity).collect(Collectors.toList());

    }
}
