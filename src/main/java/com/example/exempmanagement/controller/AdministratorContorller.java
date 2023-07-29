package com.example.exempmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.exempmanagement.form.InsertAdministratorForm;
import com.example.exempmanagement.form.LoginForm;
import com.example.exempmanagement.service.AdministratorService;

@Controller
@RequestMapping("/")
public class AdministratorContorller {
    
    @Autowired
    private AdministratorService administratorService;

    @GetMapping("/")
    public String login(LoginForm form) {
        return "administrator/login";
    }

    @GetMapping("/toInsert")
    public String toInsert(InsertAdministratorForm form) {
        return "administrator/insert";
    }

}
