/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import Entidades.Cliente;
import Entidades.Mesero;
import Entidades.Reservacion;
import Interfaces.IReservacionBO;
import Mappers.ReservacionMapper;
import Persistencia.MeseroDAO;
import Persistencia.ReservacionDAO;
import dtos.ReservacionDTO;
import interfaces.IMeseroDAO;
import interfaces.IReservacionDAO;
import negocio.exception.NegocioException;

/**
 *
 * @author Gael
 */
public class ReservacionBO implements IReservacionBO {

    private IReservacionDAO reservacionDAO; 
    private IMeseroDAO meseroDAO;
 
    public ReservacionBO(IReservacionDAO reservacionDAO) {
       this.reservacionDAO = ReservacionDAO.getInstanceDAO();
       this.meseroDAO = MeseroDAO.getInstanceDAO();
    }

    public ReservacionDTO registrarReservacion(ReservacionDTO dto) throws NegocioException {
        try {
          
            if (dto.getCliente().getNombre() == null || dto.getCliente().getNombre().isEmpty()) {
                throw new NegocioException("El nombre del cliente no puede estar vacío.");
            }
            if (dto.getCliente().getCorreo()== null || dto.getCliente().getCorreo().isEmpty()) {
                throw new NegocioException("El correo del cliente no puede estar vacío.");
            }
            if (dto.getCliente().getTelefono()== null || dto.getCliente().getTelefono().isEmpty()) {
                throw new NegocioException("El teléfono del cliente no puede estar vacío.");
            }
            
            if (dto.getMesa().isDisponible() == false) {
                throw new NegocioException("La mesa ya esta ocuopada");
            }
            //conversion a entidad
            
            Reservacion reservacion = ReservacionMapper.toEntity(dto);
            Mesero meseroRecuperado = meseroDAO.obtenerMeseroPorId(dto.getMesero().getId());
            reservacion.setMesero(meseroRecuperado);
            // persistir ahora si la reservacion ya que fue mapeada
            Reservacion nuevaReservacion = reservacionDAO.registrarReservacion(reservacion);

           
            return ReservacionMapper.toDTO(nuevaReservacion);

        } catch (NegocioException ne) {
            
            throw ne;
        } catch (Exception e) {
          
            throw new NegocioException("Ocurrió un error al registrar la reservación: " + e.getMessage(), e);
        }
    }

}
