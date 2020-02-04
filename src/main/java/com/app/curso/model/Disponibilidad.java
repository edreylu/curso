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
public class Disponibilidad {
  private Integer disponibiliad = 0;
    private String mensaje;
    private Integer idError;  
}
