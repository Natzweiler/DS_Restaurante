/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import dtos.MesaDTO;
import java.util.List;
import negocio.exception.NegocioException;

/**
 *
 * @author Gael
 */
public interface IMesaBO {
    MesaDTO obtenerMesaPorNumeroMesa(Integer numeroMesa) throws NegocioException;
    public int generarMesasIniciales() throws NegocioException;
    public List<MesaDTO> obtenerTodasLasMesas() throws NegocioException;
    public boolean actualizarEstadoMesa(int numeroMesa, boolean disponible) throws NegocioException;



}

