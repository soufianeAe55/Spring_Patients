package com.example.demo;

import com.example.demo.dao.PatientRepository;
import com.example.demo.dao.PatientRepository1;
import com.example.demo.entites.Patient;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 
@SpringBootApplication
public class PatientsApplication implements CommandLineRunner {

   @Autowired 
   private PatientRepository1 pr;  
   
   public static void main(String[] args) {
		SpringApplication.run(PatientsApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        pr.save(new Patient(0,new Date(),"james",false));
        pr.save(new Patient(0,new Date(),"user",true));
        pr.save(new Patient(0,new Date(),"Hassan",true));
        
        List <Patient> ps= pr.findAll();
        
        ps.forEach(pt -> {
            System.out.println( pt.getName());
        });
        
        
    }

}
