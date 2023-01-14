package com.example.dentalclinic.dalInterfaces;

import com.example.dentalclinic.Models.Client;
import com.example.dentalclinic.Models.Lottery;

import java.util.List;

public interface ILotteryDAL {
    List<Lottery> getAllLotteries();
    Lottery getLotteryById(Integer id);

    List<Client> viewAttendees(Lottery lottery);
    boolean createLottery(Lottery lottery);
    boolean editLottery(Lottery lottery);
    boolean deleteLottery(Integer id);
}
