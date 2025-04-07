/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.time.LocalDate;

/**
 *
 * @author Gael
 */
public class ReservacionDTO {
    
    private MesaDTO mesa;
    
    private String nombre;
    
    private String telefono;
    
    private String correo;
    
    private LocalDate fechaHora;
    
    private MeseroDTO mesero;
    
    

    public ReservacionDTO() {
    }

    public ReservacionDTO(MesaDTO mesa, String nombre, String telefono, String correo, LocalDate fechaHora, MeseroDTO mesero) {
        this.mesa = mesa;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.fechaHora = fechaHora;
        this.mesero = mesero;
    }


    public MesaDTO getMesa() {
        return mesa;
    }

    public void setMesa(MesaDTO mesa) {
        this.mesa = mesa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public MeseroDTO getMesero() {
        return mesero;
    }

    public void setMesero(MeseroDTO mesero) {
        this.mesero = mesero;
    }

    

    public LocalDate getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDate fechaHora) {
        this.fechaHora = fechaHora;
    }

    @Override
    public String toString() {
        return "ReservacionDTO{" + "mesa=" + mesa + ", nombre=" + nombre + ", telefono=" + telefono + ", correo=" + correo + ", fechaHora=" + fechaHora + ", mesero=" + mesero + '}';
    }

   
    
    
}
