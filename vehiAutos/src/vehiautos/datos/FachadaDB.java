/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehiautos.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Diego
 */
public class FachadaDB {
    /**
     * constante que maneja la cadena de conexion a la base de datos mySQL
     *
     * @uml.property name="DRIVER" readOnly="true"
     */
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    /**
     * Constante para identificar la base de datos
     *
     * @uml.property name="URL" readOnly="true"
     */
    public static final String URL = "jdbc:mysql://localhost:3306/tiendaBD?zeroDateTimeBehavior=convertToNull";
    /**
     * Constante para identificar el nombre de ususario de la base de datos
     *
     * @uml.property name="USUARIO" readOnly="true"
     */
    public static final String USUARIO = "root";
    /**
     * password que permite loguear el usuario con al base de datos
     *
     * @uml.property name="PASSWORD" readOnly="true"
     */
    public static final String PASSWORD = "";

    /**
     * atributo que guarda la caonexion a la base de datos
     *
     * @uml.property name="conexion"
     */
    private Connection conexion;

    /**
     * Constructor de la clase que resive los parametros de conexion
     */
    public FachadaDB() {
        conexion = null;
    }

    /**
     * metodo para conectar a la base de datos
     * <b>post:</b> crea una cadena de conexion a la BD
     *
     * @return conexion Cadena de conexion a la base de datos
     * @throws SQLException No se conecto a la base de datos
     * @throws ClassNotFoundException no encontro la clase para conectarse
     */
    public Connection conectar() throws SQLException, ClassNotFoundException {

        Class.forName(DRIVER);
        conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
        return conexion;
    }

    /**
     * metodo que hace la desconexion a la base de datos
     * <b>post: </b> se desconecto la base de datos
     *
     * @throws SQLException no se conecto a la base de datos
     */
    public void desconectar() throws SQLException {

        try {
            conexion.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

    
