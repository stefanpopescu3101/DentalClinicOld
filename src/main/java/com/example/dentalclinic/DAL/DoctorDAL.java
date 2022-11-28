package com.example.dentalclinic.DAL;

import com.example.dentalclinic.Interfaces.IDoctor;
import com.example.dentalclinic.Models.Customer;
import com.example.dentalclinic.Models.Doctor;
import com.example.dentalclinic.repoInterfaces.ICustomerRepository;
import com.example.dentalclinic.repoInterfaces.IDoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DoctorDAL implements IDoctor {
    @Autowired
    IDoctorRepository repo;

    public DoctorDAL(IDoctorRepository repo)
    {
        this.repo=repo;
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return repo.findAll();
    }

    @Override
    public Doctor getDoctorById(Integer id) {
        return repo.findById(id).get();
    }

    @Override
    public boolean addDoctor(Doctor doctor) {
        if(doctor==null)
        {
            repo.save(doctor);
            return true;
        }
        return  false;
    }

    @Override
    public boolean editDoctor(Doctor doctor) {
        Doctor updatedDoctor= this.getDoctorById(doctor.getId());
        if(updatedDoctor != null) {
            updatedDoctor.setTitle(doctor.getTitle());
            updatedDoctor.setFirstName(doctor.getFirstName());
            updatedDoctor.setLastName(doctor.getLastName());
            updatedDoctor.setPhone(doctor.getPhone());
            updatedDoctor.setEmail(doctor.getEmail());
            repo.save(updatedDoctor);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteDoctor(Integer id) {
        if(getDoctorById(id).getId() == id)
        {
            repo.delete(getDoctorById(id));
            return true;
        }
        return false;
    }
}
