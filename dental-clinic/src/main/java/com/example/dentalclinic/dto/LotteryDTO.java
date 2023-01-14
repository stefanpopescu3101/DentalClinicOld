package com.example.dentalclinic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LotteryDTO {
    private Integer id;
    private String name;
    private Integer capacity;
    private Collection<String> attendees;
}
