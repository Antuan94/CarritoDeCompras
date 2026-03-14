public class Item {

    private String nombre;
    private double precio;

    public static final double PRECIO_MIN = 0;
    public static final double PRECIO_MAX = 10000;

    public Item(String nombre, double precio) {
        this.nombre = nombre;
        setPrecio(precio);
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

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