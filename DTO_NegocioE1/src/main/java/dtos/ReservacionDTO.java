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
import java.time.LocalDate;
import java.time.LocalTime;

public class ReservacionDTO {

    private MesaDTO mesa;

    private ClienteDTO cliente;

    private String correo;

    private LocalDate fecha;

    private MeseroDTO mesero;

    private LocalTime hora;

    private int id;

    public ReservacionDTO() {
    }

    // Constructor con todos los atributos
    public ReservacionDTO(int id, MesaDTO mesa, ClienteDTO cliente, String correo, LocalDate fecha, MeseroDTO mesero, LocalTime hora) {
        this.mesa = mesa;
        this.cliente = cliente;
        this.correo = correo;
        this.fecha = fecha;
        this.mesero = mesero;
        this.hora = hora;
        this.id = id;
    }

    public MesaDTO getMesa() {
        return mesa;
    }

    public void setMesa(MesaDTO mesa) {
        this.mesa = mesa;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("#%d — Mesa %s — %s %s",
            id,
            mesa.getNumeroMesa(),
            fecha.toString(),
            hora.toString()
        );
    }
}
