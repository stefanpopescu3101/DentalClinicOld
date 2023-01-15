package com.example.dentalclinic.ServiceClassesTests;


import com.example.dentalclinic.Models.Client;
import com.example.dentalclinic.Models.Lottery;
import com.example.dentalclinic.converters.ClientConverter;
import com.example.dentalclinic.converters.LotteryConverter;
import com.example.dentalclinic.dalInterfaces.IClientDAL;
import com.example.dentalclinic.dalInterfaces.ILotteryDAL;
import com.example.dentalclinic.dto.LotteryDTO;
import com.example.dentalclinic.service.LotteryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@SpringBootTest
public class LotteryServiceMockTest {

    @Mock
    private ILotteryDAL lotteryDAL;

    @Mock
    private IClientDAL clientDAL;


    @BeforeEach
    public void setUp()
    {
        List<Client> clients = List.of(
                new Client(1,"test1","test", "075555555", "test@test.com", false),
                new Client(2,"test2","test", "075555555", "test@test.com", false),
                new Client(3,"test3","test", "075555555", "test@test.com", false)

        );

        List<Lottery> lotteries = List.of(
                new Lottery(1,"test1",20, clients),
                new Lottery(2,"test2",25, clients),
                new Lottery(3,"test3",20, clients)

        );


        when(lotteryDAL.getLotteryById(1)).thenReturn(lotteries.get(0));
        when(lotteryDAL.deleteLottery(1)).thenReturn(true);
        when(lotteryDAL.getAllLotteries()).thenReturn(lotteries);
    }

    @Test
    public void getAllLotteriesTest_ReturnList()
    {
        //arrange
        LotteryService service = new LotteryService(lotteryDAL, clientDAL, new LotteryConverter(), new ClientConverter());

        //act
        List<LotteryDTO> lotteryDTOS = service.getAllLotteries();

        //assert
        Assertions.assertEquals(1, lotteryDTOS.get(0).getId());
        Assertions.assertEquals(2, lotteryDTOS.get(1).getId());
        Assertions.assertEquals(3, lotteryDTOS.get(2).getId());
    }

    @Test
    public void getLotteryById()
    {
        //arrange
        LotteryService service = new LotteryService(lotteryDAL,clientDAL, new LotteryConverter(), new ClientConverter());
        List<Client> clients = List.of(
                new Client(1,"test1","test", "075555555", "test@test.com", false),
                new Client(2,"test2","test", "075555555", "test@test.com", false),
                new Client(3,"test3","test", "075555555", "test@test.com", false)

        );
        Lottery lottery =  new Lottery(1,"test1",20, clients);

        //act
        when(lotteryDAL.getLotteryById(4)).thenReturn(lottery);
        LotteryDTO postToBeCheck =service.getLotteryById(4);

        //assert
        Assertions.assertEquals("test1", postToBeCheck.getName());
    }

    @Test
    public void deleteLottery()
    {

        //arrange
        LotteryService service = new LotteryService(lotteryDAL,clientDAL,new LotteryConverter(), new ClientConverter());

        //act
        List<LotteryDTO> lotteryDTOS = service.getAllLotteries();
        var result = service.deleteLottery(lotteryDTOS.get(0).getId());

        //assert
        Assertions.assertEquals(result,true);
    }

    @Test
    public void addLottery()
    {
        //arrange
        LotteryService service = new LotteryService(lotteryDAL, clientDAL, new LotteryConverter(), new ClientConverter());

        //act
        List<Integer> clients = List.of(
                1,
                2,
                3
        );
        LotteryDTO lotteryDTO =  new LotteryDTO(4,"test3","test3",20,0, clients);
        service.createLottery(lotteryDTO);

        //assert
        ArgumentCaptor<Lottery> newsArgumentCaptor = ArgumentCaptor.forClass(Lottery.class);
        verify(lotteryDAL).createLottery(newsArgumentCaptor.capture());
        Lottery capturePost = newsArgumentCaptor.getValue();
        Assertions.assertEquals(lotteryDTO.getName(), capturePost.getName());
    }

    @Test
    public void updateLottery() {
        //arrange
        LotteryService service = new LotteryService(lotteryDAL, clientDAL, new LotteryConverter(), new ClientConverter());

        //act
        List<Integer> clients = List.of(
                1,
                2,
                3
        );
        LotteryDTO lotteryDTO =  new LotteryDTO(4,"test3","test3",20,0, clients);
        service.createLottery(lotteryDTO);

        lotteryDTO.setName("Test");
        service.editLottery(lotteryDTO);

        //assert
        ArgumentCaptor<Lottery> newsArgumentCaptor = ArgumentCaptor.forClass(Lottery.class);
        verify(lotteryDAL).editLottery(newsArgumentCaptor.capture());
        Lottery capturePost = newsArgumentCaptor.getValue();
        Assertions.assertEquals(lotteryDTO.getName(), capturePost.getName());
    }
}
