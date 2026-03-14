# CarritoDeCompras

Proyecto de ejemplo en Java que modela un carrito de compras con buenas prácticas de diseño:
- Separación de responsabilidad entre modelo (Item, CarritoDeCompras) y presentación (Main).
- Validaciones en constructor y setters (no se admiten precios negativos ni demasiado altos).
- Uso de constantes para parámetros (moneda, encabezado, rangos de precio).
- Manejo de excepciones específicas para casos de uso erróneos.
- Documentación completa con Javadoc.

## Estructura del proyecto

- `Item.java` → Modelo del producto; contiene nombre, precio, validaciones y `toString()` bien definido.
- `CarritoDeCompras.java` → Lógica del carrito; mantiene cantidades, calcula totales y expone una vista de solo lectura de los items.
- `Main.java` → Punto de entrada; usa el carrito y muestra cómo manejar excepciones.
- `ItemNoEncontradoException.java` → Excepción custom para operaciones sobre items ausentes.
- `CantidadInvalidaException.java` → Excepción custom para cantidades inválidas.

## Ejecutar el proyecto

1. Asegúrate de tener instalado Java 17 o superior.
2. Desde la raíz del proyecto:

```bash
javac *.java
java Main
```

## Qué muestra el programa

El programa crea un carrito, agrega productos con cantidades y muestra el detalle (nombre, precio, cantidad y total). También incluye un ejemplo de manejo de excepción al intentar eliminar un item que no existe.

## Notas de diseño

- El carrito **no imprime directamente**; su responsabilidad es mantener el estado y calcular totales.
- La presentación del carrito (qué y cómo se muestra) queda fuera del modelo.
- Para escalar a grandes volúmenes, el carrito usa un `LinkedHashMap` para mantener orden determinista y permite cambiar la implementación a otro `Map` más apropiado (p.ej. `ConcurrentHashMap`) sin afectar a los consumidores.
