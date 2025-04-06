/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosnegocio;

import dtos.MesaDTO;
import dtos.ReservacionDTO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Gael
 */
public class ReservacionON {
    
    private static ReservacionON instancia;
    
    private List<ReservacionDTO> reservaciones;
    
    private Map<Integer, Boolean> mesasDisponibles;

    private ReservacionON() {
        reservaciones = new ArrayList<>();
        mesasDisponibles = new HashMap<>();
    }

    public static  synchronized ReservacionON getInstance(){
        if (instancia == null) {
            instancia = new ReservacionON();
        }
    return instancia;
    }
    
    public boolean registrarReservacion (ReservacionDTO reservacion){
        int mesaId = reservacion.getMesa().getNumeroMesa();
    
        if (mesasDisponibles.containsKey(reservacion.getMesa()) && mesasDisponibles.get(reservacion.getMesa())) {
            
            reservaciones.add(reservacion);
            
            mesasDisponibles.put(mesaId, Boolean.FALSE);
            
            System.out.println("Reservacion para: " + reservacion.getCliente().getNombre());
            System.out.println("Correo: " + reservacion.getCliente().getCorreo());
            System.out.println("Telefono: " + reservacion.getCliente().getTelefono());
            return true;
        }
        return false;
    }
    
    public List<Integer> obtenerMesasDisponibles() {
        
    List<Integer> mesasLibres = new ArrayList<>();
    
    for (Map.Entry<Integer, Boolean> entry : mesasDisponibles.entrySet()) {
        
        if (entry.getValue()) {
            
            mesasLibres.add(entry.getKey());
        }
    }
    return mesasLibres;
}
     public boolean MesaDisponibleDiaHora(MesaDTO mesa, LocalDate fechaHora) {
       
        for (ReservacionDTO r : reservaciones) {
            
            if (r.getMesa().getNumeroMesa() == mesa.getNumeroMesa() && r.getFechaHora().equals(fechaHora)) {
             
                return false;
            }
        }
        return true;
    }
}
