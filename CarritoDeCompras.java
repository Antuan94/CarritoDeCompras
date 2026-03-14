import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Representa un carrito de compras que mantiene los items y sus cantidades.
 * <p>
 * El carrito no imprime directamente su contenido; en su lugar expone APIs para
 * obtener el detalle y el total, de modo que la presentación quede en manos de
 * quien use la clase (por ejemplo, la capa de interfaz de usuario).
 * </p>
 */
public class CarritoDeCompras {

    /** Encabezado por defecto para mostrar el detalle del carrito. */
    public static final String CABECERA = "Detalles del carrito:";

    /** Símbolo de la moneda usada para mostrar precios. */
    public static final String MONEDA = "EUR";

    // Usamos LinkedHashMap para mantener el orden de inserción al iterar.
    private final Map<Item, Integer> items = new LinkedHashMap<>();

    /**
     * Agrega una cantidad de un item al carrito.
     *
     * @param item     El item a agregar. No puede ser {@code null}.
     * @param cantidad La cantidad a agregar. Debe ser mayor que 0.
     * @throws NullPointerException      si {@code item} es {@code null}.
     * @throws CantidadInvalidaException si {@code cantidad} es menor o igual a 0.
     */
    public void agregarItem(Item item, int cantidad) {
        Objects.requireNonNull(item, "Item no puede ser null");

        if (cantidad <= 0) {
            throw new CantidadInvalidaException("Cantidad invalida: " + cantidad);
        }

        items.put(item, items.getOrDefault(item, 0) + cantidad);
    }

    /**
     * Remueve un item del carrito.
     *
     * @param item El item a remover.
     * @throws NullPointerException      si {@code item} es {@code null}.
     * @throws ItemNoEncontradoException si el item no existe en el carrito.
     */
    public void removerItem(Item item) {
        Objects.requireNonNull(item, "Item no puede ser null");

        if (!items.containsKey(item)) {
            throw new ItemNoEncontradoException("El item no existe en el carrito: " + item.getNombre());
        }

        items.remove(item);
    }

    /**
     * Calcula el total del carrito multiplicando precio por cantidad.
     *
     * @return El total en la moneda configurada.
     */
    public double calcularTotal() {
        return items.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrecio() * entry.getValue())
                .sum();
    }

    /**
     * Obtiene una vista de solo lectura de los items y sus cantidades.
     *
     * @return Mapa inmutable de items a cantidades.
     */
    public Map<Item, Integer> obtenerItems() {
        return Collections.unmodifiableMap(items);
    }

    /**
     * Representación de texto del carrito, útil para depuración o logs.
     * La presentación concreta (impresión) debe hacerse fuera de esta clase.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CABECERA).append(System.lineSeparator());

        for (Map.Entry<Item, Integer> entry : items.entrySet()) {
            sb.append(entry.getKey())
              .append(" x ")
              .append(entry.getValue())
              .append(System.lineSeparator());
        }

        sb.append("Total: ").append(MONEDA).append(String.format("%.2f", calcularTotal()));
        return sb.toString();
    }
}