package com.example.dentalclinic.ServiceClassesTests;


import com.example.dentalclinic.Models.Client;
import com.example.dentalclinic.Models.Lottery;
import com.example.dentalclinic.converters.ClientConverter;
import com.example.dentalclinic.converters.LotteryConverter;
import com.example.dentalclinic.dalInterfaces.IClientDAL;
import com.example.dentalclinic.dalInterfaces.ILotteryDAL;
import com.example.dentalclinic.dto.ClientDTO;
import com.example.dentalclinic.service.ClientService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@SpringBootTest
public class ClientServiceMockTest {

    @Mock
    private IClientDAL clientDAL;

    @Mock
    private ILotteryDAL lotteryDAL;

    private ClientConverter clientConverter = new ClientConverter();
    private ClientService service;

    @BeforeEach
    public void setUp()
    {
        service = new ClientService(clientDAL,new ClientConverter(), new LotteryConverter(),lotteryDAL);
        List<Client> clients = List.of(
                new Client(1,"test1","test", "075555555", "test@test.com", false),
                new Client(2,"test2","test", "075555555", "test@test.com", false),
                new Client(3,"test3","test", "075555555", "test@test.com", false)

        );
        List<Lottery> lotteries = List.of(
                new Lottery(1, "name1", 20, clients),
                new Lottery(2, "name2", 20, clients),
                new Lottery(3, "name3", 20, clients)
        );


        when(clientDAL.getClientById(1)).thenReturn(clients.get(0));
        when(clientDAL.deleteClient(1)).thenReturn(true);
        when(clientDAL.getAllClients()).thenReturn(clients);

        when(lotteryDAL.getLotteryById(1)).thenReturn(lotteries.get(0));
        when(lotteryDAL.deleteLottery(1)).thenReturn(true);
        when(lotteryDAL.getAllLotteries()).thenReturn(lotteries);

    }

    @Test
    public void getAllClientsTest_ReturnList()
    {
        //act
        List<ClientDTO> clients = service.getAllClients();

        //assert
        Assertions.assertEquals(1, clients.get(0).getId());
        Assertions.assertEquals(2, clients.get(1).getId());
        Assertions.assertEquals(3, clients.get(2).getId());
    }

    @Test
    public void getClientById()
    {
        Client client =  new Client(4,"test4","test", "075555555", "test@test.com", false);

        //act
        when(clientDAL.getClientById(4)).thenReturn(client);
        ClientDTO clientDTO = service.getClientById(4);

        //assert
        Assertions.assertEquals("test4", clientDTO.getFirstName());
    }

    @Test
    public void deleteClient()
    {
        //arrange
        ClientService service = new ClientService(clientDAL,new ClientConverter(), new LotteryConverter(),lotteryDAL);

        //act
        List<ClientDTO> clients = service.getAllClients();
        var result = service.deleteClient(clients.get(0).getId());

        //assert
        Assertions.assertEquals(result,true);
    }

    @Test
    public void addClient()
    {
        //act
        List<Integer> lotteries = List.of(
                1,
                2,
                3
        );
        ClientDTO clientDTO =  new ClientDTO(4, "username", "password","test4","test", "075555555", "test@test.com", false, lotteries);
        service.addClient(clientDTO);

        //assert
        ArgumentCaptor<Client> clientArgumentCaptor = ArgumentCaptor.forClass(Client.class);
        verify(clientDAL).addClient(clientArgumentCaptor.capture());
        Client capturePost = clientArgumentCaptor.getValue();
        Assertions.assertEquals(clientDTO.getFirstName(), capturePost.getFirstName());
    }

    @Test
    public void updateClient() {
        //act
        List<Integer> lotteries = List.of(
                1,
                2,
                3
        );
        ClientDTO clientDTO =  new ClientDTO(4, "username", "password","test4","test", "075555555", "test@test.com", false, lotteries);
        service.addClient(clientDTO);

        clientDTO.setFirstName("Test");
        service.editClient(clientDTO);

        //assert
        ArgumentCaptor<Client> clientArgumentCaptor = ArgumentCaptor.forClass(Client.class);
        verify(clientDAL).editClient(clientArgumentCaptor.capture());
        Client capturePost = clientArgumentCaptor.getValue();
        Assertions.assertEquals(clientDTO.getFirstName(), capturePost.getFirstName());
    }

    @Test
    public void enterLottery() {
        //arrange

        Client client = clientDAL.getClientById(1);

        //act
        service.enterLottery(client,1);

        //assert
        ArgumentCaptor<Client> clientArgumentCaptor = ArgumentCaptor.forClass(Client.class);
        ArgumentCaptor<Lottery> lotteryArgumentCaptor = ArgumentCaptor.forClass(Lottery.class);
        verify(clientDAL).enterLottery(clientArgumentCaptor.capture(),lotteryArgumentCaptor.capture());
        var capturePost = lotteryArgumentCaptor.getValue();
        Assertions.assertEquals(1, capturePost.getId());
    }
}
