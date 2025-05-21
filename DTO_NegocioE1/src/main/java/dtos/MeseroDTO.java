/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.time.LocalDate;
import javax.persistence.Column;

import java.time.LocalDate; 

/**
 * La clase **MeseroDTO** (Data Transfer Object) se utiliza para encapsular
 * y transferir la información de un mesero entre las diferentes capas de la aplicación.
 * Contiene los atributos relevantes de un mesero, como su identificación,
 * nombre, teléfono, dirección, fecha de nacimiento y estado de actividad.
 *
 * @author Gael
 * @version 1.0
 */
public class MeseroDTO {
    
    /**
     * El identificador único del mesero. 
     */
    private Integer id;
    
    /**
     * El nombre completo del mesero.
     */
    private String nombre;
    
    /**
     * El número de teléfono de contacto del mesero.
     */
    private String telefono;

    /**
     * La fecha de nacimiento del mesero. Se utiliza para cálculos de edad o validaciones.
     */
    private LocalDate fechaNacimiento;
    
    /**
     * La dirección de residencia del mesero.
     */
    private String direccion;
    
    /**
     * El estado de actividad del mesero (true si está activo/habilitado, false si está inactivo/deshabilitado).
     */
    private boolean estado;

    /**
     * Constructor por defecto de la clase MeseroDTO.
     * Inicializa un nuevo objeto MeseroDTO sin valores predefinidos.
     */
    public MeseroDTO() {
    }

    /**
     * Constructor de la clase MeseroDTO que solo inicializa el nombre.
     * Útil para casos donde solo se requiere el nombre del mesero inicialmente.
     *
     * @param nombre El nombre del mesero.
     */
    public MeseroDTO(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el identificador único del mesero.
     *
     * @return El ID del mesero, o {@code null} si no ha sido asignado.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Establece el identificador único del mesero.
     *
     * @param id El nuevo ID del mesero.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre completo del mesero.
     *
     * @return Una cadena de texto que representa el nombre del mesero.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre completo del mesero.
     *
     * @param nombre El nuevo nombre del mesero.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el número de teléfono de contacto del mesero.
     *
     * @return Una cadena de texto que representa el número de teléfono del mesero.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono de contacto del mesero.
     *
     * @param telefono El nuevo número de teléfono del mesero.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene la dirección de residencia del mesero.
     *
     * @return Una cadena de texto que representa la dirección del mesero.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección de residencia del mesero.
     *
     * @param direccion La nueva dirección del mesero.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene la fecha de nacimiento del mesero.
     *
     * @return Un objeto {@link LocalDate} que representa la fecha de nacimiento del mesero.
     */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del mesero.
     *
     * @param fechaNacimiento La nueva fecha de nacimiento del mesero.
     */
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Verifica el estado de actividad del mesero.
     *
     * @return {@code true} si el mesero está activo/habilitado, {@code false} si está inactivo/deshabilitado.
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * Establece el estado de actividad del mesero.
     *
     * @param estado El nuevo estado de actividad (true para activo, false para inactivo).
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * Retorna una representación del nombre del mesero junto con su estado de actividad
     * (Activo o Inactivo), útil para la presentación en interfaces de usuario.
     *
     * @return Una cadena de texto que incluye el nombre del mesero y su estado.
     */
    public String getNombreConEstado() {
        return nombre + " - " + (estado ? "Activo" : "Inactivo");
    }

    /**
     * Retorna una representación en cadena de texto del objeto MeseroDTO,
     * mostrando únicamente el nombre del mesero.
     *
     * @return Una cadena de texto que representa el nombre del mesero.
     */
    @Override
    public String toString() {
        return nombre;
    }
}

 
    
    

