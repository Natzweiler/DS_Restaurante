/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exception;

/**
 * La clase **PersistenciaException** es una excepción personalizada que se utiliza
 * para indicar errores específicos que ocurren durante las operaciones de persistencia
 * o acceso a datos en la aplicación. Extiende de {@link java.lang.Exception},
 * lo que la convierte en una excepción verificada (checked exception),
 * obligando a los métodos que la puedan lanzar a declararla o manejarla.
 *
 * Esta excepción es útil para encapsular y propagar errores relacionados con la base de datos,
 * como problemas de conexión, fallos en las transacciones, o la no existencia de registros,
 * proporcionando un mensaje claro y la causa raíz del problema.
 *
 * @author Gael
 * @version 1.0
 */
public class PersistenciaException extends Exception {

    /**
     * Constructor de la excepción PersistenciaException que toma un mensaje descriptivo.
     *
     * @param message El mensaje que describe la causa de la excepción.
     */
    public PersistenciaException(String message) {
        super(message);
    }

    /**
     * Constructor de la excepción PersistenciaException que toma un mensaje descriptivo
     * y una causa subyacente (otra excepción) que originó este error de persistencia.
     *
     * @param message El mensaje que describe la causa de la excepción.
     * @param cause La causa raíz de la excepción (por ejemplo, una SQLException, o una JPAException).
     */
    public PersistenciaException(String message, Throwable cause) {
        super(message, cause);
    }
}