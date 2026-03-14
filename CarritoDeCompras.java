import java.util.HashMap;
import java.util.Map;

/**
 * Representa un carrito de compras que permite agregar y remover {@link Item items},
 * calcular el total y mostrar un resumen.
 */
public class CarritoDeCompras {

    /**
     * Mapa de items y sus cantidades en el carrito.
     */
    private Map<Item, Integer> items = new HashMap<>();

    /** Encabezado impreso al mostrar el detalle del carrito. */
    public static final String CABECERA = "Detalles del carrito:";

    /** Símbolo de la moneda usada para mostrar precios. */
    public static final String MONEDA = "€";

    /**
     * Agrega una cantidad de un item al carrito.
     *
     * @param item     El item a agregar. No puede ser {@code null}.
     * @param cantidad La cantidad a agregar. Debe ser mayor que 0.
     * @throws IllegalArgumentException si la cantidad es menor o igual a 0.
     */
    public void agregarItem(Item item, int cantidad) {

        if (cantidad <= 0) {
            throw new IllegalArgumentException("Cantidad inválida");
        }

        items.put(item, items.getOrDefault(item, 0) + cantidad);
    }

    /**
     * Remueve un item del carrito.
     *
     * @param item El item a remover.
     * @throws IllegalArgumentException si el item no existe en el carrito.
     */
    public void removerItem(Item item) {

        if (!items.containsKey(item)) {
            throw new IllegalArgumentException("El item no existe en el carrito");
        }

        items.remove(item);
    }

    /**
     * Calcula el total del carrito multiplicando precio por cantidad.
     *
     * @return El total en la moneda configurada.
     */
    public double calcularTotal() {

        double total = 0;

        for (Map.Entry<Item, Integer> entry : items.entrySet()) {
            total += entry.getKey().getPrecio() * entry.getValue();
        }

        return total;
    }

    /**
     * Imprime en la consola el detalle del carrito y el total.
     */
    public void imprimirDetalle() {

        System.out.println(CABECERA);

        for (Map.Entry<Item, Integer> entry : items.entrySet()) {
            System.out.println(entry.getKey() + " x " + entry.getValue());
        }

        System.out.println("Total: " + MONEDA + calcularTotal());
    }
}