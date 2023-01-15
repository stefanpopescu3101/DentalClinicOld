package com.example.dentalclinic.dal;

import com.example.dentalclinic.Models.Client;
import com.example.dentalclinic.Models.Lottery;
import com.example.dentalclinic.Models.Role;
import com.example.dentalclinic.dalInterfaces.IClientDAL;
import com.example.dentalclinic.repoInterfaces.IClientRepository;
import com.example.dentalclinic.repoInterfaces.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository @Transactional
public class ClientDAL implements IClientDAL, UserDetailsService
{
    private final IClientRepository userRepo;
    private final IRoleRepository roleRepo;
    private final PasswordEncoder encoder;

    @Autowired
    public ClientDAL(IClientRepository userRepo, IRoleRepository roleRepo, PasswordEncoder encoder)
    {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.encoder = encoder;
    }

    @Override
    public List<Client> getAllClients() {
        return userRepo.findAll();
    }

    @Override
    public Client getClientById(Integer id) {
        return userRepo.findById(id).get();
    }

    @Override
    public Client getUser(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public void addRole(String username, String roleName) {
        Client client = userRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);
        client.getRoles().add(role);
    }

    @Override
    public boolean enterLottery(Client client, Lottery lottery) {
        if(lottery.getAttendees().contains(client))
        {
            return false;
        }
        lottery.getAttendees().add(client);
        lottery.setNrOfClients(+1) ;
        client.getLotteries().add(lottery);
        return true;

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client client = userRepo.findByUsername(username);
        if(client == null)
        {
            throw new UsernameNotFoundException("User not found");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

        client.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));

        return new org.springframework.security.core.userdetails.User(client.getUsername(),client.getPassword(),authorities);
    }

    @Override
    public boolean addClient(Client client) {
        if(client != null)
        {
            client.setPassword(encoder.encode(client.getPassword()));
            userRepo.save(client);
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
            userRepo.save(updatedClient);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteClient(Integer id) {
        if(getClientById(id).getId() == id)
        {
            userRepo.delete(getClientById(id));
            return true;
        }
        return false;
    }
}
