package com.example.dentalclinic.dal;

import com.example.dentalclinic.Models.Client;
import com.example.dentalclinic.dalInterfaces.IClientDAL;
import com.example.dentalclinic.repoInterfaces.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository @Transactional
public class ClientDAL implements IClientDAL
{

    private IClientRepository repo;
    @Autowired
    public ClientDAL(IClientRepository repo)
    {
        this.repo=repo;
    }

    @Override
    public List<Client> getAllClients() {
        return repo.findAll();
    }

    @Override
    public Client getClientById(Integer id) {
        return repo.findById(id).get();
    }

    @Override
    public boolean addClient(Client client) {
        if(client != null)
        {
            repo.save(client);
            return true;
        }
        return  false;
    }

    @Override
    public boolean editClient(Client client) {
        Client updatedClient = this.getClientById(client.getId());
        if(updatedClient != null) {
            updatedClient.setFirstName(client.getFirstName());
            updatedClient.setLastName(client.getLastName());
            updatedClient.setPhone(client.getPhone());
            updatedClient.setEmail(client.getEmail());
            repo.save(updatedClient);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteClient(Integer id) {
        if(getClientById(id).getId() == id)
        {
            repo.delete(getClientById(id));
            return true;
        }
        return false;
    }
}
