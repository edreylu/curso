/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.curso.rowMapper;

import com.app.curso.model.Curso;
import com.app.curso.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author usuario
 */
public class CursoRowMapper implements RowMapper<Curso>{
    
     @Override
    public Curso mapRow(ResultSet rs, int rowNum) throws SQLException {
        Curso curso = new Curso();
                curso.setIdCurso(rs.getInt("IDCURSO"));
                curso.setNombreCurso(rs.getString("NOMBRECURSO"));
                curso.setRequisitos(rs.getString("REQUISITOS"));
                curso.setHorasLinea(rs.getInt("HORASLINEA"));
                curso.setHorasPresenciales(rs.getInt("HORASPRECENCIALES"));
                curso.setModalidad(rs.getString("MODALIDAD"));
                curso.setDescripcion(rs.getString("DESCRIPCION"));
                curso.setTipo(rs.getString("TIPO"));
                curso.setArea(rs.getString("AREA"));
                curso.setObjetivo(rs.getString("OBJETIVO"));
                curso.setDirigidoA(rs.getString("DIRIGIDOA"));
        
        return curso;
     
    }
    
}
