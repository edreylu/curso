/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.curso.dao;

import com.app.curso.model.Curso;
import com.app.curso.model.CursoSede;
import com.app.curso.model.Disponibilidad;
import com.app.curso.model.User;
import com.app.curso.rowMapper.CursoRowMapper;
import com.app.curso.rowMapper.CursoSedeRowMapper;
import com.app.curso.rowMapper.UserRowMapper;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author usuario
 */
@Transactional
@Repository
public class UserDAO {
@Autowired
private JdbcTemplate jdbcTemplate;
List lista=null;

public Curso traeCurso() {
Curso cu;
String query =null;
query = "SELECT IDCURSO,\n"
                + "  NOMBRECURSO,\n"
                + "  REQUISITOS,\n"
                + "  HORASLINEA,\n"
                + "  HORASPRECENCIALES,\n"
                + "  MODALIDAD,\n"
                + "  DESCRIPCION,\n"
                + "  TIPO,\n"
                + "  AREA,\n"
                + "  OBJETIVO,\n"
                + "  DIRIGIDOA\n"
                + "FROM CURSO WHERE IDCURSO=1 ORDER BY 1";

    //listaPersonas = jdbctemplate.query(query,new BeanPropertyRowMapper(Usuarios.class)); para clases bien ordenadas
   cu=jdbcTemplate.queryForObject(query,new CursoRowMapper());
   
     return cu;
}

public CursoSede traeSede() {
CursoSede cs;
String query =null;
query = "SELECT SEDE.IDSEDE,\n"
                + "  SEDE.CALLE,\n"
                + "  SEDE.COLONIA,\n"
                + "  SEDE.LOCALIDAD,\n"
                + "  SEDE.MUNICIPIO,\n"
                + "  SEDE.NOMBRESEDE,\n"
                + "  SEDE.LATITUD,\n"
                + "  SEDE.LONGITUD,\n"
                + "  SEDE.CORREOCONTACTO,\n"
                + "  SEDE.NOMBRECONTACTO,\n"
                + "  SEDE.TELCONTACTO,\n"
                + "  SEDE.REGION,\n"
                + "  SEDE.UNIDADUPN,\n"
                + "  CURSOSEDE.CUPO,\n"
                + "  CURSOSEDE.SOBRECUPO,\n"
                + "  CURSOSEDE.FECHAINICIO,\n"
                + "  CURSOSEDE.FACILITADOR\n"
                + "FROM SEDE, \n"
                + "     CURSOSEDE\n"
                + "WHERE SEDE.IDSEDE = CURSOSEDE.IDSEDE\n"
                + "  AND CURSOSEDE.IDCURSO = 1"
                + "  AND CURSOSEDE.IDSEDE = 1"
                + " order by SEDE.REGION";

    //listaPersonas = jdbctemplate.query(query,new BeanPropertyRowMapper(Usuarios.class)); para clases bien ordenadas
   cs=jdbcTemplate.queryForObject(query,new CursoSedeRowMapper());
   
     return cs;
}

public Disponibilidad consultaDisponibilidad() throws SQLException {
Disponibilidad disponibilidad = null;

CallableStatement cstmt;
cstmt = jdbcTemplate.getDataSource().getConnection().prepareCall("{? = call FDBDISPONIBILIDAD(?,?,?,?)}");
            cstmt.registerOutParameter(1, java.sql.Types.NUMERIC);
            cstmt.registerOutParameter(2, java.sql.Types.NUMERIC);
            cstmt.registerOutParameter(3, java.sql.Types.VARCHAR);
            cstmt.setInt(4, 1);
            cstmt.setInt(5, 1);

            cstmt.execute();

            disponibilidad.setDisponibiliad(cstmt.getInt(1));
            disponibilidad.setIdError(cstmt.getInt(2));
            disponibilidad.setMensaje(cstmt.getString(3)==null?"":cstmt.getString(3));
            
            System.out.println("DAO mensaje*********** : " + disponibilidad.getMensaje());
            System.out.println("DAO disponibilidad*********** : " + disponibilidad.getDisponibiliad());
            System.out.println("DAO error*********** : " + disponibilidad.getIdError());

   
     return disponibilidad;
}

public boolean validaDocente(String rfc, String curp) {
String query =null;
query = "SELECT count(*) FROM PERSONAL where RFC=? AND CURP=?";
boolean valor = false;
int count = jdbcTemplate.queryForObject(query, new Object[]{rfc,curp}, Integer.class);
if (count > 0) {
valor = true;
}
return valor;
}
 
public User generaDatosDocente(String rfc, String curp) {
 User us;
 String query =null;
query = "SELECT NOPERSONALFC,\n"
                + "  NOPERSONAL,\n"
                + "  RFC,\n"
                + "  CURP,\n"
                + "  AP1,\n"
                + "  AP2,\n"
                + "  NOMBRE,\n"
                + "  GENERO,\n"
                + "  CCT,\n"
                + "  CORREO,\n"
                + "  TELMOVIL,\n"
                + "  TELOTRO,\n"
                + "  FECHANACIMIENTO,\n"
                + "  NOMBREDIRECTOR,\n"
                + "  NOMBRECT,\n"
                + "  DOMICILIOCT,\n"
                + "  LOCALIDADCT,\n"
                + "  MUNICIPIOCT,\n"
                + "  CPCT,\n"
                + "  ZONACT,\n"
                + "  SECTORCT,\n"
                + "  NIVELEDUCATIVOCT\n"
                + "FROM PERSONAL where RFC=? AND CURP=?";

     us=jdbcTemplate.queryForObject(query,new Object[]{rfc,curp}, new UserRowMapper());
   
     return us;
}




public int editaUsuario(User us) {
 String query =null;
 query= "update personal "
                + "set correo = ?, "
                + "telmovil=?, "
                + "telotro=?\n"
                + " where nopersonal=? ";
  int valor = jdbcTemplate.update(query,us.getCorreo(),
            us.getTelMovil(),
            us.getTelOtro(),
            us.getNoPersonal());
   return valor;
}
/*
public int insertaUsuario(User us) {
    
sql = "INSERT INTO USERS (username, password, enabled) "
                             + "VALUES (?,?,1)";
 int valor = jdbcTemplate.update(sql,us.getUserName(),
            us.getPassword());
 
 sql2 = "INSERT INTO authorities (username, authority) "
                             + "VALUES (?,?)";
 jdbcTemplate.update(sql,us.getUserName(),
            us.getAuthority());
   
   return valor;
}
public Users UsuarioEditar(int id){

Users us;
String sql = "select no_usuario,clave,nombre,apellido_paterno,apellido_materno,correo,"
        + "          telefono,'' rol, '' nombreRol from usuarios where no_usuario ="+id;
     us=jdbcTemplate.queryForObject(sql,new UsuarioRowMaper());
     return us;
}

public int eliminaUsuario(int id) {
 sql= "delete from usuarios where NO_USUARIO = ?";
  int valor = jdbcTemplate.update(sql,id);
   
   return valor;
}
*/

}
