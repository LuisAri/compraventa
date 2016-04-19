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
public class Persona 
{
    //------------CONSTANTE-------------//
    public String nombre;

    public int edad;

    public int cedula;

    public String fechaNacimiento;

    public String Direccion;

    public int Telefono;

    //----------CONSTRUCTOR---------------------//
    /**
     *
     */
    public Persona() {

    }

    public Persona(String nombre, int edad, int cedula, String fechaNacimiento, String direccion, int telefono) {
        this.nombre = nombre;
        this.edad = edad;
        this.cedula = cedula;
        this.fechaNacimiento = fechaNacimiento;
        Direccion = direccion;
        Telefono = telefono;
    }

    //----------METODOS--------------------//
    /**
     * agrega un nombre para el registro
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * agrega una edad para el registro
     */
    public int getEdad() {
        return edad;
    }

    /**
     * agrea una cedula para el registro
     */
    public int getId() {
        return cedula;
    }

    /**
     * agrega una fecha para el registro
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * agregar nunero de telefono
     *
     * @return
     */
    public int getTelefono() {
        return Telefono;
    }

    public String getDireccion() {
        return this.Direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

}
    

