package com.example.dentalclinic.dal;

import com.example.dentalclinic.Models.Client;
import com.example.dentalclinic.Models.Lottery;
import com.example.dentalclinic.dalInterfaces.ILotteryDAL;
import com.example.dentalclinic.repoInterfaces.IClientRepository;
import com.example.dentalclinic.repoInterfaces.ILotteryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class LotteryDAL implements ILotteryDAL {

    private final ILotteryRepository lotteryRepo;
    private final IClientRepository clientRepo;

    @Autowired
    public LotteryDAL(ILotteryRepository lotteryRepo, IClientRepository clientRepo)
    {
        this.lotteryRepo=lotteryRepo;
        this.clientRepo = clientRepo;
    }

    @Override
    public List<Lottery> getAllLotteries() {
        return lotteryRepo.findAll();
    }

    @Override
    public Lottery getLotteryById(Integer id) {
        return lotteryRepo.findById(id).get();
    }

    @Override
    public List<Client> viewAttendees(Lottery lottery) {
        return (List<Client>) lottery.getAttendees();
    }

    @Override
    public List<Lottery> getLotteriesByUsername(String username) {
        Client client = this.clientRepo.findByUsername(username);
        if(client != null)
        {
            return lotteryRepo.findClientLotteries(client.getId());
        }
        return null;
    }

    @Override
    public boolean createLottery(Lottery lottery) {
        if(lottery!=null)
        {
            lotteryRepo.save(lottery);
            return true;
        }
        return  false;
    }

    @Override
    public boolean editLottery(Lottery lottery) {
        Lottery updatedLottery= this.getLotteryById(lottery.getId());
        if(updatedLottery != null) {
            updatedLottery.setName(lottery.getName());
            updatedLottery.setDescription(lottery.getDescription());
            updatedLottery.setCapacity(lottery.getCapacity());
            updatedLottery.setAttendees(lottery.getAttendees());
            lotteryRepo.save(updatedLottery);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteLottery(Integer id) {
        if(getLotteryById(id).getId() == id)
        {
            lotteryRepo.delete(getLotteryById(id));
            return true;
        }
        return false;
    }
}
