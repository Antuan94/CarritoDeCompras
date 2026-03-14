/**
 * Excepcion lanzada cuando se proporciona una cantidad invalida para añadir o quitar del carrito.
 */
public class CantidadInvalidaException extends RuntimeException {

    public CantidadInvalidaException(String message) {
        super(message);
    }

    public CantidadInvalidaException(String message, Throwable cause) {
        super(message, cause);
    }
}
