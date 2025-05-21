/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entidades.Mesero;
import dtos.MeseroDTO;
import java.util.List;
import negocio.exception.NegocioException;
import java.util.List;

/**
 * La interfaz **IMeseroBO** define el contrato para la lógica de negocio
 * relacionada con la gestión de meseros.
 *
 * Especifica las operaciones que deben ser soportadas para manejar
 * la información de los meseros, incluyendo el registro, actualización,
 * y la gestión de su estado de actividad.
 *
 * @author Gael
 * @version 1.0
 */
public interface IMeseroBO {

    /**
     * Obtiene un objeto {@link Mesero} por su identificador único.
     * Nota: Este método podría retornar un {@link MeseroDTO} para mantener la coherencia con DTOs.
     *
     * @param id El ID del mesero a buscar.
     * @return El objeto {@link Mesero} que coincide con el ID proporcionado.
     * @throws NegocioException Si no se encuentra el mesero o si ocurre un error en la lógica de negocio.
     */
    public Mesero obtenerMeseroPorId(Integer id) throws NegocioException;

    /**
     * Registra un nuevo mesero en el sistema.
     *
     * @param dto El objeto {@link MeseroDTO} que contiene los datos del mesero a registrar.
     * @return El {@link MeseroDTO} del mesero registrado, con cualquier ID generado.
     * @throws NegocioException Si los datos del mesero son inválidos o si ocurre un error durante el registro.
     */
    public MeseroDTO registrarMesero(MeseroDTO dto) throws NegocioException;

    /**
     * Actualiza la información de un mesero existente en el sistema.
     *
     * @param dto El objeto {@link MeseroDTO} con los datos actualizados del mesero.
     * @return El {@link MeseroDTO} del mesero actualizado.
     * @throws NegocioException Si los datos del mesero son inválidos o si ocurre un error durante la actualización.
     */
    public MeseroDTO actualizarMesero(MeseroDTO dto) throws NegocioException;

    /**
     * Deshabilita (marca como inactivo) un mesero por su identificador único.
     *
     * @param id El ID del mesero a deshabilitar.
     * @return {@code true} si el mesero fue deshabilitado exitosamente.
     * @throws NegocioException Si no se encuentra el mesero o si ocurre un error durante la operación.
     */
    public boolean deshabilitarMesero(Integer id) throws NegocioException;

    /**
     * Activa (marca como activo) un mesero por su identificador único.
     *
     * @param id El ID del mesero a activar.
     * @return {@code true} si el mesero fue activado exitosamente.
     * @throws NegocioException Si no se encuentra el mesero o si ocurre un error durante la operación.
     */
    public boolean activarMesero(Integer id) throws NegocioException;

    /**
     * Obtiene una lista de todos los objetos {@link MeseroDTO} registrados en el sistema,
     * sin importar su estado de actividad.
     *
     * @return Una {@link List} de objetos {@link MeseroDTO}.
     * @throws NegocioException Si ocurre un error al obtener la lista de meseros.
     */
    public List<MeseroDTO> obtenerTodos() throws NegocioException;

    /**
     * Obtiene una lista de todos los objetos {@link MeseroDTO} que están actualmente activos.
     *
     * @return Una {@link List} de objetos {@link MeseroDTO} activos.
     * @throws NegocioException Si ocurre un error al obtener la lista de meseros activos.
     */
    public List<MeseroDTO> obtenerMeserosActivos() throws NegocioException;
}
