package com.example.exempmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.exempmanagement.domain.Administrator;
import com.example.exempmanagement.form.InsertAdministratorForm;
import com.example.exempmanagement.form.LoginForm;
import com.example.exempmanagement.service.AdministratorService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class AdministratorContorller {
    
    @Autowired
    private AdministratorService administratorService;
    @Autowired
    private HttpSession session;

    @GetMapping("/")
    public String login(LoginForm form) {
        return "administrator/login";
    }

    @GetMapping("/toInsert")
    public String toInsert(InsertAdministratorForm form) {
        return "administrator/insert";
    }

    @PostMapping("/insert")
    public String insert(@Validated InsertAdministratorForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "administrator/insert"; 
        }
        
        Administrator admin = new Administrator();
        admin.setName(form.getName());
        admin.setMailAddress(form.getMailAddress());
        admin.setPassword(form.getPassword());
        administratorService.insert(admin);

        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(LoginForm form, Model model) {
        Administrator admin = administratorService.login(form.getMailAddress(), form.getPassword());
        if (admin == null) {
            model.addAttribute("loginFailure", "メールアドレスまたはパスワードが不正です");
            return "administrator/login";
        }
        session.setAttribute("administratorName", admin.getName());
        return "redirect:/employee/showList";
    }

    @GetMapping("/logout")
    public String logout(LoginForm form) {
        session.invalidate();
        return "redirect:/";
    }

}
