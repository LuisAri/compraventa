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
public class Producto 
{
    //-----------CONSTANTE-------------//
    public String Nombre;

    public int Valor;

    public String fecha;

    public int cantidad;
    
    public String marca;
    

    //----------CONSTRUCTOR---------------------//

    /**
     * constuctor de la clase producto
     */

    public Producto() {

    }

    public Producto(String nombre, int valor, String fecha, int cantidad, String marca) {
        this.Nombre = nombre;
        this.Valor = valor;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.marca = marca;

    }

    //----------METODOS--------------------//

    /**
     * agrega un nombre para el producto
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * da un valor del producto
     */
    public int getValor() {
        return Valor;
    }

    /**
     * da una fecha de compra del producto
     */
    public String getFecha() {
        return fecha;
    }

    public int getCantidad() {
        return cantidad;
    }
    public String getMarca()
    {
        return marca;
    }
    public void setMarca(String marca)
    {
        this.marca = marca;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setValor(int Valor) {
        this.Valor = Valor;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
