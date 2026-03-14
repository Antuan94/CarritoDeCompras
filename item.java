/**
 * Representa un artículo con nombre y precio.
 */
public class Item {

    /** Nombre del item. */
    private String nombre;

    /** Precio del item. */
    private double precio;

    /** Precio mínimo permitido para un item. */
    public static final double PRECIO_MIN = 0;

    /** Precio máximo permitido para un item. */
    public static final double PRECIO_MAX = 10000;

    /**
     * Crea un nuevo item con nombre y precio.
     *
     * @param nombre Nombre del item.
     * @param precio Precio del item; debe estar entre {@link #PRECIO_MIN} y {@link #PRECIO_MAX}.
     * @throws IllegalArgumentException si el precio no está en el rango permitido.
     */
    public Item(String nombre, double precio) {
        this.nombre = nombre;
        setPrecio(precio);
    }

    /**
     * Obtiene el nombre del item.
     *
     * @return Nombre del item.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el precio del item.
     *
     * @return Precio del item.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del item.
     *
     * @param precio El nuevo precio.
     * @throws IllegalArgumentException si el precio no está en el rango permitido.
     */
    public void setPrecio(double precio) {
        if (precio < PRECIO_MIN || precio > PRECIO_MAX) {
            throw new IllegalArgumentException("Precio inválido");
        }
        this.precio = precio;
    }

    @Override
    public String toString() {
        return nombre + " - €" + precio;
    }
}