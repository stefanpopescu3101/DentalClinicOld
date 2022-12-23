package com.example.dentalclinic.converters;



import com.example.dentalclinic.Models.Client;
import com.example.dentalclinic.dto.ClientDTO;
import org.springframework.stereotype.Component;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientConverter {

    public ClientDTO entityToDto(Client client)
    {
        ClientDTO dto  = new ClientDTO();
        dto.setId(client.getId());
        dto.setUsername(client.getUsername());
        dto.setPassword(client.getPassword());
        dto.setFirstName(client.getFirstName());
        dto.setLastName(client.getLastName());
        dto.setSex(client.getSex());
        dto.setBirthday(client.getBirthday().toString());
        dto.setPhone(client.getPhone());
        dto.setEmail(client.getEmail());
        dto.setVerified(client.getVerified());

        return dto;

    }
    public List<ClientDTO> entityToDto(List<Client> clients)
    {
        return clients.stream().map(this::entityToDto).collect(Collectors.toList());

    }
    public Client dtoToEntity(ClientDTO dto) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Client entity = new Client();
        entity.setId(dto.getId());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setSex(dto.getSex());
        entity.setBirthday(dto.getBirthday());
        entity.setPhone(dto.getPhone());
        entity.setEmail(dto.getEmail());
        entity.setVerified(dto.getVerified());


        return entity;

    }
    public List<Client> dtoToEntity(List<ClientDTO> clientDTOS)
    {
        return clientDTOS.stream().map(this::dtoToEntity).collect(Collectors.toList());

    }
}
