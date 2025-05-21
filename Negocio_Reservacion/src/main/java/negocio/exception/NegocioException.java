/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.exception;



/**
 * La clase **NegocioException** es una excepción personalizada diseñada para
 * indicar errores que ocurren específicamente en la **capa de lógica de negocio**
 * de la aplicación.
 *
 * Extiende de {@link java.lang.Exception}, lo que la clasifica como una
 * **excepción verificada (checked exception)**. Esto significa que cualquier
 * método que pueda lanzar una `NegocioException` debe declararla explícitamente
 * en su firma (`throws NegocioException`) o manejarla mediante un bloque `try-catch`.
 *
 * Esta excepción es crucial para separar las preocupaciones de la aplicación:
 * mientras que las {@link PersistenciaException} manejan errores de base de datos,
 * `NegocioException` se enfoca en problemas como validaciones de datos fallidas,
 * reglas de negocio incumplidas o dependencias de datos que no se satisfacen,
 * proporcionando un nivel de abstracción y un mensaje más significativo para el usuario
 * o la capa superior.
 *
 * @author Gael
 * @version 1.0
 */
public class NegocioException extends Exception {

    /**
     * Constructor de la excepción `NegocioException` que permite especificar
     * un mensaje descriptivo del error de negocio.
     *
     * @param message El mensaje que explica la causa del error en la lógica de negocio.
     */
    public NegocioException(String message) {
        super(message);
    }

    /**
     * Constructor de la excepción `NegocioException` que permite especificar
     * un mensaje descriptivo y una causa raíz (otra excepción) que originó
     * este error de negocio.
     *
     * Esto es útil para encapsular excepciones de capas inferiores (como
     * {@link PersistenciaException}) y propagarlas como un error de negocio.
     *
     * @param message El mensaje que explica la causa del error en la lógica de negocio.
     * @param cause La excepción original que provocó este error de negocio (por ejemplo, una PersistenciaException).
     */
    public NegocioException(String message, Throwable cause) {
        super(message, cause);
    }
}
