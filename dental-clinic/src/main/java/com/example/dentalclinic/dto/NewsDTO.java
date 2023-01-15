package com.example.dentalclinic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsDTO {
    private Integer id;
    private String title;
    private String description;
    private String postedAt;
}
