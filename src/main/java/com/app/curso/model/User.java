/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.curso.model;

/**
 *
 * @author usuario
 */
import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
  private Integer folioRegistro;
    private Integer noPersonalFc;
    private Integer noPersonal;
    private String rfc;
    private String curp;
    private String ap1;
    private String ap2;
    private String nombre;
    private String genero;
    private String cct;
    private String correo;
    private String telMovil;
    private String telOtro;
    private Date fechaNac;
    private String nombreDirector;
    private String nombreCT;
    private String domicilio;
    private String localidad;
    private String municipio;
    private String cpct;
    private String sector;
    private String zonaCt;
    private String nivelEducativoCt;
    private byte[] pdfIne;
    private byte[] pdfTalon;
    private int idCurso;
    private int idSede;
    private String dirigidoA;
    private String nombreCurso;
    private String nombreSede;
    private int horasPresenciales;
    private String calleCurso;
    private String coloniaCurso;
    private String municipioSede;
    
}