package com.example.dentalclinic.ServiceClassesTests;


import com.example.dentalclinic.Models.Doctor;
import com.example.dentalclinic.Models.Treatment;
import com.example.dentalclinic.converters.DoctorConverter;
import com.example.dentalclinic.converters.TreatmentConverter;
import com.example.dentalclinic.dalInterfaces.IDoctorDAL;
import com.example.dentalclinic.dalInterfaces.ITreatmentDAL;
import com.example.dentalclinic.dto.DoctorDTO;
import com.example.dentalclinic.dto.TreatmentDTO;
import com.example.dentalclinic.service.TreatmentService;
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
public class TreatmentServiceMockTest {

    @Mock
    private ITreatmentDAL treatmentDAL;
    @Mock
    private IDoctorDAL doctorDAL;

    @BeforeEach
    public void setUp()
    {
        List<Treatment> treatments = List.of(
                new Treatment(1,"title1", 5, 20, "skrrr", new Doctor()),
                new Treatment(2,"title2", 5, 20, "skrrr", new Doctor()),
                new Treatment(3,"title3", 5, 20, "skrrr", new Doctor())

        );
        when(treatmentDAL.getTreatmentById(1)).thenReturn(treatments.get(0));
        when(treatmentDAL.deleteTreatment(1)).thenReturn(true);
        when(treatmentDAL.getAllTreatments()).thenReturn(treatments);

        Doctor doctor = new Doctor(1,"Ortodont","Floricica","Dansatoarea","female","13/01/2000",6000113, 123,"f.dansatoarea@gmail.com", true);
        when(doctorDAL.getDoctorById(doctor.getId())).thenReturn(doctor);
    }

    @Test
    public void getAllTreatmentsTest_ReturnList()
    {
        //arrange
        TreatmentService service = new TreatmentService(treatmentDAL,new TreatmentConverter(), doctorDAL, new DoctorConverter());

        //act
        List<TreatmentDTO> treatments = service.getAllTreatments();

        //assert
        Assertions.assertEquals(1, treatments.get(0).getId());
        Assertions.assertEquals(2, treatments.get(1).getId());
        Assertions.assertEquals(3, treatments.get(2).getId());
    }

    @Test
    public void getTreatmentById()
    {
        //arrange
        TreatmentService service = new TreatmentService(treatmentDAL,new TreatmentConverter(), doctorDAL, new DoctorConverter());
        Treatment treatment =  new Treatment(4,"title4", 5, 20, "skrrr", new Doctor());

        //act
        when(treatmentDAL.getTreatmentById(4)).thenReturn(treatment);
        TreatmentDTO postToBeCheck =service.getTreatmentById(4);

        //assert
        Assertions.assertEquals("title4", postToBeCheck.getTitle());
    }

    @Test
    public void deleteTreatment()
    {

        //arrange
        TreatmentService service = new TreatmentService(treatmentDAL,new TreatmentConverter(), doctorDAL, new DoctorConverter());

        //act
        List<TreatmentDTO> treatments = service.getAllTreatments();
        var result = service.deleteTreatment(treatments.get(0).getId());

        //assert
        Assertions.assertEquals(result,true);
    }

    @Test
    public void addTreatment()
    {
        //arrange
        TreatmentService service = new TreatmentService(treatmentDAL,new TreatmentConverter(), doctorDAL, new DoctorConverter());


        //act
        TreatmentDTO treatmentDTO =  new TreatmentDTO(4,"title4", 1, 20, 15, "skrr");
        service.addTreatment(treatmentDTO);

        //assert
        ArgumentCaptor<Treatment> treatmentArgumentCaptor = ArgumentCaptor.forClass(Treatment.class);
        verify(treatmentDAL).addTreatment(treatmentArgumentCaptor.capture());
        Treatment capturePost = treatmentArgumentCaptor.getValue();
        Assertions.assertEquals(treatmentDTO.getTitle(), capturePost.getTitle());
    }

    @Test
    public void updateTreatment() {
        //arrange
        TreatmentService service = new TreatmentService(treatmentDAL,new TreatmentConverter(), doctorDAL, new DoctorConverter());

        //act
        TreatmentDTO treatmentDTO =  new TreatmentDTO(4,"title4", 1, 20, 15.12, "skrr");
        service.addTreatment(treatmentDTO);

        treatmentDTO.setTitle("title5");
        service.editTreatment(treatmentDTO);

        //assert
        ArgumentCaptor<Treatment> treatmentArgumentCaptor = ArgumentCaptor.forClass(Treatment.class);
        verify(treatmentDAL).editTreatment(treatmentArgumentCaptor.capture());
        Treatment capturePost = treatmentArgumentCaptor.getValue();
        Assertions.assertEquals(treatmentDTO.getTitle(), capturePost.getTitle());
    }
}
