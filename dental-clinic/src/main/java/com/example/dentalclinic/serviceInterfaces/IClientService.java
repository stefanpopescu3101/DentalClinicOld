package com.example.dentalclinic.serviceInterfaces;


import com.example.dentalclinic.Models.Client;
import com.example.dentalclinic.Models.Role;
import com.example.dentalclinic.dto.ClientDTO;
import com.example.dentalclinic.dto.LotteryDTO;

import java.util.List;

public interface IClientService {

    List<ClientDTO> getAllClients();
    ClientDTO getClientById(Integer id);
    Client getClient(String username);
    Role saveRole(Role role);
    void enterLottery(ClientDTO loggedIn, Integer lotteryID);
    void addRole(String username,String roleName);
    boolean addClient(ClientDTO client);
    boolean editClient(ClientDTO client);
    boolean deleteClient(Integer id);
}
