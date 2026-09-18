# Sistema PageTurner

Proyecto desarrollado para el curso Técnicas de Programación Orientada a Objetos.

## Descripción

Sistema desarrollado en Java para gestionar los libros, clientes, ventas y reservas de la librería académica PageTurner.

## Funcionalidades

- Registro de clientes.
- Registro de libros.
- Control del stock.
- Registro de ventas.
- Descuento automático del stock.
- Cálculo del total vendido.
- Consulta de unidades vendidas e ingresos por libro.
- Registro de reservas para libros sin stock.
- Métodos `mostrarInfo()` para mostrar datos de forma clara en consola.
- Validación de datos y protección del historial de ventas y reservas.
- Conservación del precio unitario de cada venta para reportes históricos.

## Clases implementadas

- Cliente
- Libro
- Venta
- Reserva
- Main

## Integrantes

- Fabrizzio Arath Palacios Huamani
- Wilber Jordani Raraz Jananpa
- Manuel Gil Contreras
- Derliz Jhordan Mendoza Rodríguez

## Requisitos

- Java JDK 17 o superior.
- IntelliJ IDEA o cualquier IDE compatible con Java.

## Ejecución

Desde la raíz del proyecto, ejecutar:

```bash
javac -d out src/pageturner/*.java
java -cp out pageturner.Main
```
