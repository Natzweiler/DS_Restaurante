/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosnegocio;

import dtos.MeseroDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gael
 */
public class MeseroON {
    
    private static MeseroON instancia;
    
        public static synchronized MeseroON getInstance() {
        if (instancia == null) {
            instancia = new MeseroON();
        }
        return instancia;
    }
   
   public List<MeseroDTO> obtenerMeseros() {
    List<MeseroDTO> meseros = new ArrayList<>();
    //datos simulados
    meseros.add(new MeseroDTO("Carlos Pérez"));
    meseros.add(new MeseroDTO( "Ana Gómez"));
    meseros.add(new MeseroDTO("Luis Herrera"));

    return meseros;
}     
        
        
        
}
