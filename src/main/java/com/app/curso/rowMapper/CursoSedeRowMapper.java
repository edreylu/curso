/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.curso.rowMapper;

import com.app.curso.model.CursoSede;
import com.app.curso.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author usuario
 */
public class CursoSedeRowMapper implements RowMapper<CursoSede>{
    
     @Override
    public CursoSede mapRow(ResultSet rs, int rowNum) throws SQLException {
        CursoSede cursosede = new CursoSede();
                cursosede.setIdSede(rs.getInt("IDSEDE"));
                cursosede.setCalle(rs.getString("CALLE"));
                cursosede.setColonia(rs.getString("COLONIA"));
                cursosede.setLocalidad(rs.getString("LOCALIDAD"));
                cursosede.setMunicipio(rs.getString("MUNICIPIO"));
                cursosede.setNombreSede(rs.getString("NOMBRESEDE"));
                cursosede.setLatitud(rs.getString("LATITUD"));
                cursosede.setLongitud(rs.getString("LONGITUD"));
                cursosede.setCorreoContacto(rs.getString("CORREOCONTACTO"));
                cursosede.setNombreContacto(rs.getString("NOMBRECONTACTO"));
                cursosede.setTelContacto(rs.getString("TELCONTACTO"));
                cursosede.setRegion(rs.getString("REGION"));
                cursosede.setUnidadUPN(rs.getString("UNIDADUPN"));
                cursosede.setCupo(rs.getInt("CUPO"));
                cursosede.setSobreCupo(rs.getInt("SOBRECUPO"));
                cursosede.setFechaInicio(rs.getDate("FECHAINICIO"));
                cursosede.setFacilitador(rs.getString("FACILITADOR"));
        
        return cursosede;
     
    }
    
}
