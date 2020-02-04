package com.app.curso.controller;

import com.app.curso.dao.UserDAO;
import com.app.curso.model.Login;
import com.app.curso.model.User;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppControl {
    @Autowired
    HttpSession session;
    @Autowired
    UserDAO udao;
    @Value("${google.recaptcha.secret}")
    private String key;
    //accesos a aplicacion desde el login hacia el menu cuando si accede y 403 cuando no hay permisos.
    @GetMapping("/")
    public String main(Model model) {
		return "index";
    }
    
    @GetMapping("/login")
    public String index(Model model) {
        return "login";
    }
    
    @PostMapping(value = "/loginProcess")
  public String login(@ModelAttribute("login") Login login) {
      
        System.out.println("com.app.curso.controller.AppControl.login() rfc:"+login.getRfc()+" curp:"+login.getCurp());
    boolean isValidUser = false;
    isValidUser= udao.validaDocente(login.getRfc(), login.getCurp());
    if (isValidUser) {
      User us = udao.generaDatosDocente(login.getRfc(), login.getCurp());
      session.setAttribute("user", us);
      System.out.println("com.app.curso.controller.AppControl.login()"+us.getCurp());
    }

    return isValidUser ? "redirect:/menu" : "redirect:/login?error=true";
  }
  
    @GetMapping("/menu")
    public String menu() {
        return session.getAttribute("user")==null?"redirect:/login":"/menu";
    }

    @GetMapping("/403")
    public String Error403() {
        return "403";
    }
    
    @GetMapping("/logout")
    public String logout() {
        System.out.println("com.app.curso.controller.AppControl.logout()");
        session.removeAttribute("user");
        session.invalidate();
        return "redirect:/";
    }
    
}
