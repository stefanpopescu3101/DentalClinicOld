package com.example.dentalclinic.converters;

import com.example.dentalclinic.Models.Doctor;
import com.example.dentalclinic.Models.Treatment;
import com.example.dentalclinic.dto.DoctorDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DoctorConverter {
    public DoctorDTO entityToDto(Doctor doctor)
    {
        DoctorDTO dto  = new DoctorDTO();
        dto.setId(doctor.getId());
        dto.setTitle(doctor.getTitle());
        dto.setFirstName(doctor.getFirstName());
        dto.setLastName(doctor.getLastName());
        dto.setSex(doctor.getSex());
        dto.setBirthday(doctor.getBirthday());
        dto.setPhone(doctor.getPhone());
        dto.setEmail(doctor.getEmail());

        for(Treatment treatment: doctor.getTreatments())
        {
            if(treatment.getDoctor().getId() == doctor.getId())
            {
                dto.getTreatments().add(treatment.getId());
            }
        }
        return dto;
    }

    public List<DoctorDTO> entityToDto(List<Doctor> doctors)
    {
        return doctors.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public Doctor dtoToEntity(DoctorDTO dto)
    {
        ModelMapper mapper = new ModelMapper();

        return mapper.map(dto, Doctor.class);
    }
    public List<Doctor> dtoToEntity(List<DoctorDTO> doctorDTOS)
    {
        return doctorDTOS.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }
}
