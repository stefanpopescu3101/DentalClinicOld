package com.example.dentalclinic.converters;

import com.example.dentalclinic.Models.Lottery;
import com.example.dentalclinic.dto.LotteryDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LotteryConverter {
    public LotteryDTO entityToDto(Lottery lottery)
    {
        ModelMapper mapper = new ModelMapper();

        return mapper.map(lottery, LotteryDTO.class);

    }
    public List<LotteryDTO> entityToDto(List<Lottery> lotteries)
    {
        return lotteries.stream().map(this::entityToDto).collect(Collectors.toList());

    }
    public Lottery dtoToEntity(LotteryDTO lotteryDTO)
    {
        ModelMapper mapper = new ModelMapper();

        return mapper.map(lotteryDTO, Lottery.class);
    }
    public List<Lottery> dtoToEntity(List<LotteryDTO> lotteryDTOS)
    {
        return lotteryDTOS.stream().map(this::dtoToEntity).collect(Collectors.toList());

    }
}
