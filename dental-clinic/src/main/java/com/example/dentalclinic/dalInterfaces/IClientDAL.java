package com.example.dentalclinic.dalInterfaces;

import com.example.dentalclinic.Models.Client;

import java.util.List;

public interface IClientDAL {
    List<Client> getAllClients();
    Client getClientById(Integer id);
    boolean addClient(Client client);
    boolean editClient(Client client);
    boolean deleteClient(Integer id);
}
