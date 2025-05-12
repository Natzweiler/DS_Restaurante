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

    
    public static Mesero toEntity(MeseroDTO meseroDTO) {
        if (meseroDTO == null) {
            return null;
        }
        Mesero mesero = new Mesero();
        mesero.setId(meseroDTO.getId());  
        mesero.setNombre(meseroDTO.getNombre());
        return mesero;
    }

    
    public static MeseroDTO toDTO(Mesero mesero) {
        if (mesero == null) {
            return null;
        }
        MeseroDTO meseroDTO = new MeseroDTO();
        meseroDTO.setId(mesero.getId());  
        meseroDTO.setNombre(mesero.getNombre());
        return meseroDTO;
    }
}

