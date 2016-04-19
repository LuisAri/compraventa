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
import java.util.ArrayList;
import java.util.List;
import vehiAutos.mundo.Producto;

/**
 *
 * @author Diego
 */
public class ProductoDAO {
    
     Producto producto;
    /**
     * @uml.property name="conexion"
     */
    private Connection conexion;

    /**
     * @uml.property name="fachadaDB"
     * @uml.associationEnd inverse="clienteDAO:rhoes.datos.FachadaDB"
     */
    private final FachadaDB fachadaDB;

    public ProductoDAO() {
        fachadaDB = new FachadaDB();
    }

    public Producto consultar(String id) throws ClassNotFoundException, SQLException {

        conexion = fachadaDB.conectar();
        ResultSet result;
        Statement s = conexion.createStatement();
        result = s.executeQuery("select * from producto where idproducto='" + id + "'");

        if (result.next()) {
            String idproducto = result.getObject("idproducto").toString();
            int valor = Integer.parseInt(result.getObject("valor").toString());
            int cantidad = Integer.parseInt(result.getObject("cantidad").toString());
            String fecha_ingreso = result.getObject("fecha_ingreso").toString();
            producto = new Producto(id, valor, id, cantidad, id);
            System.out.print(producto.Nombre);
            return producto;
        } else {
            return null;
        }

    }

    /**
     * @param producto
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public boolean eliminar(Producto producto) throws ClassNotFoundException, SQLException {

        String query = "delete from producto where idproducto='" + producto.Nombre + "'";
        conexion = fachadaDB.conectar();
        Statement s = conexion.createStatement();
        s.executeUpdate(query);
        fachadaDB.desconectar();
        return false;

    }

    /**
     * @param producto
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public boolean modificar(Producto producto) throws ClassNotFoundException, SQLException {

        String query = "update producto set idproducto='" + producto.Nombre + "',valor=" + producto.Valor
                + ",cantidad=" + producto.cantidad + ",fecha_ingreso='" + producto.fecha
                + "' where idproducto='" + producto.Nombre + "'";

        System.out.print(query);
        conexion = fachadaDB.conectar();
        Statement s = conexion.createStatement();
        s.executeUpdate(query);
        fachadaDB.desconectar();
        return false;
    }
    /**
     * 
     * @param pro
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException 
     */

    public boolean guardar(Producto pro) throws ClassNotFoundException, SQLException {

        String query = "insert into producto (idproducto,valor,cantidad,fecha_ingreso)"
                + "values ('" + pro.Nombre + "'," + pro.Valor + "," + pro.cantidad + ",'" + pro.fecha + "')";

        conexion = fachadaDB.conectar();
        Statement s = conexion.createStatement();
        s.executeUpdate(query);
        fachadaDB.desconectar();
        return false;

    }
    /**
     * 
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */

    public List<Object[]> VehiculoMasVendido() throws SQLException, ClassNotFoundException {

        String query = "select producto_idproducto, count(producto_idproducto) as n "
                + "from venta "
                + "group by producto_idproducto "
                + "order by n desc";

        conexion = fachadaDB.conectar();
        Statement s = conexion.createStatement();
        ResultSet rs = s.executeQuery(query);
        

        List<Object[]> records = new ArrayList();
        while (rs.next()) {
            int cols = rs.getMetaData().getColumnCount();
            Object[] arr = new Object[cols];
            for (int i = 0; i < cols; i++) {
                arr[i] = rs.getObject(i + 1);
            }
            records.add(arr);
        }
        
        fachadaDB.desconectar();
        return records;
    }
}
