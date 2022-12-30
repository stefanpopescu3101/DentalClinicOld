package com.example.dentalclinic.serviceInterfaces;
import com.example.dentalclinic.dto.TreatmentDTO;

import java.util.List;

public interface ITreatmentService {
    List<TreatmentDTO> getAllTreatments();
    TreatmentDTO getTreatmentById(Integer id);
    boolean addTreatment(TreatmentDTO service);
    boolean editTreatment(TreatmentDTO service);
    boolean deleteTreatment(Integer id);
}
