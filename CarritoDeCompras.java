import java.util.HashMap;
import java.util.Map;

public class CarritoDeCompras {

    private Map<Item, Integer> items = new HashMap<>();

    public static final String CABECERA = "Detalles del carrito:";
    public static final String MONEDA = "€";

    public void agregarItem(Item item, int cantidad) {

        if (cantidad <= 0) {
            throw new IllegalArgumentException("Cantidad inválida");
        }

        items.put(item, items.getOrDefault(item, 0) + cantidad);
    }

    public void removerItem(Item item) {

        if (!items.containsKey(item)) {
            throw new IllegalArgumentException("El item no existe en el carrito");
        }

        items.remove(item);
    }

    public double calcularTotal() {

        double total = 0;

        for (Map.Entry<Item, Integer> entry : items.entrySet()) {
            total += entry.getKey().getPrecio() * entry.getValue();
        }

        return total;
    }

    public void imprimirDetalle() {

        System.out.println(CABECERA);

        for (Map.Entry<Item, Integer> entry : items.entrySet()) {
            System.out.println(entry.getKey() + " x " + entry.getValue());
        }

        System.out.println("Total: " + MONEDA + calcularTotal());
    }
}