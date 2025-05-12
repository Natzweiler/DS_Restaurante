/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebasNegocio;

import BO.MesaBO;
import BO.MeseroBO;
import BO.ReservacionBO;
import Entidades.Mesa;
import Entidades.Mesero;
import Interfaces.IMesaBO;
import Interfaces.IMeseroBO;
import Interfaces.IReservacionBO;
import Mappers.MeseroMapper;
import Persistencia.MesaDAO;
import Persistencia.MeseroDAO;
import Persistencia.ReservacionDAO;
import conexion.Conexion;
import dtos.ClienteDTO;
import dtos.MesaDTO;
import dtos.MeseroDTO;
import dtos.ReservacionDTO;
import interfaces.IMesaDAO;
import interfaces.IMeseroDAO;
import interfaces.IReservacionDAO;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.EntityManager;
import negocio.exception.NegocioException;

/**
 *
 * @author Gael
 */
public class pruebasNegocio {

    public static void main(String[] args) {
        try {
            // Crear DAOs manualmente
            IMesaDAO mesaDAO = MesaDAO.getInstanceDAO();
            IMeseroDAO meseroDAO = MeseroDAO.getInstanceDAO();
            IReservacionDAO reservacionDAO = ReservacionDAO.getInstanceDAO();

            // Crear BOs manualmente con los DAOs
            IMesaBO mesaBO = new MesaBO();
            IMeseroBO meseroBO = new MeseroBO(meseroDAO);
            IReservacionBO reservacionBO = new ReservacionBO(reservacionDAO);

            // Obtener mesa
            MesaDTO mesaDTO = mesaBO.obtenerMesaPorNumeroMesa(3);

            // Crear cliente
            ClienteDTO clienteDTO = new ClienteDTO();
            clienteDTO.setNombre("Ricardo Arjona");
            clienteDTO.setTelefono("123456789");
            clienteDTO.setCorreo("ricardo@gmail.com");

            // Obtener mesero
            Mesero mesero = meseroBO.obtenerMeseroPorId(1);
            MeseroDTO meseroDTO = MeseroMapper.toDTO(mesero);

            // Crear reservación
            ReservacionDTO reservacionDTO = new ReservacionDTO();
            reservacionDTO.setMesa(mesaDTO);
            reservacionDTO.setCliente(clienteDTO);
            reservacionDTO.setFecha(LocalDate.of(2025, 5, 12));
            reservacionDTO.setHora(LocalTime.of(19, 30));
            reservacionDTO.setMesero(meseroDTO);

            // Registrar reservación
            ReservacionDTO nuevaReservacionDTO = reservacionBO.registrarReservacion(reservacionDTO);

            // Mostrar resultado
            System.out.println("Reservación registrada con éxito:");
            System.out.println(nuevaReservacionDTO);

        } catch (NegocioException e) {
            System.out.println("Error en el negocio: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
}

