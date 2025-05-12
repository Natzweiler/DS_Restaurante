/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlReservacion;

import dtos.ClienteDTO;
import dtos.MesaDTO;
import dtos.MeseroDTO;
import dtos.ReservacionDTO;
import java.time.LocalDate;
import java.time.LocalTime;
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
    
    private ValidarReservacion validadorReservacion;
    private static GestorReservacion instancia;
    
        public static synchronized GestorReservacion getInstance() {
        if (instancia == null) {
            instancia = new GestorReservacion();
        }
        return instancia;
    }

        
    private List<MesaDTO> mesas;
    private MesaON mesaON = MesaON.getInstance();
    private ClienteON clienteON = ClienteON.getInstance();
    private ReservacionON reservacionON = ReservacionON.getInstance();
    
     public GestorReservacion() {
        this.validadorReservacion = new ValidarReservacion();

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

   /* public String registrarReservacion(MesaDTO mesa, String nombre, String telefono, String correo, LocalDate fecha, MeseroDTO mesero, LocalTime hora) {
                MesaDTO mesaEnSistema = mesaON.obtenerMesa(mesa.getNumeroMesa());

        if (mesaEnSistema != null) {
            if (reservacionON.MesaDisponibleDiaHora(mesa, fecha, hora)) {
                ReservacionDTO reservacion = new ReservacionDTO(mesa, nombre, telefono, correo, fecha, mesero, hora);

                if (reservacionON.registrarReservacion(reservacion)) {
                    
                    mesaEnSistema.setDisponible(false);
                    return "Reservación exitosa para la mesa: " + mesa.getNumeroMesa() + " Nombre Cliente: " + reservacion.getNombre() + "Correo: " + reservacion.getCorreo();
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
    */
    
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

