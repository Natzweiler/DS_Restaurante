/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import Entidades.Cliente;
import Entidades.Mesa;
import Entidades.Mesero;
import Entidades.Reservacion;
import Interfaces.IReservacionBO;
import Mappers.ReservacionMapper;
import Persistencia.MesaDAO;
import Persistencia.MeseroDAO;
import Persistencia.ReservacionDAO;
import dtos.ReservacionDTO;
import exception.PersistenciaException;
import interfaces.IMeseroDAO;
import interfaces.IReservacionDAO;
import java.util.List;
import java.util.stream.Collectors;
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
        if (dto.getCliente().getCorreo() == null || dto.getCliente().getCorreo().isEmpty()) {
            throw new NegocioException("El correo del cliente no puede estar vacío.");
        }
        if (dto.getCliente().getTelefono() == null || dto.getCliente().getTelefono().isEmpty()) {
            throw new NegocioException("El teléfono del cliente no puede estar vacío.");
        }

        if (!dto.getMesa().isDisponible()) {
            throw new NegocioException("La mesa ya está ocupada");
        }

        // conversion a entidad
        Reservacion reservacion = ReservacionMapper.toEntity(dto);

        // recuperar entidades gestionadas desde la BD
        Mesero meseroRecuperado = meseroDAO.obtenerMeseroPorId(dto.getMesero().getId());
        Mesa mesaRecuperada = MesaDAO.getInstanceDAO().obtenerMesaPorNumeroMesa(dto.getMesa().getNumeroMesa());

        // asignarlas
        reservacion.setMesero(meseroRecuperado);
        reservacion.setMesa(mesaRecuperada);

        // persistir la reservación
        Reservacion nuevaReservacion = reservacionDAO.registrarReservacion(reservacion);

        return ReservacionMapper.toDTO(nuevaReservacion);

    } catch (NegocioException ne) {
        throw ne;
    } catch (Exception e) {
        throw new NegocioException("Ocurrió un error al registrar la reservación: " + e.getMessage(), e);
    }
}
    @Override
    public boolean cancelarReservacion(int id) throws NegocioException {
        try {
            return reservacionDAO.cancelarReservacion(id);
        } catch (PersistenciaException pe) {
            throw new NegocioException("No se pudo cancelar la reservación: " + pe.getMessage(), pe);
        }
    }
    @Override
    public List<ReservacionDTO> listarReservaciones() throws NegocioException {
        try {
            return reservacionDAO.listarReservaciones()
                                  .stream()
                                  .map(ReservacionMapper::toDTO)
                                  .collect(Collectors.toList());
        } catch (PersistenciaException pe) {
            throw new NegocioException("Error al listar reservaciones: " + pe.getMessage(), pe);
        }
    }
}
