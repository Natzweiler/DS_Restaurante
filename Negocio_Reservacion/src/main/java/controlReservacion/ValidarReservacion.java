/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlReservacion;

import dtos.MesaDTO;
import dtos.MeseroDTO;
import java.time.LocalDate;

/**
 *
 * @author Gael
 */
public class ValidarReservacion implements IValidadorReservacion {

    @Override
    public String registrarReservacion(MesaDTO mesa, String nombre, String telefono, String correo, LocalDate fecha, MeseroDTO mesero) {
        
        if (mesa.isDisponible() == false) {
            System.out.println("Error: La mesa no esta disponible.");
            
        }
        if (mesero == null) {
            System.out.println("Necesita escoger un mesero.");
            
        }
        mesa.setDisponible(false);
        return "Reservacion exitosa para " + nombre + "en la mesa" + mesa.getNumeroMesa() + "con el mesero" + mesero.getNombre();
        
    }
    
}
