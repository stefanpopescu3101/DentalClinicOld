package com.example.dentalclinic.dalInterfaces;

import com.example.dentalclinic.Models.Client;
import com.example.dentalclinic.Models.Role;

import java.util.List;

public interface IClientDAL {
    List<Client> getAllClients();
    Client getClientById(Integer id);
    Client getUser(String username);
    Role saveRole(Role role);
    void addRole(String username,String roleName);
    boolean addClient(Client client);
    boolean editClient(Client client);
    boolean deleteClient(Integer id);
}
