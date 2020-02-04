/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.curso.model;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Admin
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CursoSede {
    private Integer idSede;
    private String calle;
    private String colonia;
    private String localidad;
    private String municipio;
    private String nombreSede;
    private String latitud;
    private String longitud;
    private String correoContacto;
    private String nombreContacto;
    private String region;
    private String telContacto;
    private String unidadUPN;
    private Integer cupo;
    private Integer sobreCupo;
    private Date fechaInicio;
    private String facilitador;
}
