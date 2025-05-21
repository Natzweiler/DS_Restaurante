/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import Entidades.Mesa;
import dtos.MesaDTO;

/**
 * La clase **MesaMapper** es una utilidad estática que proporciona métodos para
 * la conversión bidireccional entre la entidad {@link Mesa} y su respectivo
 * DTO (Data Transfer Object) {@link MesaDTO}.
 *
 * Se utiliza para desacoplar la capa de persistencia de la capa de negocio/presentación,
 * permitiendo una manipulación de datos más flexible y segura.
 *
 * @author Gael
 * @version 1.0
 */
public class MesaMapper {

    /**
     * Constructor privado para evitar la instanciación de la clase, ya que
     * todos sus métodos son estáticos.
     */
    private MesaMapper() {
        // Constructor vacío intencionalmente
    }

    /**
     * Mapea un objeto de entidad {@link Mesa} a un objeto {@link MesaDTO}.
     *
     * @param mesa La entidad {@link Mesa} a ser mapeada.
     * @return Un objeto {@link MesaDTO} con los datos de la mesa.
     */
    public static MesaDTO toDTO(Mesa mesa) {
        if (mesa == null) {
            return null;
        }
        MesaDTO dto = new MesaDTO();
        dto.setNumeroMesa(mesa.getNumeroMesa());
        dto.setCapacidadMesa(mesa.getCapacidadMesa());
        dto.setDisponible(mesa.isDisponible());
        return dto;
    }

    /**
     * Mapea un objeto {@link MesaDTO} a un objeto de entidad {@link Mesa}.
     *
     * @param dto El objeto {@link MesaDTO} a ser mapeado.
     * @return Una entidad {@link Mesa} con los datos del DTO.
     */
    public static Mesa toEntity(MesaDTO dto) {
        if (dto == null) {
            return null;
        }
        Mesa mesa = new Mesa();
        mesa.setNumeroMesa(dto.getNumeroMesa());
        mesa.setCapacidadMesa(dto.getCapacidadMesa());
        mesa.setDisponible(dto.isDisponible());
        return mesa;
    }
}
