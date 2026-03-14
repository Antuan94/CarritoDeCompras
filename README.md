# CarritoDeCompras

Proyecto en Java que implementa un carrito de compras refactorizado aplicando buenas prácticas de programación orientada a objetos.

## Descripción

Este proyecto mejora el código original de un carrito de compras, aplicando los siguientes principios:

- Separación de responsabilidades: La lógica del carrito de compras está en `CarritoDeCompras`, mientras que `Main` contiene el programa principal.
- Reducción de acoplamiento: La clase `CarritoDeCompras` utiliza métodos (`getters`, `toString()`) de la clase `Item`, evitando acceso directo a sus atributos.
- Encapsulación: Los atributos de `Item` son privados y se accede a ellos mediante `getters` y `setters`.
- Eliminación de duplicación: El cálculo del total y la impresión del listado se separan en métodos independientes.
- Uso de constantes para textos y valores reutilizables en la clase `CarritoDeCompras`.
- Implementación de cantidad de productos por item.
- Mejora de escalabilidad al usar una estructura de datos (`HashMap`) que asocia cada item con su cantidad.
- Documentación con Javadoc en las clases.

## Estructura del proyecto

```text
CarritoDeCompras/
├── Item.java
├── CarritoDeCompras.java
├── Main.java
└── README.md
