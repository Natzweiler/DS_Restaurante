/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entidades.Mesero;
import negocio.exception.NegocioException;

/**
 *
 * @author Gael
 */
public interface IMeseroBO {
        public Mesero obtenerMeseroPorId(Integer id) throws NegocioException ;
}
