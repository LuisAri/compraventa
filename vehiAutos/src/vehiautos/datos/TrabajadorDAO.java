/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehiautos.datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import vehiAutos.mundo.Trabajador;

/**
 *
 * @author Diego
 */
public class TrabajadorDAO 
{
  Trabajador trbajador;
    /**
     * @uml.property name="conexion"
     */
    private Connection conexion;

    /**
     * @uml.property name="fachadaDB"
     * @uml.associationEnd inverse="clienteDAO:rhoes.datos.FachadaDB"
     */
    private final FachadaDB fachadaDB;

    public TrabajadorDAO() {
        fachadaDB = new FachadaDB();
    }

    public Trabajador consultar(int cedula) throws ClassNotFoundException, SQLException {

        conexion = fachadaDB.conectar();
        ResultSet result;
        Statement s = conexion.createStatement();
        result = s.executeQuery("select * from persona where cedula=" + cedula);

        if (result.next()) {
            int id = Integer.parseInt(result.getObject("cedula").toString());
            String nombre = result.getObject("nombre").toString();
            
            return trbajador;
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
    public boolean eliminar(Trabajador trabajador) throws ClassNotFoundException, SQLException {

        String query = "delete * from persona where cedula=" + trabajador.cedula;
        conexion = fachadaDB.conectar();
        Statement s = conexion.createStatement();
        s.executeUpdate(query);
        fachadaDB.desconectar();
        return false;

    }

    /**
     * @param Trabajador
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public boolean modificar(Trabajador trabajador) throws ClassNotFoundException, SQLException {

        String query = "update persona set cedula="+trabajador.cedula+",nombre='"+trabajador.nombre+" where cedula="+trabajador.cedula;
        System.out.print(query);
        conexion = fachadaDB.conectar();
        Statement s = conexion.createStatement();
        s.executeUpdate(query);
        fachadaDB.desconectar();
        return false;
    }

    public boolean guardar(Trabajador tra) throws ClassNotFoundException, SQLException {

        String query = "insert into persona (cedula,nombre)"
                + "values (" + tra.cedula + ",'" + tra.nombre + ")";
        conexion = fachadaDB.conectar();
        Statement s = conexion.createStatement();
        s.executeUpdate(query);
        fachadaDB.desconectar();
        return false;
    }   
}
