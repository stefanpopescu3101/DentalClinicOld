package com.example.dentalclinic.Interfaces;

import com.example.dentalclinic.Models.Doctor;
import com.example.dentalclinic.Models.Service;

import java.util.List;

public interface IService {

    List<Service> getAllServices();
    Service getServiceById(Integer id);
    boolean addService(Service service);
    boolean editService(Service service);
    boolean deleteService(Integer id);
}
