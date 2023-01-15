package com.example.dentalclinic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LotteryDTO {
    private Integer id;
    private String name;
    private String description;
    private Integer capacity;
    private Integer nrOfClients;
    private Collection<Integer> clients = new ArrayList<>();
}
