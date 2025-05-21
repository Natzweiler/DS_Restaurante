/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

/**
 * La clase **ClienteDTO** (Data Transfer Object) se utiliza para transferir
 * datos de un cliente entre las capas de la aplicación.
 * Contiene información básica de un cliente como su nombre, correo electrónico
 * y número de teléfono.
 *
 * @author Gael
 * @version 1.0
 */
public class ClienteDTO {
    
    /**
     * El nombre completo del cliente.
     */
    private String nombre;
    
    /**
     * La dirección de correo electrónico del cliente.
     */
    private String correo;
    
    /**
     * El número de teléfono del cliente.
     */
    private String telefono;

    /**
     * Constructor por defecto de la clase ClienteDTO.
     * Inicializa un nuevo objeto ClienteDTO sin valores predefinidos.
     */
    public ClienteDTO() {
    }

    /**
     * Constructor de la clase ClienteDTO que permite inicializar todas las propiedades.
     *
     * @param nombre El nombre del cliente.
     * @param correo El correo electrónico del cliente.
     * @param telefono El número de teléfono del cliente.
     */
    public ClienteDTO(String nombre, String correo, String telefono) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }

    /**
     * Obtiene el nombre del cliente.
     *
     * @return Una cadena de texto que representa el nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del cliente.
     *
     * @param nombre El nuevo nombre del cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la dirección de correo electrónico del cliente.
     *
     * @return Una cadena de texto que representa el correo electrónico del cliente.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece la dirección de correo electrónico del cliente.
     *
     * @param correo La nueva dirección de correo electrónico del cliente.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene el número de teléfono del cliente.
     *
     * @return Una cadena de texto que representa el número de teléfono del cliente.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono del cliente.
     *
     * @param telefono El nuevo número de teléfono del cliente.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Retorna una representación en cadena de texto del objeto ClienteDTO.
     * Esta representación incluye el nombre, correo electrónico y teléfono del cliente.
     *
     * @return Una cadena formateada con los datos del cliente.
     */
    @Override
    public String toString() {
        return "ClienteDTO{" + "nombre=" + nombre + ", correo=" + correo + ", telefono=" + telefono + '}';
    }
}