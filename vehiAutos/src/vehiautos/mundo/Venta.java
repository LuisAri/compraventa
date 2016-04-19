/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehiAutos.mundo;

/**
 *
 * @author Diego
 */
public class Venta 
{
 //-------------CONSTANTE---------//
    public Producto producto;

    public int cantidad;

    public int valor;

    public String fecha;
    
    public int idventa;

    //----------CONSTRUCTOR---------------------//

    public Venta() {

    }

    public Venta(int idventa,int nCantidad, String fecha,Producto producto,int valor) {
        this.idventa=idventa;
        cantidad = nCantidad;
        this.valor = valor;
        this.fecha = fecha;
        this.producto = producto;
    }
    
    public Venta(int nCantidad, String fecha,Producto producto,int valor) {
        cantidad = nCantidad;
        this.valor = valor;
        this.fecha = fecha;
        this.producto = producto;
    }

    //----------METODOS--------------------//
    /**
     * agrega una valor del dia de la compra
     */
    public String darFechaValor() {
        return fecha;
    }

    /**
     * agrega una cantidad tipo valor
     */
    public int darCantidad() {
        return cantidad;
    }

    /**
     * agrega un valor de compra
     */
    public int darValor() {
        return valor;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

}
   
