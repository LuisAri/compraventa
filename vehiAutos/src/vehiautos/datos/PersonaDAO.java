/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehiautos.datos;

import vehiAutos.mundo.Persona;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Diego
 */
public class PersonaDAO {
    Persona persona;
    /**
     * @uml.property name="conexion"
     */
    private Connection conexion;

    /**
     * @uml.property name="fachadaDB"
     * @uml.associationEnd inverse="clienteDAO:rhoes.datos.FachadaDB"
     */
    private final FachadaDB fachadaDB;

    public PersonaDAO() {
        fachadaDB = new FachadaDB();
    }

    public Persona consultar(int cedula) throws ClassNotFoundException, SQLException {

        conexion = fachadaDB.conectar();
        ResultSet result;
        Statement s = conexion.createStatement();
        result = s.executeQuery("select * from persona where cedula=" + cedula);

        if (result.next()) {
            int id = Integer.parseInt(result.getObject("cedula").toString());
            String nombre = result.getObject("nombre").toString();
            String direccion = result.getObject("direccion").toString();
            int telefono = Integer.parseInt(result.getObject("telefono").toString());
            String fecha_nacimiento = result.getObject("fecha_nacimiento").toString();
            int edad = Integer.parseInt(result.getObject("edad").toString());
            persona = new Persona(nombre, edad, id, fecha_nacimiento, direccion, telefono);
            return persona;
        } else {
            return null;
        }
    }

    /**
     * @param persona
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public boolean eliminar(Persona persona) throws ClassNotFoundException, SQLException {

        String query = "delete * from persona where cedula=" + persona.cedula;
        conexion = fachadaDB.conectar();
        Statement s = conexion.createStatement();
        s.executeUpdate(query);
        fachadaDB.desconectar();
        return false;

    }

    /**
     * @param persona
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public boolean modificar(Persona persona) throws ClassNotFoundException, SQLException {

        String query = "update persona set cedula="+persona.cedula+",nombre='"+persona.nombre+
                       "',direccion='"+persona.Direccion+"',telefono="+persona.Telefono+
                       ",fecha_nacimiento='"+persona.fechaNacimiento+"',edad="+persona.edad+
                       " where cedula="+persona.cedula;
        System.out.print(query);
        conexion = fachadaDB.conectar();
        Statement s = conexion.createStatement();
        s.executeUpdate(query);
        fachadaDB.desconectar();
        return false;
    }

    public boolean guardar(Persona per) throws ClassNotFoundException, SQLException {

        String query = "insert into persona (cedula,nombre,direccion,telefono,fecha_nacimiento,edad)"
                + "values (" + per.cedula + ",'" + per.nombre + "','" + per.Direccion + "'," + per.Telefono + ",'" + per.fechaNacimiento + "'," + per.edad + ")";
        conexion = fachadaDB.conectar();
        Statement s = conexion.createStatement();
        s.executeUpdate(query);
        fachadaDB.desconectar();
        return false;
    }

}
    

