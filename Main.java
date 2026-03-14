public class Main {

    public static void main(String[] args) {

        try {

            CarritoDeCompras carrito = new CarritoDeCompras();

            Item camiseta = new Item("Camiseta", 20.99);
            Item pantalones = new Item("Pantalones", 34.99);

            carrito.agregarItem(camiseta, 2);
            carrito.agregarItem(pantalones, 1);

            carrito.imprimirDetalle();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}