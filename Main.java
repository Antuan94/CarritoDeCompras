import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Clase de entrada para la aplicación de ejemplo que demuestra el uso de
 * {@link CarritoDeCompras} e {@link Item}.
 */
public class Main {

    /**
     * Punto de entrada de la aplicación.
     *
     * @param args Argumentos de línea de comandos (no usados).
     */
    public static void main(String[] args) {

        // Aseguramos que la salida sea UTF-8 para que los caracteres acentuados se muestren correctamente.
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        CarritoDeCompras carrito = new CarritoDeCompras();

        Item camiseta = new Item("Camiseta", 20.99);
        Item pantalones = new Item("Pantalones", 34.99);

        try {
            carrito.agregarItem(camiseta, 2);
            carrito.agregarItem(pantalones, 1);

            // El carrito no imprime por sí solo; la presentación queda en esta capa.
            System.out.println(carrito);

            // Ejemplo de manejo de excepciones al remover un item que no existe.
            carrito.removerItem(new Item("Calcetines", 5.0));

        } catch (ItemNoEncontradoException e) {
            System.out.println("No se pudo completar la operacion: " + e.getMessage());
        } catch (CantidadInvalidaException e) {
            System.out.println("Cantidad invalida: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error de validacion: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
}