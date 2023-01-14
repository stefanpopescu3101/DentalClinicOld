package com.example.dentalclinic.dal;

import com.example.dentalclinic.Models.Client;
import com.example.dentalclinic.Models.Lottery;
import com.example.dentalclinic.dalInterfaces.ILotteryDAL;
import com.example.dentalclinic.repoInterfaces.ILotteryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class LotteryDAL implements ILotteryDAL {

    private final ILotteryRepository repo;

    @Autowired
    public LotteryDAL(ILotteryRepository repo)
    {
        this.repo=repo;
    }

    @Override
    public List<Lottery> getAllLotteries() {
        return repo.findAll();
    }

    @Override
    public Lottery getLotteryById(Integer id) {
        return repo.findById(id).get();
    }

    @Override
    public List<Client> viewAttendees(Lottery lottery) {
        return (List<Client>) lottery.getAttendees();
    }

    @Override
    public boolean createLottery(Lottery lottery) {
        if(lottery!=null)
        {
            repo.save(lottery);
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
            repo.save(updatedLottery);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteLottery(Integer id) {
        if(getLotteryById(id).getId() == id)
        {
            repo.delete(getLotteryById(id));
            return true;
        }
        return false;
    }
}
