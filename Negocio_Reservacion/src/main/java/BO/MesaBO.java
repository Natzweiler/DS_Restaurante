/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import Entidades.Mesa;
import Interfaces.IMesaBO;
import Mappers.MesaMapper;
import Persistencia.MesaDAO;
import dtos.MesaDTO;
import exception.PersistenciaException;
import java.util.ArrayList;
import java.util.List;
import negocio.exception.NegocioException;

import java.util.ArrayList;
import java.util.List;

/**
 * La clase **MesaBO** (Business Object) implementa la interfaz {@link IMesaBO}
 * y encapsula la lógica de negocio relacionada con la gestión de mesas.
 * Actúa como intermediario entre la capa de presentación (DTOs) y la capa de
 * persistencia (DAOs), manejando validaciones y transformaciones de datos.
 *
 * Se encarga de obtener mesas, generar mesas iniciales y actualizar su estado de disponibilidad.
 *
 * @author Gael
 * @version 1.0
 */
public class MesaBO implements IMesaBO {

    /**
     * Instancia del DAO de mesas para interactuar con la capa de persistencia.
     */
    private final MesaDAO mesaDAO;

    /**
     * Constructor de la clase MesaBO.
     * Inicializa la instancia de {@link MesaDAO} utilizando su método Singleton.
     */
    public MesaBO() {
        this.mesaDAO = MesaDAO.getInstanceDAO();
    }

    /**
     * Obtiene un {@link MesaDTO} a partir de su número de mesa.
     * Convierte la entidad {@link Mesa} obtenida del DAO a un {@link MesaDTO}.
     *
     * @param idMesa El número de la mesa a buscar.
     * @return Un objeto {@link MesaDTO} con la información de la mesa.
     * @throws NegocioException Si ocurre un error en la lógica de negocio o en la capa de persistencia.
     */
    @Override
    public MesaDTO obtenerMesaPorNumeroMesa(Integer idMesa) throws NegocioException {
        try {
            Mesa mesa = mesaDAO.obtenerMesaPorNumeroMesa(idMesa);
            return MesaMapper.toDTO(mesa);
        } catch (PersistenciaException e) {
            // Se propaga la excepción de persistencia como una excepción de negocio
            throw new NegocioException("Error al obtener la mesa por número: " + e.getMessage(), e);
        }
    }

    /**
     * Genera y registra un conjunto inicial de mesas en la base de datos.
     * Este método es útil para poblar la base de datos con datos de prueba iniciales.
     *
     * @return El número de mesas que fueron registradas exitosamente.
     * @throws NegocioException Si ocurre un error durante el registro de las mesas iniciales.
     */
    @Override
    public int generarMesasIniciales() throws NegocioException {
        try {
            int contador = 0;
            // Se generan 7 mesas con capacidad de 4 y estado disponible
            for (int i = 1; i <= 7; i++) {
                Mesa mesa = new Mesa();
                mesa.setNumeroMesa(i);
                mesa.setCapacidadMesa(4);
                mesa.setDisponible(true);
                mesaDAO.registrarMesa(mesa); // Registra la mesa a través del DAO
                contador++;
            }
            return contador;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al generar mesas iniciales: " + e.getMessage(), e);
        }
    }

    /**
     * Obtiene una lista de todos los {@link MesaDTO}s disponibles en el sistema.
     * Convierte la lista de entidades {@link Mesa} obtenida del DAO a una lista de {@link MesaDTO}s.
     *
     * @return Una {@link List} de objetos {@link MesaDTO}.
     * @throws NegocioException Si ocurre un error al obtener las mesas.
     */
    @Override
    public List<MesaDTO> obtenerTodasLasMesas() throws NegocioException {
        try {
            List<Mesa> mesas = mesaDAO.obtenerTodasLasMesas();
            List<MesaDTO> dtoList = new ArrayList<>();
            for (Mesa mesa : mesas) {
                dtoList.add(MesaMapper.toDTO(mesa)); // Convierte cada entidad a DTO
            }
            return dtoList;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener todas las mesas: " + e.getMessage(), e);
        }
    }

    /**
     * Actualiza el estado de disponibilidad de una mesa específica.
     *
     * @param numeroMesa El número de la mesa a actualizar.
     * @param disponible El nuevo estado de disponibilidad ({@code true} para disponible, {@code false} para ocupada).
     * @return {@code true} si la actualización fue exitosa.
     * @throws NegocioException Si no se pudo actualizar el estado de la mesa debido a un error de persistencia.
     */
    @Override
    public boolean actualizarEstadoMesa(int numeroMesa, boolean disponible) throws NegocioException {
        try {
            return mesaDAO.actualizarDisponibilidadMesa(numeroMesa, disponible);
        } catch (PersistenciaException e) {
            throw new NegocioException("No se pudo actualizar el estado de la mesa: " + e.getMessage(), e);
        }
    }
}

