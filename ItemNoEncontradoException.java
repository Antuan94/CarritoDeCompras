/**
 * Excepción lanzada cuando se intenta operar con un item que no existe en el carrito.
 */
public class ItemNoEncontradoException extends RuntimeException {

    public ItemNoEncontradoException(String message) {
        super(message);
    }

    public ItemNoEncontradoException(String message, Throwable cause) {
        super(message, cause);
    }
}
