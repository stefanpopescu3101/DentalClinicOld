package com.example.dentalclinic.service;

import com.example.dentalclinic.Models.Lottery;
import com.example.dentalclinic.converters.ClientConverter;
import com.example.dentalclinic.converters.LotteryConverter;
import com.example.dentalclinic.dalInterfaces.ILotteryDAL;
import com.example.dentalclinic.dto.ClientDTO;
import com.example.dentalclinic.dto.LotteryDTO;
import com.example.dentalclinic.serviceInterfaces.ILotteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class LotteryService implements ILotteryService {

    private final ILotteryDAL dal;
    private final LotteryConverter lotteryConverter;

    private final ClientConverter clientConverter;

    @Autowired
    public LotteryService(ILotteryDAL dal, LotteryConverter lotteryConverter, ClientConverter clientConverter)
    {
        this.dal = dal;
        this.lotteryConverter = lotteryConverter;
        this.clientConverter = clientConverter;
    }

    @Override
    public List<LotteryDTO> getAllLotteries() {
        return lotteryConverter.entityToDto(dal.getAllLotteries());
    }

    @Override
    public LotteryDTO getLotteryById(Integer id) {
        return  lotteryConverter.entityToDto(dal.getLotteryById(id));
    }

    @Override
    public boolean createLottery(LotteryDTO lottery) {
        if(lottery != null)
        {
            dal.createLottery(lotteryConverter.dtoToEntity(lottery));
            return true;
        }
        return false;
    }

    @Override
    public List<ClientDTO> viewAttendees(Integer id) {
        LotteryDTO lotteryDTO = this.getLotteryById(id);
        return clientConverter.entityToDto(dal.viewAttendees(lotteryConverter.dtoToEntity(lotteryDTO)));
    }

    @Override
    public boolean editLottery(LotteryDTO lottery) {
        if(lottery != null)
        {
            Lottery entity = lotteryConverter.dtoToEntity(lottery);
            dal.editLottery(entity);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteLottery(Integer id) {
        return dal.deleteLottery(id);
    }

    @Override
    public ClientDTO chooseWinner(List<ClientDTO> clients) {
        Random rand = new Random();
        var winner = clients.get(rand.nextInt(clients.size()));
        return winner;
    }
}
