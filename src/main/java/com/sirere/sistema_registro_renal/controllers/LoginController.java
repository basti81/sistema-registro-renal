package com.sirere.sistema_registro_renal.controllers;

import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

//    @GetMapping(value="/logout")
//    public String logout(HttpServletRequest request){
//        SecurityContextLogoutHandler logoutHandler =
//                new SecurityContextLogoutHandler();
//        logoutHandler.logout(request, null, null);
//        return "/login";
//    }

}
