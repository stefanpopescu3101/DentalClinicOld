package com.example.dentalclinic.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDTO {
    private Integer id;
    private String title;
    private String firstName;
    private String lastName;
    private String sex;
    private Date birthday;
    private Integer phone;
    private String email;
}
