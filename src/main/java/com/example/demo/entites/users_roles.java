/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.entites;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author Soufiane
 */
@Entity
@Data @ToString @NoArgsConstructor @AllArgsConstructor 
public class users_roles {
    @Id
     private String username;
     private String role;
    
}
