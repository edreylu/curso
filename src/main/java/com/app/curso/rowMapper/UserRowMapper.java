/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.curso.rowMapper;

import com.app.curso.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author usuario
 */
public class UserRowMapper implements RowMapper<User>{
    
     @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User us = new User();
                us.setNoPersonalFc(rs.getInt("NOPERSONALFC"));
                us.setNoPersonal(rs.getInt("NOPERSONAL"));
                us.setRfc(rs.getString("RFC"));
                us.setCurp(rs.getString("CURP"));
                us.setAp1(rs.getString("AP1"));
                us.setAp2(rs.getString("AP2"));
                us.setNombre(rs.getString("NOMBRE"));
                us.setGenero(rs.getString("GENERO"));
                us.setCct(rs.getString("CCT"));
                us.setCorreo(rs.getString("CORREO"));
                us.setTelMovil(rs.getString("TELMOVIL"));
                us.setTelOtro(rs.getString("TELOTRO"));
                us.setFechaNac(rs.getDate("FECHANACIMIENTO"));
                us.setNombreDirector(rs.getString("NOMBREDIRECTOR"));
                us.setNombreCT(rs.getString("NOMBRECT"));
                us.setDomicilio(rs.getString("DOMICILIOCT"));
                us.setLocalidad(rs.getString("LOCALIDADCT"));
                us.setMunicipio(rs.getString("MUNICIPIOCT"));
                us.setCpct(rs.getString("CPCT"));
                us.setZonaCt(rs.getString("ZONACT"));
                us.setSector(rs.getString("SECTORCT"));
                us.setNivelEducativoCt(rs.getString("NIVELEDUCATIVOCT"));
        
        return us;
     
    }
    
}
