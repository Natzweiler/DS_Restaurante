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
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * La clase **MeseroBO** (Business Object) implementa la interfaz {@link IMeseroBO}
 * y gestiona la lógica de negocio relacionada con los meseros.
 * Es responsable de validar los datos de los meseros, coordinar con la capa de persistencia
 * para realizar operaciones CRUD, y transformar las entidades a DTOs para la capa de presentación.
 *
 * @author Gael
 * @version 1.0
 */
public class MeseroBO implements IMeseroBO {

    /**
     * Instancia del DAO de meseros para interactuar con la capa de persistencia.
     */
    private IMeseroDAO meseroDAO;

    /**
     * Constructor de la clase MeseroBO.
     * Inicializa la instancia de {@link IMeseroDAO} a través de su implementación Singleton.
     *
     * @param meseroDAO La instancia del DAO de meseros a utilizar (normalmente, se inyectaría {@link MeseroDAO#getInstanceDAO()}).
     */
    public MeseroBO(IMeseroDAO meseroDAO) {
        // Aunque el constructor recibe IMeseroDAO, se fuerza la instancia Singleton del DAO concreto.
        // Esto podría ser un punto de mejora para permitir la inyección de dependencias si se busca mayor flexibilidad.
        this.meseroDAO = MeseroDAO.getInstanceDAO(); 
    }

    /**
     * Obtiene un objeto {@link Mesero} de la base de datos por su identificador único.
     *
     * @param id El ID del mesero a buscar.
     * @return El objeto {@link Mesero} encontrado.
     * @throws NegocioException Si ocurre un error al obtener el mesero, encapsulando la excepción de persistencia.
     */
    @Override
    public Mesero obtenerMeseroPorId(Integer id) throws NegocioException {
        try {
            return meseroDAO.obtenerMeseroPorId(id);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener el mesero con ID " + id + ": " + e.getMessage(), e);
        }
    }
    
    /**
     * Registra un nuevo mesero en el sistema.
     * Realiza validaciones de los datos del {@link MeseroDTO} antes de la persistencia,
     * como la validación de campos obligatorios y la fecha de nacimiento.
     * El estado inicial del mesero se establece como activo.
     *
     * @param dto El {@link MeseroDTO} que contiene los datos del mesero a registrar.
     * @return El {@link MeseroDTO} del mesero registrado, incluyendo su ID si fue generado.
     * @throws NegocioException Si los datos del DTO son inválidos o si ocurre un error en la persistencia.
     */
    @Override
    public MeseroDTO registrarMesero(MeseroDTO dto) throws NegocioException {
        try {
            // Validaciones de negocio
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

            // Conversión de DTO a entidad y persistencia
            Mesero mesero = MeseroMapper.toEntity(dto);
            mesero.setEstado(true); // Se establece el estado como activo por defecto
            Mesero registrado = meseroDAO.registrarMesero(mesero);

            return MeseroMapper.toDTO(registrado); // Retorna el DTO de la entidad registrada
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al registrar el mesero: " + e.getMessage(), e);
        }
    }

    /**
     * Actualiza la información de un mesero existente en el sistema.
     * Realiza validaciones similares a las del registro antes de proceder con la actualización.
     *
     * @param dto El {@link MeseroDTO} que contiene los datos actualizados del mesero.
     * @return El {@link MeseroDTO} del mesero actualizado.
     * @throws NegocioException Si los datos del DTO son inválidos o si ocurre un error en la persistencia.
     */
    @Override
    public MeseroDTO actualizarMesero(MeseroDTO dto) throws NegocioException {
        try {
            // Validaciones de negocio
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

            // Conversión y actualización
            Mesero mesero = MeseroMapper.toEntity(dto);
            Mesero actualizado = meseroDAO.actualizarMesero(mesero);
            return MeseroMapper.toDTO(actualizado);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al actualizar el mesero: " + e.getMessage(), e);
        }
    }

    /**
     * Deshabilita lógicamente un mesero en la base de datos por su ID.
     *
     * @param id El ID del mesero a deshabilitar.
     * @return {@code true} si el mesero fue deshabilitado exitosamente.
     * @throws NegocioException Si ocurre un error en la persistencia al deshabilitar el mesero.
     */
    @Override
    public boolean deshabilitarMesero(Integer id) throws NegocioException {
        try {
            return meseroDAO.deshabilitarMesero(id);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al deshabilitar el mesero: " + e.getMessage(), e);
        }
    }

    /**
     * Activa (habilita) lógicamente un mesero en la base de datos por su ID.
     *
     * @param id El ID del mesero a activar.
     * @return {@code true} si el mesero fue activado exitosamente.
     * @throws NegocioException Si ocurre un error en la persistencia al activar el mesero.
     */
    @Override
    public boolean activarMesero(Integer id) throws NegocioException {
        try {
            return meseroDAO.activarMesero(id);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al activar el mesero: " + e.getMessage(), e);
        }
    }

    /**
     * Obtiene una lista de todos los {@link MeseroDTO}s registrados en el sistema,
     * sin importar su estado (activo o inactivo).
     *
     * @return Una {@link List} de objetos {@link MeseroDTO}.
     * @throws NegocioException Si ocurre un error al obtener la lista de meseros.
     */
    @Override
    public List<MeseroDTO> obtenerTodos() throws NegocioException {
        try {
            List<Mesero> meseros = meseroDAO.obtenerTodos();
            // Utiliza Stream API para convertir la lista de entidades a DTOs
            return meseros.stream()
                .map(MeseroMapper::toDTO)
                .collect(Collectors.toList());
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener la lista de meseros: " + e.getMessage(), e);
        }
    }

    /**
     * Obtiene una lista de los {@link MeseroDTO}s que están actualmente activos en el sistema.
     *
     * @return Una {@link List} de objetos {@link MeseroDTO} que representan a los meseros activos.
     * @throws NegocioException Si ocurre un error al obtener la lista de meseros activos.
     */
    @Override
    public List<MeseroDTO> obtenerMeserosActivos() throws NegocioException {
        try {
            List<Mesero> lista = meseroDAO.obtenerMeserosActivos();
            // Utiliza Stream API para convertir la lista de entidades a DTOs
            return lista.stream()
                .map(MeseroMapper::toDTO)
                .collect(Collectors.toList());
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener meseros activos: " + e.getMessage(), e);
        }
    }
}


