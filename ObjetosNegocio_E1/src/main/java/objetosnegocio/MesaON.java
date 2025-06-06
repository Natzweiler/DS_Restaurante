/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosnegocio;

import dtos.MesaDTO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Gael
 */
public class MesaON {
    
    private static MesaON instancia;
    private Map<Integer, MesaDTO> mesas; 

    
    private MesaON() {
        mesas = new HashMap<>();
    }

    
    public static synchronized MesaON getInstance() {
        if (instancia == null) {
            instancia = new MesaON();
        }
        return instancia;
    }

    
    public boolean insertarMesa(MesaDTO nuevaMesa) {
    if (!mesas.containsKey(nuevaMesa.getNumeroMesa())) { 
        mesas.put(nuevaMesa.getNumeroMesa(), nuevaMesa);
        return true; 
    }
    return false; 
}
     public List<MesaDTO> cargarMesas() {
    // Si el HashMap ya tiene mesas, devolverlas
    if (!mesas.isEmpty()) {
        return new ArrayList<>(mesas.values());
    }
    
    
    
    
    
    // Si no, inicializar con las mesas predefinidas
    List<MesaDTO> listaMesas = new ArrayList<>();
    listaMesas.add(new MesaDTO(1, 4, true));  
    listaMesas.add(new MesaDTO(2, 4, true));  
    listaMesas.add(new MesaDTO(3, 4, true)); 
    listaMesas.add(new MesaDTO(4, 4, true)); 
    listaMesas.add(new MesaDTO(5, 4, true)); 
    listaMesas.add(new MesaDTO(6, 4, true)); 
    listaMesas.add(new MesaDTO(7, 4, true)); 
    
    for (MesaDTO mesa : listaMesas) {
        insertarMesa(mesa);
    }
    return listaMesas;
}

    
    public MesaDTO obtenerMesa(int numeroMesa) {
        return mesas.get(numeroMesa);
    }
}
