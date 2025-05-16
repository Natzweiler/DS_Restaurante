/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
/**
 *
 * @author Gael
 */




@Entity
@Table(name = "mesero")
public class Mesero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    
    @Column (name = "telefono", nullable = false, length = 15)
    private String telefono;
    
    @Column (name = "fechaNacimiento", nullable = false)
    private LocalDate fechaNacimiento;
    
    @Column (name = "estado", nullable = false)
    private boolean estado;
    //faltan agregar mas atribtos, telefono y fecha y tambien un campo para indicar si el mesero esta activo

    public Mesero() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    

    @Override
    public String toString() {
        return "Mesero{" + "id=" + id + ", nombre=" + nombre + ", telefono=" + telefono + ", fechaNacimiento=" + fechaNacimiento + '}';
    }
    

}
