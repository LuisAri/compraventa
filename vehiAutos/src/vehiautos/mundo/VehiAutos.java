/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehiAutos.mundo;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.List;
import vehiautos.interfaz.VentanaPrincipal;
import vehiautos.datos.PersonaDAO;
import vehiautos.datos.ProductoDAO;
import vehiautos.datos.VentaDAO;
import vehiautos.datos.TrabajadorDAO;

/**
 *
 * @author Diego
 */
public class VehiAutos 
{
    //----------constante------------------//
    
    
  
    private final PersonaDAO m_personas;
     private final ProductoDAO m_productos;
    private final VentaDAO m_ventas;
    private  final TrabajadorDAO m_Trabajador;
//----------Metodos---------------------//
      public VehiAutos() {
        m_personas = new PersonaDAO();
        m_productos = new ProductoDAO();
        m_ventas = new VentaDAO();
        m_Trabajador = new TrabajadorDAO();
    }
       public List<Object[]> VehiculoMasVendido() throws SQLException, ClassNotFoundException{
        return m_productos.VehiculoMasVendido();
    }
      
    public Persona buscarPersona(int cedula) throws ClassNotFoundException, SQLException, Exception {
        Persona p = m_personas.consultar(cedula);
        return p;
    }
      public Producto buscarProducto(String nombre) throws SQLException, ClassNotFoundException, Exception {
        Producto p = m_productos.consultar(nombre);
        return p;
    }
      public Trabajador buscarTrabajador(int cedula) throws ClassNotFoundException, SQLException, Exception{
          Trabajador t = m_Trabajador.consultar(cedula);
          return t;
      }
     
    
    
     public void Agregar_cliente(int cedula, String nombre, int edad, String fecha_nacimiento, String direccion, int telefono) throws Exception  {
        
             Persona miPersona = buscarPersona(cedula);
        if (miPersona == null) {
            miPersona = new Persona(nombre, edad, cedula, fecha_nacimiento, direccion, telefono);
            m_personas.guardar(miPersona);
        } else {
            throw new Exception("El cliente ya existe");
        }
    }
     public void Agregar_Producto(String nombre, int valor, String fecha, int cantidad, String marca) throws Exception {
        Producto producto = buscarProducto(nombre);

        if (producto == null) {
            producto = new Producto(nombre, valor, fecha, cantidad, marca);
            m_productos.guardar(producto);
        } else {
            throw new Exception("El producto ya existe");
        }
        
    }
     public void Agregar_Trabajador(String nombre, int cedula) throws Exception
     {
        Trabajador trabajador = buscarTrabajador(cedula);
        if (trabajador == null)
        {
            trabajador = new Trabajador(nombre, cedula);
            m_Trabajador.guardar(trabajador);
        }
        else
        {
            throw new Exception("el trabajador ya existe");
        }
        
     }
     public void eliminarProducto(String nombre) throws ClassNotFoundException, SQLException, Exception {
        Producto producto = buscarProducto(nombre);
        if (producto != null) {
            m_productos.eliminar(producto);
        } else {
            throw new Exception("El producto no existe");
        }
    }
     public void eliminarCliente(int cedula) throws ClassNotFoundException, SQLException, Exception {
        Persona persona = buscarPersona(cedula);
        if (persona != null) {
            m_personas.eliminar(persona);
        } else {
            throw new Exception("El cliente no existe");
        }
     }
     public void eliminarTrabajador(int cedula) throws ClassNotFoundException, SQLException, Exception {
        Trabajador trabajador = buscarTrabajador(cedula);
        if (trabajador != null) {
            m_Trabajador.eliminar(trabajador);
        } else {
            throw new Exception("El trabajador no existe");
        }
     }
      public void modificarCliente(Persona persona) throws ClassNotFoundException, SQLException, Exception {
        m_personas.modificar(persona);
    }
    
    public void modificarProducto(Producto producto) throws ClassNotFoundException, SQLException, Exception {
        m_productos.modificar(producto);
    }
     public void modificarTrabajador(Trabajador trabajador) throws ClassNotFoundException, SQLException, Exception {
        m_Trabajador.modificar(trabajador);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VehiAutos manager = new  VehiAutos();
                    VentanaPrincipal frame = new VentanaPrincipal(manager);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }   
}    
