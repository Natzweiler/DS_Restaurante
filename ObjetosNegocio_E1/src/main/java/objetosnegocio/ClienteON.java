/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosnegocio;

import dtos.ClienteDTO;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Gael
 */
public class ClienteON {
    
    private static ClienteON instancia;
    private Map<String, ClienteDTO> clientes;

    
    private ClienteON() {
        clientes = new HashMap<>();
    }

    
    public static synchronized ClienteON getInstance() {
        if (instancia == null) {
            instancia = new ClienteON();
        }
        return instancia;
    }

   
    public boolean insertarCliente(ClienteDTO nuevoCliente) {
        if (!clientes.containsKey(nuevoCliente.getCorreo())) { 
            clientes.put(nuevoCliente.getCorreo(), nuevoCliente);
            return true; 
        }
        return false;
    }

    
    public ClienteDTO obtenerCliente(String correo) {
        return clientes.get(correo);
    }
}

