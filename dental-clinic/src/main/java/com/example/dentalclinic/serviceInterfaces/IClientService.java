package com.example.dentalclinic.serviceInterfaces;


import com.example.dentalclinic.dto.ClientDTO;

import java.text.ParseException;
import java.util.List;

public interface IClientService {

    List<ClientDTO> getAllClients();
    ClientDTO getClientById(Integer id);
    boolean addClient(ClientDTO client);
    boolean editClient(ClientDTO client);
    boolean deleteClient(Integer id);
}
