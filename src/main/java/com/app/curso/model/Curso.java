/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.curso.model;

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
public class Curso {
 private Integer idCurso;
    private String nombreCurso;
    private String requisitos;
    private Integer horasLinea;
    private Integer horasPresenciales;
    private String modalidad;
    private String descripcion;
    private String tipo;
    private String area;
    private String objetivo;
    private String dirigidoA;
    private CursoSede sede;   
}
