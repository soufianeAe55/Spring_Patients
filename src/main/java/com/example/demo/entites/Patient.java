/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.entites;

import com.sun.istack.NotNull;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Soufiane
 */
@Entity
@Data @ToString @NoArgsConstructor @AllArgsConstructor 
public class Patient {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date datNaisssance;
    @NotNull
   
    private String name;
    private boolean malade;
}
