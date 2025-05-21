/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import dtos.MesaDTO;
import java.util.List;
import negocio.exception.NegocioException;


import java.util.List;
/**
 * La interfaz **IMesaBO** define el contrato para la lógica de negocio
 * relacionada con la gestión de mesas.
 *
 * Especifica las operaciones que deben ser soportadas para manejar
 * la información de las mesas, incluyendo la obtención, generación inicial
 * y actualización de su estado.
 *
 * @author Gael
 * @version 1.0
 */
public interface IMesaBO {

    /**
     * Obtiene un objeto {@link MesaDTO} por su número de mesa.
     *
     * @param numeroMesa El número de la mesa a buscar.
     * @return Un objeto {@link MesaDTO} con los detalles de la mesa encontrada.
     * @throws NegocioException Si no se encuentra la mesa o si ocurre un error en la lógica de negocio.
     */
    MesaDTO obtenerMesaPorNumeroMesa(Integer numeroMesa) throws NegocioException;

    /**
     * Genera un conjunto inicial de mesas para la aplicación.
     * Este método es útil para la configuración inicial o para pruebas.
     *
     * @return El número de mesas que fueron generadas y registradas exitosamente.
     * @throws NegocioException Si ocurre un error durante el proceso de generación de mesas.
     */
    public int generarMesasIniciales() throws NegocioException;

    /**
     * Obtiene una lista de todos los objetos {@link MesaDTO} disponibles en el sistema.
     *
     * @return Una {@link List} de objetos {@link MesaDTO}.
     * @throws NegocioException Si ocurre un error al obtener la lista de mesas.
     */
    public List<MesaDTO> obtenerTodasLasMesas() throws NegocioException;

    /**
     * Actualiza el estado de disponibilidad de una mesa específica.
     *
     * @param numeroMesa El número de la mesa a actualizar.
     * @param disponible El nuevo estado de disponibilidad ({@code true} si está disponible, {@code false} si está ocupada).
     * @return {@code true} si la actualización fue exitosa.
     * @throws NegocioException Si no se pudo actualizar el estado de la mesa.
     */
    public boolean actualizarEstadoMesa(int numeroMesa, boolean disponible) throws NegocioException;
}

