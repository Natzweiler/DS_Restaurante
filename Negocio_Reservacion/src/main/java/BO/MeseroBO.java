/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import Entidades.Mesero;
import Interfaces.IMeseroBO;
import Mappers.MeseroMapper;
import Persistencia.MeseroDAO;
import dtos.MeseroDTO;
import exception.PersistenciaException;
import interfaces.IMeseroDAO;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import negocio.exception.NegocioException;

/**
 *
 * @author Gael
 */
public class MeseroBO implements IMeseroBO {

    private IMeseroDAO meseroDAO;

    public MeseroBO(IMeseroDAO meseroDAO) {
        this.meseroDAO = MeseroDAO.getInstanceDAO();
    }

    public Mesero obtenerMeseroPorId(Integer id) throws NegocioException {
        try {
            return meseroDAO.obtenerMeseroPorId(id);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener el mesero con ID: " + id, e);
        }
    }
    public MeseroDTO registrarMesero(MeseroDTO dto) throws NegocioException {
        try {
            if (dto.getNombre() == null || dto.getNombre().trim().isEmpty()) {
                throw new NegocioException("El nombre del mesero no puede estar vacío.");
            }
            if (dto.getTelefono() == null || dto.getTelefono().trim().isEmpty()) {
                throw new NegocioException("El teléfono no puede estar vacío.");
            }
            if (dto.getFechaNacimiento() == null) {
                throw new NegocioException("La fecha de nacimiento es obligatoria.");
            }
            if (dto.getFechaNacimiento().isAfter(LocalDate.now())) {
                throw new NegocioException("La fecha de nacimiento no puede ser futura.");
            }
            if (dto.getFechaNacimiento().isBefore(LocalDate.of(1900, 1, 1))) {
                throw new NegocioException("La fecha de nacimiento es demasiado antigua.");
            }

            Mesero mesero = MeseroMapper.toEntity(dto);
            mesero.setEstado(true); 
            Mesero registrado = meseroDAO.registrarMesero(mesero);

            return MeseroMapper.toDTO(registrado);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al registrar el mesero", e);
        }
    }

    
    public MeseroDTO actualizarMesero(MeseroDTO dto) throws NegocioException {
        try {
            if (dto.getNombre() == null || dto.getNombre().trim().isEmpty()) {
                throw new NegocioException("El nombre del mesero no puede estar vacío.");
            }
            if (dto.getTelefono() == null || dto.getTelefono().trim().isEmpty()) {
                throw new NegocioException("El teléfono no puede estar vacío.");
            }
            if (dto.getFechaNacimiento() == null) {
                throw new NegocioException("La fecha de nacimiento es obligatoria.");
            }
            if (dto.getFechaNacimiento().isAfter(LocalDate.now())) {
                throw new NegocioException("La fecha de nacimiento no puede ser futura.");
            }
            if (dto.getFechaNacimiento().isBefore(LocalDate.of(1900, 1, 1))) {
                throw new NegocioException("La fecha de nacimiento es demasiado antigua.");
            }

            Mesero mesero = MeseroMapper.toEntity(dto);
            Mesero actualizado = meseroDAO.actualizarMesero(mesero);
            return MeseroMapper.toDTO(actualizado);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al actualizar el mesero", e);
        }
    }

    
    public boolean deshabilitarMesero(Integer id) throws NegocioException {
        try {
            return meseroDAO.deshabilitarMesero(id);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al deshabilitar el mesero", e);
        }
    }

    
    public boolean activarMesero(Integer id) throws NegocioException {
        try {
            return meseroDAO.activarMesero(id);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al activar el mesero", e);
        }
    }
   
    public List<MeseroDTO> obtenerTodos() throws NegocioException {
        try {
            List<Mesero> meseros = meseroDAO.obtenerTodos();
            return meseros.stream()
                    .map(MeseroMapper::toDTO)
                    .collect(Collectors.toList());
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener la lista de meseros", e);
        }
    }
    public List<MeseroDTO> obtenerMeserosActivos() throws NegocioException {
        try {
            List<Mesero> lista = meseroDAO.obtenerMeserosActivos();
            return lista.stream()
                    .map(MeseroMapper::toDTO)
                    .collect(Collectors.toList());
    } catch (PersistenciaException e) {
        throw new NegocioException("Error al obtener meseros activos", e);
    }
}

}


