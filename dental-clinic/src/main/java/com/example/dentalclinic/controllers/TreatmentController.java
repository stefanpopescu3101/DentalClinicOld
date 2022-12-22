package com.example.dentalclinic.controllers;


import com.example.dentalclinic.dto.TreatmentDTO;
import com.example.dentalclinic.serviceInterfaces.ITreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/treatments")
@Controller
public class TreatmentController {

    private final ITreatmentService service;

    @Autowired
    public TreatmentController(ITreatmentService service)
    {
        this.service=service;
    }

    @GetMapping
    public ResponseEntity<List<TreatmentDTO>> getAllTreatments()
    {
        List<TreatmentDTO> treatmentsList = service.getAllTreatments();

        if(treatmentsList != null)
        {
            return ResponseEntity.ok().body(treatmentsList);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }

    }
    @GetMapping("{id}")
    public ResponseEntity<TreatmentDTO> getTreatmentById(@PathVariable(value = "id")  Integer id) {
        TreatmentDTO treatment = service.getTreatmentById(id);

        if(treatment != null) {
            return ResponseEntity.ok().body(treatment);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping()
    public ResponseEntity<TreatmentDTO> addTreatment(@RequestBody TreatmentDTO treatment) {
        if (treatment == null) {
            return ResponseEntity.notFound().build();
        } else {
            service.addTreatment(treatment);
            return ResponseEntity.ok().body(treatment);
        }

    }
    @DeleteMapping("{id}")
    public ResponseEntity<TreatmentDTO> deleteTreatment(@PathVariable("id") Integer id) {
        service.deleteTreatment(id);
        return ResponseEntity.ok().build();

    }

    @PutMapping()
    public ResponseEntity<TreatmentDTO> editTreatment(@RequestBody TreatmentDTO treatment)
    {
        if(service.editTreatment(treatment))
        {
            return ResponseEntity.ok().body(treatment);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }
}
