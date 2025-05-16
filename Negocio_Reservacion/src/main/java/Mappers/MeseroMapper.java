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

    public static Mesero toEntity(MeseroDTO dto) {
        if (dto == null) return null;

        Mesero mesero = new Mesero();
        mesero.setId(dto.getId());  
        mesero.setNombre(dto.getNombre());
        mesero.setTelefono(dto.getTelefono());
        mesero.setFechaNacimiento(dto.getFechaNacimiento());
        mesero.setEstado(true); // estado activo por default
        return mesero;
    }

    public static MeseroDTO toDTO(Mesero mesero) {
        if (mesero == null) return null;

        MeseroDTO dto = new MeseroDTO();
        dto.setId(mesero.getId());  
        dto.setNombre(mesero.getNombre());
        dto.setTelefono(mesero.getTelefono());
        dto.setFechaNacimiento(mesero.getFechaNacimiento());
        // No necesitas setEstado porque no lo manejas en DTO
        return dto;
    }
}


