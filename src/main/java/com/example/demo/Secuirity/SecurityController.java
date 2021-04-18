/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Secuirity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Soufiane
 */
@Controller
public class SecurityController {
    
    @GetMapping(path="/notAuthorized")
    public String notAuth(){
        return "notAuthorized";
    }
    
    @GetMapping(path="/login")
    public String loginForm(){
        return "loginForm";
    }
    
    @GetMapping(path="/logout")
    public String logout(HttpServletRequest hsr) throws ServletException{
        hsr.logout();
        return "redirect:/login";
    }
}
