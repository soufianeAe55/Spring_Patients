/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.dao;

import com.example.demo.entites.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Soufiane
 */
public interface PatientRepository extends JpaRepository <Patient, Long> {
    
}
