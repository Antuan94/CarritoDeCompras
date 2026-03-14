# CarritoDeCompras

Proyecto en Java que implementa un carrito de compras refactorizado aplicando buenas prácticas de programación orientada a objetos.

## Descripción

Este proyecto mejora el código original de un carrito de compras, aplicando los siguientes principios:

- Separación de responsabilidades: La clase `CarritoDeCompras` gestiona únicamente los items y el cálculo del total, mientras que `Main` contiene el programa principal.
- Reducción de acoplamiento: `CarritoDeCompras` y `Item` interactúan mediante **getters**, **setters** y `toString()`, evitando acceso directo a atributos privados.
- Encapsulación: Los atributos de `Item` son privados y se accede a ellos mediante **getters y setters**. Se valida que los precios no sean negativos ni excesivamente altos.
- Eliminación de duplicación: La lógica de listado de items y cálculo del total está centralizada en métodos de la clase `CarritoDeCompras`.
- Uso de constantes: Textos como el símbolo de la moneda, cabecera del listado y límites de precio se definen como **constantes** dentro de las clases.
- Escalabilidad: La lista de items se implementa con un **HashMap**, permitiendo almacenar cada item junto a su cantidad, mejorando búsquedas y agregando soporte para grandes cantidades de productos.
- Funcionalidad adicional: Se implementa la **cantidad de cada item** comprado en el carrito.
- Documentación: Cada clase y método está documentado con **Javadoc**, describiendo sus responsabilidades y parámetros.

## Clases principales

### `Item.java`
- Representa un producto que puede agregarse al carrito.
- Contiene `nombre` y `precio` como atributos privados.
- Implementa `getNombre()`, `getPrecio()` y `setPrecio()` con validación.
- Sobrescribe `toString()` para mostrar información del item de manera clara.

### `CarritoDeCompras.java`
- Gestiona un conjunto de items y sus cantidades.
- Métodos principales:
  - `agregarItem(Item item, int cantidad)`: añade un item al carrito.
  - `removerItem(Item item)`: elimina un item del carrito.
  - `calcularTotal()`: devuelve el total del carrito.
  - `imprimirDetalle()`: muestra todos los items con su cantidad y el total.
- Contiene constantes para el símbolo de la moneda y cabecera del listado.

### `Main.java`
- Contiene el programa principal para probar la funcionalidad del carrito.
- Crea un carrito, agrega items con cantidades y muestra el detalle final.

## Estructura del proyecto

```text
CarritoDeCompras/
├── Item.java
├── CarritoDeCompras.java
├── Main.java
└── README.md
