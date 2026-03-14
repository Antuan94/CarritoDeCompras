/**
 * Representa un artículo con nombre y precio.
 * <p>
 * El {@link #equals(Object)} y {@link #hashCode()} se basan en el nombre para
 * permitir que dos instancias con el mismo nombre se consideren el mismo producto
 * (por ejemplo, al usar un {@link java.util.Map} para contabilizar cantidades).
 * </p>
 */
public class Item {

    /** Nombre del item. */
    private String nombre;

    /** Precio del item. */
    private double precio;

    /** Símbolo usado para mostrar el precio. */
    public static final String MONEDA = "EUR";

    /** Precio mínimo permitido para un item. */
    public static final double PRECIO_MIN = 0;

    /** Precio máximo permitido para un item. */
    public static final double PRECIO_MAX = 10000;

    /** Longitud mínima permitida para el nombre. */
    public static final int NOMBRE_MIN_LENGTH = 1;

    /** Longitud máxima permitida para el nombre. */
    public static final int NOMBRE_MAX_LENGTH = 100;

    /**
     * Crea un nuevo item con nombre y precio.
     *
     * @param nombre Nombre del item.
     * @param precio Precio del item; debe estar entre {@link #PRECIO_MIN} y {@link #PRECIO_MAX}.
     * @throws IllegalArgumentException si el nombre es nulo/vacío o el precio no está en el rango permitido.
     */
    public Item(String nombre, double precio) {
        setNombre(nombre);
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
     * Establece el nombre del item.
     *
     * @param nombre El nuevo nombre.
     * @throws IllegalArgumentException si el nombre es nulo, vacío o demasiado largo.
     */
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }
        if (nombre.length() > NOMBRE_MAX_LENGTH) {
            throw new IllegalArgumentException("El nombre es demasiado largo");
        }
        this.nombre = nombre.trim();
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
            throw new IllegalArgumentException("Precio invalido");
        }
        this.precio = precio;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Item)) {
            return false;
        }
        Item other = (Item) obj;
        return nombre.equalsIgnoreCase(other.nombre);
    }

    @Override
    public int hashCode() {
        return nombre.toLowerCase().hashCode();
    }

    @Override
    public String toString() {
        return String.format("%s - %s%.2f", nombre, MONEDA, precio);
    }
}