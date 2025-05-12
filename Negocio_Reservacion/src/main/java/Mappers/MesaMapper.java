/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import Entidades.Mesa;
import dtos.MesaDTO;

/**
 *
 * @author Gael
 */
public class MesaMapper {

    // Método para mapear de entidad Mesa a DTO
    public static MesaDTO toDTO(Mesa mesa) {
        MesaDTO dto = new MesaDTO();
        
        dto.setNumeroMesa(mesa.getNumeroMesa());
        dto.setCapacidadMesa(mesa.getCapacidadMesa());
        dto.setDisponible(mesa.isDisponible());
        
        return dto;
    }
    public static Mesa toEntity(MesaDTO dto) {
        Mesa mesa = new Mesa();
        
        mesa.setNumeroMesa(dto.getNumeroMesa());
        mesa.setCapacidadMesa(dto.getCapacidadMesa());
        mesa.setDisponible(dto.isDisponible());
        
        return mesa;
    }
}
