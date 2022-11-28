package com.example.dentalclinic.DAL;

import com.example.dentalclinic.Interfaces.IService;
import com.example.dentalclinic.Models.Doctor;
import com.example.dentalclinic.Models.Service;
import com.example.dentalclinic.repoInterfaces.IDoctorRepository;
import com.example.dentalclinic.repoInterfaces.IServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ServiceDAL implements IService {
    @Autowired
    IServiceRepository repo;

    public ServiceDAL(IServiceRepository repo)
    {
        this.repo=repo;
    }

    @Override
    public List<Service> getAllServices() {
        return repo.findAll();
    }

    @Override
    public Service getServiceById(Integer id) {
        return repo.findById(id).get();
    }

    @Override
    public boolean addService(Service service) {
        if(service==null)
        {
            repo.save(service);
            return true;
        }
        return  false;
    }

    @Override
    public boolean editService(Service service) {
        Service updatedService= this.getServiceById(service.getId());
        if(updatedService != null) {
            updatedService.setTitle(service.getTitle());
            updatedService.setDoctorID(service.getDoctorID());
            updatedService.setDoctorName(service.getDoctorName());
            updatedService.setDuration(service.getDuration());
            updatedService.setPrice(service.getPrice());
            updatedService.setDescription(service.getDescription());
            repo.save(updatedService);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteService(Integer id) {
        if(getServiceById(id).getId() == id)
        {
            repo.delete(getServiceById(id));
            return true;
        }
        return false;
    }
}
