/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import Entidades.Mesero;
import dtos.MeseroDTO;

/**
 *
 * @author Gael
 */
public class MeseroMapper {

    // Método para mapear de entidad Mesero a DTO
    public static MeseroDTO toDTO(Mesero mesero) {
        MeseroDTO dto = new MeseroDTO();
        
        dto.setNombre(mesero.getNombre());
        
        return dto;
    }

    
    public static Mesero toEntity(MeseroDTO dto) {
        Mesero mesero = new Mesero();
        
        mesero.setNombre(dto.getNombre());
        
        return mesero;
    }
}

