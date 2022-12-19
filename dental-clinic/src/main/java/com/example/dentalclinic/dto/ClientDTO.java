package com.example.dentalclinic.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String sex;
    private String birthday;
    private Integer phone;
    private String email;
    private Boolean verified;
}
