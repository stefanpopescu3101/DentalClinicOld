package com.example.dentalclinic.serviceInterfaces;

import com.example.dentalclinic.Models.Lottery;
import com.example.dentalclinic.dto.ClientDTO;
import com.example.dentalclinic.dto.LotteryDTO;

import java.util.List;

public interface ILotteryService {
    List<LotteryDTO> getAllLotteries();
    LotteryDTO getLotteryById(Integer id);
    boolean createLottery(LotteryDTO lottery);

    List<ClientDTO> viewAttendees(Integer id);
    List<LotteryDTO> getLotteriesByUsername (String username);
    boolean editLottery(LotteryDTO lottery);
    boolean deleteLottery(Integer id);
    ClientDTO chooseWinner(List<ClientDTO> clients);
}
