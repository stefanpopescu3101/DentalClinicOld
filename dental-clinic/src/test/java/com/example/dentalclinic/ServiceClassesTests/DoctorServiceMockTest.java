package com.example.dentalclinic.ServiceClassesTests;

import com.example.dentalclinic.Models.Doctor;
import com.example.dentalclinic.Models.News;
import com.example.dentalclinic.converters.DoctorConverter;
import com.example.dentalclinic.converters.NewsConverter;
import com.example.dentalclinic.dalInterfaces.IDoctorDAL;
import com.example.dentalclinic.dalInterfaces.INewsDAL;
import com.example.dentalclinic.dto.DoctorDTO;
import com.example.dentalclinic.dto.NewsDTO;
import com.example.dentalclinic.service.DoctorService;
import com.example.dentalclinic.service.NewsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@SpringBootTest
public class DoctorServiceMockTest {

    @Mock
    private IDoctorDAL doctorDAL;

    @BeforeEach
    public void setUp()
    {
        List<Doctor> doctors = List.of(
                new Doctor(1,"Ortodont1","Floricica1","Dansatoarea1","female","13/01/2000",6000113, 123,"f.dansatoarea@gmail.com", true),
                new Doctor(2,"Ortodont2","Floricica2","Dansatoarea2","female","13/01/2000",6000113, 123,"f.dansatoarea@gmail.com", true),
                new Doctor(3,"Ortodont3","Floricica3","Dansatoarea3","female","13/01/2000",6000113, 123,"f.dansatoarea@gmail.com", true)

        );


        when(doctorDAL.getDoctorById(1)).thenReturn(doctors.get(0));
        when(doctorDAL.deleteDoctor(1)).thenReturn(true);
        when(doctorDAL.getAllDoctors()).thenReturn(doctors);
    }

    @Test
    public void getAllDoctorsTest_ReturnList()
    {
        //arrange
        DoctorService service = new DoctorService(doctorDAL,new DoctorConverter());

        //act
        List<DoctorDTO> doctors = service.getAllDoctors();

        //assert
        Assertions.assertEquals(1, doctors.get(0).getId());
        Assertions.assertEquals(2, doctors.get(1).getId());
        Assertions.assertEquals(3, doctors.get(2).getId());
    }

    @Test
    public void getDoctorById()
    {
        //arrange
        DoctorService service = new DoctorService(doctorDAL,new DoctorConverter());
        Doctor doctor = new Doctor(4,"Ortodont4","Floricica4","Dansatoarea","female","13/01/2000",6000113, 123,"f.dansatoarea@gmail.com", true);

        //act
        when(doctorDAL.getDoctorById(4)).thenReturn(doctor);
        DoctorDTO postToBeCheck =service.getDoctorById(4);

        //assert
        Assertions.assertEquals("Ortodont4", postToBeCheck.getTitle());
    }

    @Test
    public void deleteDoctor()
    {

        //arrange
        DoctorService service = new DoctorService(doctorDAL,new DoctorConverter());

        //act
        List<DoctorDTO> doctors = service.getAllDoctors();
        var result = service.deleteDoctor(doctors.get(0).getId());

        //assert
        Assertions.assertEquals(result,true);
    }

    @Test
    public void addDoctor()
    {
        //arrange
        DoctorService service = new DoctorService(doctorDAL,new DoctorConverter());

        //act
        List<Integer> treatments = List.of(
                1,
                2,
                3
        );
        DoctorDTO doctorDTO =  new DoctorDTO(4,"Ortodont4","Floricica4","Dansatoarea","female","13/01/2000",6000113,"f.dansatoarea@gmail.com", treatments);
        service.addDoctor(doctorDTO);

        //assert
        ArgumentCaptor<Doctor> newsArgumentCaptor = ArgumentCaptor.forClass(Doctor.class);
        verify(doctorDAL).addDoctor(newsArgumentCaptor.capture());
        Doctor capturePost = newsArgumentCaptor.getValue();
        Assertions.assertEquals(doctorDTO.getTitle(), capturePost.getTitle());
    }

    @Test
    public void updateDoctor() {
        //arrange
        DoctorService service = new DoctorService(doctorDAL,new DoctorConverter());

        //act
        List<Integer> treatments = List.of(
                1,
                2,
                3
        );
        DoctorDTO doctorDTO =  new DoctorDTO(4,"Ortodont4","Floricica4","Dansatoarea","female","13/01/2000",6000113,"f.dansatoarea@gmail.com", treatments);
        service.addDoctor(doctorDTO);

        doctorDTO.setTitle("Test");
        service.editDoctor(doctorDTO);

        //assert
        ArgumentCaptor<Doctor> newsArgumentCaptor = ArgumentCaptor.forClass(Doctor.class);
        verify(doctorDAL).editDoctor(newsArgumentCaptor.capture());
        Doctor capturePost = newsArgumentCaptor.getValue();
        Assertions.assertEquals(doctorDTO.getTitle(), capturePost.getTitle());
    }
}
