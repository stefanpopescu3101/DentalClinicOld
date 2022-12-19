package com.example.dentalclinic.controllers;


import com.example.dentalclinic.dto.ClientDTO;
import com.example.dentalclinic.serviceInterfaces.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/client")
@Controller
public class ClientController {

    private final IClientService service;

    @Autowired
    public ClientController(IClientService service)
    {
        this.service=service;
    }

    //GET at /news
    @GetMapping
    public ResponseEntity<List<ClientDTO>> getAllClients()
    {
        List<ClientDTO> clientsList = service.getAllClients();

        if(clientsList != null)
        {
            return ResponseEntity.ok().body(clientsList);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }

    }
    //GET at news/1 e…g
    @GetMapping("{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable(value = "id")  Integer id) {
        ClientDTO client = service.getClientById(id);

        if(client != null) {
            return ResponseEntity.ok().body(client);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    //POST at http://localhost:8080/news
    @PostMapping()
    public ResponseEntity<ClientDTO> addClient(@RequestBody ClientDTO client) {
        if (client == null) {
            return ResponseEntity.notFound().build();
        } else {
            service.addClient(client);
            return ResponseEntity.ok().body(client);
        }

    }
    //DELETE at http://localhost:XXXX/news/
    @DeleteMapping("{id}")
    public ResponseEntity<ClientDTO> deleteClient(@PathVariable("id") Integer id) {
        service.deleteClient(id);
        return ResponseEntity.ok().build();

    }

    //PUT at http://localhost:XXXX/news/
    @PutMapping()
    public ResponseEntity<ClientDTO> editClient(@RequestBody ClientDTO client)
    {
        if(service.editClient(client))
        {
            return ResponseEntity.ok().body(client);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }
}
