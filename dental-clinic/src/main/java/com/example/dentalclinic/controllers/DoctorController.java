package com.example.dentalclinic.controllers;



import com.example.dentalclinic.dto.DoctorDTO;
import com.example.dentalclinic.serviceInterfaces.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/doctor")
@Controller
public class DoctorController {

    private final IDoctorService service;

    @Autowired
    public DoctorController(IDoctorService service)
    {
        this.service=service;
    }

    //GET at /news
    @GetMapping
    public ResponseEntity<List<DoctorDTO>> getAllDoctors()
    {
        List<DoctorDTO> doctorsList = service.getAllDoctors();

        if(doctorsList != null)
        {
            return ResponseEntity.ok().body(doctorsList);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }

    }
    //GET at news/1 e…g
    @GetMapping("{id}")
    public ResponseEntity<DoctorDTO> getDoctorById(@PathVariable(value = "id")  Integer id) {
        DoctorDTO doctor = service.getDoctorById(id);

        if(doctor != null) {
            return ResponseEntity.ok().body(doctor);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    //POST at http://localhost:8080/news
    @PostMapping()
    public ResponseEntity<DoctorDTO> addDoctor(@RequestBody DoctorDTO doctor) {
        if (doctor == null) {
            return ResponseEntity.notFound().build();
        } else {
            service.addDoctor(doctor);
            return ResponseEntity.ok().body(doctor);
        }

    }
    //DELETE at http://localhost:XXXX/news/
    @DeleteMapping("{id}")
    public ResponseEntity<DoctorDTO> deleteDoctor(@PathVariable("id") Integer id) {
        service.deleteDoctor(id);
        return ResponseEntity.ok().build();

    }

    //PUT at http://localhost:XXXX/news/
    @PutMapping()
    public ResponseEntity<DoctorDTO> editDoctor(@RequestBody DoctorDTO doctor)
    {
        if(service.editDoctor(doctor))
        {
            return ResponseEntity.ok().body(doctor);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }
}
