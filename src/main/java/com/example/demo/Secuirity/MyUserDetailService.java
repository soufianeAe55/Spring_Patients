/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Secuirity;

import com.example.demo.dao.UserRep;
import com.example.demo.dao.UserRolesRepo;
import com.example.demo.entites.users;
import com.example.demo.entites.users_roles;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Soufiane
 */
@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    UserRep userRep;
    @Autowired
    UserRolesRepo userRoleRep;
    
    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
         Optional<users> user=  userRep.findById(string);
         if(!user.isPresent()) {
            throw new UsernameNotFoundException(string);
        }
        users ActuelUser =user.get();
        Collection<users_roles> listRoles = userRoleRep.findAllByUsername(ActuelUser.getUsername());

        List<GrantedAuthority> authorities = new ArrayList<>();
        for(users_roles role : listRoles){
            System.out.println(role);
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRole()));
        }

        return new User(ActuelUser.getUsername(),ActuelUser.getPassword(),authorities);
         
    }
    
}
