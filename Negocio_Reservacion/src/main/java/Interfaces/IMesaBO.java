/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import dtos.MesaDTO;
import negocio.exception.NegocioException;

/**
 *
 * @author Gael
 */
public interface IMesaBO {
    MesaDTO obtenerMesaPorNumeroMesa(Integer numeroMesa) throws NegocioException;
}

