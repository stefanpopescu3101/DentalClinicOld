package com.example.dentalclinic.dal;

import com.example.dentalclinic.Models.Treatment;
import com.example.dentalclinic.dalInterfaces.ITreatmentDAL;
import com.example.dentalclinic.repoInterfaces.ITreatmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository @Transactional
public class TreatmentDAL implements ITreatmentDAL {

    private final ITreatmentRepository repo;
    @Autowired
    public TreatmentDAL(ITreatmentRepository repo)
    {
        this.repo=repo;
    }

    @Override
    public List<Treatment> getAllTreatments() {
        return repo.findAll();
    }

    @Override
    public Treatment getTreatmentById(Integer id) {
        return repo.findById(id).get();
    }

    @Override
    public boolean addTreatment(Treatment treatment) {
        if(treatment != null)
        {
            repo.save(treatment);

            return true;
        }
        return  false;
    }

    @Override
    public boolean editTreatment(Treatment treatment) {
        Treatment updatedTreatment = this.getTreatmentById(treatment.getId());
        if(updatedTreatment != null) {
            updatedTreatment.setTitle(treatment.getTitle());
            updatedTreatment.setDuration(treatment.getDuration());
            updatedTreatment.setPrice(treatment.getPrice());
            updatedTreatment.setDescription(treatment.getDescription());
            repo.save(updatedTreatment);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteTreatment(Integer id) {
        if(getTreatmentById(id).getId() == id)
        {
            repo.delete(getTreatmentById(id));
            return true;
        }
        return false;
    }
}
