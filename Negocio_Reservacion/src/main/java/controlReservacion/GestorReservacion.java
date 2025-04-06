/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlReservacion;

import dtos.ClienteDTO;
import dtos.MesaDTO;
import dtos.ReservacionDTO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import objetosnegocio.ClienteON;
import objetosnegocio.MesaON;
import objetosnegocio.ReservacionON;

/**
 *
 * @author Gael
 */
public class GestorReservacion {
    
    private List<MesaDTO> mesas;
    private MesaON mesaON = MesaON.getInstance();
    private ClienteON clienteON = ClienteON.getInstance();
    private ReservacionON reservacionON = ReservacionON.getInstance();
    
     public GestorReservacion() {
        mesas = new ArrayList<>();
        
        mesas.add(new MesaDTO(1, 4, true));  
        mesas.add(new MesaDTO(2, 4, true));  
        mesas.add(new MesaDTO(3, 4, false)); 
        mesas.add(new MesaDTO(4, 4, true)); 
        mesas.add(new MesaDTO(5, 4, true)); 
        mesas.add(new MesaDTO(6, 4, false)); 
        mesas.add(new MesaDTO(7, 4, true)); 
     }
     public List<MesaDTO> obtenerMesas() {
        return mesas;
    }
     public String reservarMesa(MesaDTO mesa) {
        if (mesa.isDisponible()) {
            mesa.setDisponible(false);  
            return "La reserva ha sido exitosa.";
        } else {
            return "La mesa ya está ocupada.";
        }
    }

     
     
     
     
    public String registrarReservacion(MesaDTO mesa, ClienteDTO cliente, LocalDate fechaHora) {
      
        if (!mesaON.obtenerMesa(mesa.getNumeroMesa()).equals(null) && mesaON.obtenerMesa(mesa.getNumeroMesa()) != null) {
            // Verificar si ya hay una reservación para esa mesa y fecha
            if (reservacionON.MesaDisponibleDiaHora(mesa, fechaHora)) {
                
                ReservacionDTO reservacion = new ReservacionDTO(mesa, cliente, fechaHora);
                if (reservacionON.registrarReservacion(reservacion)) {
                    return "Reservación exitosa para la mesa " + mesa.getNumeroMesa() + " con " + cliente.getNombre();
                } else {
                    return "Error al registrar la reservación.";
                }
            } else {
                return "La mesa no está disponible en la fecha y hora seleccionadas.";
            }
        } else {
            return "La mesa no existe.";
        }
    }
    
    
    public String registrarCliente(String nombre, String correo, String telefono) {
        ClienteDTO nuevoCliente = new ClienteDTO(nombre, correo, telefono);
        if (clienteON.insertarCliente(nuevoCliente)) {
            return "Cliente registrado con éxito.";
        } else {
            return "El cliente ya existe.";
        }
    }
    
  
    public String agregarMesa(int numeroMesa, int capacidadMesa) {
        MesaDTO nuevaMesa = new MesaDTO(numeroMesa, capacidadMesa, true);
        if (mesaON.insertarMesa(nuevaMesa)) {
            return "Mesa agregada con éxito.";
        } else {
            return "La mesa ya existe.";
        }
    }
}

