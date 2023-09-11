package com.login.UserLogin.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRolesController {

    @GetMapping("/accessAdmin")
    @PreAuthorize("hasRole('ADMIN')")
    public String accessAdmin(){
        return "Hell, You accessed with ADMIN role";
    }

    @GetMapping("/accessUser")
    @PreAuthorize("hasRole('USER')")
    public String accessUser(){
        return " Hell, You accessed with USER role ";
    }

    @GetMapping("/accessGuest")
    @PreAuthorize("hasRole('Guest')")
    public String accessInvited(){
        return "Hell, You accessed with Guest role";
    }
}
