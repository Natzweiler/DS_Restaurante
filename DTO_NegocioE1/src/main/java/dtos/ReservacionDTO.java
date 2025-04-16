/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Gael
 */
public class ReservacionDTO {
    
    private MesaDTO mesa;
    
    private String nombre;
    
    private String telefono;
    
    private String correo;
    
    private LocalDate fecha;
    
    private MeseroDTO mesero;
    
    private LocalTime hora;
    

    public ReservacionDTO() {
    }

    public ReservacionDTO(MesaDTO mesa, String nombre, String telefono, String correo, LocalDate fecha, MeseroDTO mesero, LocalTime hora) {
        this.mesa = mesa;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.fecha = fecha;
        this.mesero = mesero;
        this.hora = hora;
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public MeseroDTO getMesero() {
        return mesero;
    }

    public void setMesero(MeseroDTO mesero) {
        this.mesero = mesero;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "ReservacionDTO{" + "mesa=" + mesa + ", nombre=" + nombre + ", telefono=" + telefono + ", correo=" + correo + ", fecha=" + fecha + ", mesero=" + mesero + ", hora=" + hora + '}';
    }
    
    
}
