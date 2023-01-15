package com.example.dentalclinic.service;

import com.example.dentalclinic.Models.Client;
import com.example.dentalclinic.Models.Lottery;
import com.example.dentalclinic.Models.Role;
import com.example.dentalclinic.converters.ClientConverter;
import com.example.dentalclinic.converters.LotteryConverter;
import com.example.dentalclinic.dalInterfaces.IClientDAL;
import com.example.dentalclinic.dalInterfaces.ILotteryDAL;
import com.example.dentalclinic.dto.ClientDTO;
import com.example.dentalclinic.dto.LotteryDTO;
import com.example.dentalclinic.serviceInterfaces.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.text.ParseException;
import java.util.List;

@Service
@Transactional
public class ClientService implements IClientService {

    private final IClientDAL data;
    private final ClientConverter converter;
    private final ILotteryDAL lotteryDAL;
    private final LotteryConverter lotteryConverter;

    @Autowired
    public ClientService(IClientDAL data, ClientConverter converter, LotteryConverter lotteryConverter, ILotteryDAL lotteryDAL)
    {
        this.data = data;
        this.converter = converter;
        this.lotteryConverter = lotteryConverter;
        this.lotteryDAL = lotteryDAL;
    }
    @Override
    public List<ClientDTO> getAllClients() {
        return converter.entityToDto(data.getAllClients());
    }

    @Override
    public ClientDTO getClientById(Integer id) {
        return converter.entityToDto(data.getClientById(id));
    }

    @Override
    public Client getClient(String username) {
        return data.getUser(username);
    }

    @Override
    public Role saveRole(Role role) {
        return data.saveRole(role);
    }

    @Override
    public void enterLottery(Client loggedIn, Integer lotteryID) {
        Lottery lottery = this.lotteryDAL.getLotteryById(lotteryID);
        Client client = this.data.getUser(loggedIn.getUsername());
        data.enterLottery(client,lottery);
    }

    @Override
    public void addRole(String username, String roleName) {
        data.addRole(username,roleName);
    }

    @Override
    public boolean addClient(ClientDTO client) {
        if(client != null)
        {
            Client entity = converter.dtoToEntity(client);
            data.addClient(entity);
            return true;
        }
        return false;
    }

    @Override
    public boolean editClient(ClientDTO client) {
        if(client != null)
        {
            Client entity = converter.dtoToEntity(client);
            data.editClient(entity);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteClient(Integer id) {
        return data.deleteClient(id);
    }
}
