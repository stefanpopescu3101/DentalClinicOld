package com.example.dentalclinic.controllers;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.dentalclinic.Models.Client;
import com.example.dentalclinic.Models.Role;
import com.example.dentalclinic.dto.ClientDTO;
import com.example.dentalclinic.serviceInterfaces.IClientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

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

    @GetMapping("{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable(value = "id")  Integer id) {
        ClientDTO client = service.getClientById(id);

        if(client != null) {
            return ResponseEntity.ok().body(client);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> createUser(@RequestBody @NotNull ClientDTO user) {
        if (service.getClient(user.getUsername()) != null) {
            return ResponseEntity.badRequest().body("Username is already taken");
        } else {
            service.addClient(user);
            service.addRole(user.getUsername(),"ROLE_USER");
            return ResponseEntity.ok().body(user);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ClientDTO> deleteClient(@PathVariable("id") Integer id) {
        service.deleteClient(id);
        return ResponseEntity.ok().build();

    }

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

    @GetMapping("/token/refresh")
    //POST at http://localhost:XXXX/users/token/refresh
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer "))
        {
            try {
                String refresh_token = authorizationHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(refresh_token);
                String username = decodedJWT.getSubject();
                Client user = service.getClient(username);
                String access_token = JWT.create()
                        .withSubject(user.getUsername())
                        .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles", user.getRoles().stream().map(Role::getName).collect(Collectors.toList()))
                        .sign(algorithm);
                Map<String, String> tokens = new HashMap<>();
                tokens.put("access_token",access_token);
                tokens.put("refresh_token",refresh_token);
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(),tokens);
            }
            catch (Exception e)
            {
                response.setHeader("error", e.getMessage());
                response.setStatus(FORBIDDEN.value());
                Map<String, String> error = new HashMap<>();
                error.put("error_message",e.getMessage());
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(),error);
            }
        }
        else
        {
            throw new RuntimeException("Refresh token is missing");
        }
    }
}