package com.example.dentalclinic.controllers;

import com.example.dentalclinic.Models.Client;
import com.example.dentalclinic.dto.ClientDTO;
import com.example.dentalclinic.dto.LotteryDTO;
import com.example.dentalclinic.serviceInterfaces.ILotteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/lottery")
@Controller
public class LotteryController {
    private final ILotteryService service;

    @Autowired
    public LotteryController(ILotteryService service)
    {
        this.service=service;
    }

    @GetMapping
    public ResponseEntity<List<LotteryDTO>> getAllLotteries()
    {
        List<LotteryDTO> lotteryList = service.getAllLotteries();

        if(lotteryList != null)
        {
            return ResponseEntity.ok().body(lotteryList);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }

    }
    @GetMapping("{id}")
    public ResponseEntity<LotteryDTO> getLotteryById(@PathVariable(value = "id")  Integer id) {
        LotteryDTO lottery = service.getLotteryById(id);

        if(lottery != null) {
            return ResponseEntity.ok().body(lottery);
        } else {
            return ResponseEntity.notFound().build();
        }

    }


    @GetMapping("/viewAttendees/{id}")
    public ResponseEntity<List<ClientDTO>> viewAttendees(@PathVariable(value = "id")  Integer id){
        var attendees = service.viewAttendees(id);
        if(attendees != null)
        {
            return ResponseEntity.ok().body(attendees);
        }
        return ResponseEntity.notFound().build();
    }


    @PostMapping()
    public ResponseEntity<LotteryDTO> createLottery(@RequestBody LotteryDTO lottery) {
        if (lottery == null) {
            return ResponseEntity.notFound().build();
        } else {
            service.createLottery(lottery);
            return ResponseEntity.ok().body(lottery);
        }

    }

    @DeleteMapping("{id}")
    public ResponseEntity<LotteryDTO> deleteLottery(@PathVariable("id") Integer id) {
        service.deleteLottery(id);
        return ResponseEntity.ok().build();

    }

    @PutMapping()
    public ResponseEntity<LotteryDTO> editLottery(@RequestBody LotteryDTO lottery)
    {
        if(service.editLottery(lottery))
        {
            return ResponseEntity.ok().body(lottery);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }
}
