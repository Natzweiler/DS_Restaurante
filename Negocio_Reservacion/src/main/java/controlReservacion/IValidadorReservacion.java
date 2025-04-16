/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlReservacion;

import dtos.MesaDTO;
import dtos.MeseroDTO;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Gael
 */
public interface IValidadorReservacion {
    
    public String registrarReservacion(MesaDTO mesa, String nombre, String telefono, String correo, LocalDate fecha, MeseroDTO mesero, LocalTime hora);
}
