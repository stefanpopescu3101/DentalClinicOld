package com.example.dentalclinic.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreatmentDTO {
    private Integer id;
    private String title;
    private Integer doctorID;
    private Integer duration;
    private double price;
    private String description;
}
