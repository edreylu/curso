/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.curso.controller;

import com.app.curso.dao.UserDAO;
import com.app.curso.model.Curso;
import com.app.curso.model.CursoSede;
import com.app.curso.model.Disponibilidad;
import com.app.curso.model.User;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Admin
 */
@Controller
public class UsersControl {
 @Autowired
 HttpSession session;
 @Autowired
    private UserDAO udao;
    List<User> datos;
    User user;
    List lista;
    int id;
    @GetMapping("/curso")
    public String listar(Model model) throws SQLException{
    Curso curso = new Curso();
    CursoSede cursosede = new CursoSede();
    //Disponibilidad disponibilidad = new Disponibilidad();
    curso = udao.traeCurso();
    cursosede = udao.traeSede();
    //disponibilidad=udao.consultaDisponibilidad();
    model.addAttribute("curso",curso);
    model.addAttribute("cursosede",cursosede);
    //model.addAttribute("disponibilidad",disponibilidad);
    return "/curso";
    }
    
    @GetMapping("/users/editar")
    public String editar(Model model){
    model.addAttribute(new User());
    return "/users/agregar";
    }
    
    @PostMapping(value = "/user/update")
    public String editar(User us){
        boolean isValid = false;
        User u =(User) session.getAttribute("user");
        System.out.println("com.app.curso.controller.UsersControl.editar()"+u.getCurp());
        u.setCorreo(us.getCorreo());
        u.setTelMovil(us.getTelMovil());
        u.setTelOtro(us.getTelOtro());
    int valor =udao.editaUsuario(u);
    if(valor >=1){
        isValid=true;
        System.out.println("se agrego registro: "+valor);
        //session.setAttribute("user", udao.generaDatosDocente(u.getRfc(), u.getCurp()));
    }else{
    System.err.println("no se agrego registro");
    }
    
    return isValid? "redirect:/curso" : "redirect:/menu?error=true";
    }   
}
