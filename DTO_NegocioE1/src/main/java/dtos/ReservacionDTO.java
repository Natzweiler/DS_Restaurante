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
    
    private ClienteDTO cliente;
    
    private LocalDate fechaHora;

    public ReservacionDTO() {
    }

    public ReservacionDTO(MesaDTO mesa, ClienteDTO cliente, LocalDate fechaHora) {
        this.mesa = mesa;
        this.cliente = cliente;
        this.fechaHora = fechaHora;
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

    public LocalDate getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDate fechaHora) {
        this.fechaHora = fechaHora;
    }

    @Override
    public String toString() {
        return "ReservacionDTO{" + "mesa=" + mesa + ", cliente=" + cliente + ", fechaHora=" + fechaHora + '}';
    }
    
    
}
