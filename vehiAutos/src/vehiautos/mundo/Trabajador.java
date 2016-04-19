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
public class Trabajador
{
 //------constantes--------//
    public String nombre;
    
    public int cedula;
    
    public Trabajador()
    {
    }
    
        public Trabajador(String nombre, int cedula)
        {
            this.nombre = nombre;
            this.cedula = cedula;
        }
    //------metodos-------//
        public String getnombre()
        {
            return nombre;
        }
        public int getcedula()
        {
            return cedula;
        }
        public void setnombre(String nombre)
        {
            this.nombre = nombre;
        }
        public void setcedula(int cedula)
        {
            this.cedula = cedula;
        }
       
}
