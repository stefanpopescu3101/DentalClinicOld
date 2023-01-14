package com.example.dentalclinic.dal;
import com.example.dentalclinic.Models.Client;
import com.example.dentalclinic.Models.Doctor;
import com.example.dentalclinic.Models.Role;
import com.example.dentalclinic.dalInterfaces.IDoctorDAL;
import com.example.dentalclinic.repoInterfaces.IDoctorRepository;
import com.example.dentalclinic.repoInterfaces.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository @Transactional
public class DoctorDAL implements IDoctorDAL {

    private final IDoctorRepository repo;

    private final IRoleRepository roleRepo;

    @Autowired
    public DoctorDAL(IDoctorRepository repo, IRoleRepository roleRepo)
    {
        this.repo=repo;
        this.roleRepo = roleRepo;
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
        if(doctor!=null)
        {
            repo.save(doctor);
            return true;
        }
        return  false;
    }

    @Override
    public void addRole(Integer id, String roleName) {
        Doctor doctor = repo.getReferenceById(id);
        Role role = roleRepo.findByName(roleName);
        doctor.getRoles().add(role);
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
