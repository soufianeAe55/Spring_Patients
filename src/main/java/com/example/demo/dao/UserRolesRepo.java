/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.dao;

import com.example.demo.entites.users;
import com.example.demo.entites.users_roles;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Soufiane
 */
public interface UserRolesRepo extends JpaRepository <users_roles, String> {
    Collection<users_roles> findAllByUsername (String username);
}
