/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controllers;

import com.example.demo.dao.PatientRepository1;
import com.example.demo.entites.Patient;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Soufiane
 */
@Controller
public class PatientController {
    
     @Autowired 
    private PatientRepository1 pr;
    
    @GetMapping(path="/index")
    public String index(Model model,
    @RequestParam(name="page", defaultValue="0")int page,
    @RequestParam(name="size", defaultValue="5")int size,
    @RequestParam(name="keyword", defaultValue="")String kw
    ){
        Page <Patient> Pagepatients=pr.findByNameContains(kw,PageRequest.of(page,size));
        model.addAttribute("patients",Pagepatients.getContent());
        model.addAttribute("pages",new int[Pagepatients.getTotalPages()]);
        model.addAttribute("pageActuel",page);
         model.addAttribute("size",size);
        model.addAttribute("keyword",kw);
        return "index";
    }
    
    @GetMapping(path="/deletePatient")
    public String deletePatient(long id, String keyword, int page, int size){
       pr.deleteById(id);
        return "redirect:/index?page="+page+"&size="+size+"&keyword="+keyword;
    }
    @GetMapping(path="/PatientForm")
    public String getForm(Model model){
        model.addAttribute("patient",new Patient());
         model.addAttribute("mode","new");
        return "addPatient";
    }
    
    @PostMapping(path="/addPatient")
    public String addPatient(Model model, Patient p, BindingResult br){
        if(br.hasErrors())  return "addPatient";
        pr.save(p);
         model.addAttribute("patient",p);
        return "confirmation";
    }
    @GetMapping(path="/updatePatient")
    public String updatePatient(Model model,long id){
       Patient p=pr.findById(id).get();
        model.addAttribute("patient",p);
        model.addAttribute("mode","update");
        return "addPatient";
    }
}
