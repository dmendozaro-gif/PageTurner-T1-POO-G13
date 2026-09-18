package pageturner;

import java.time.LocalDate;

/**
 * Clase principal del sistema PageTurner.
 * Permite demostrar el registro de clientes, libros,
 * ventas, reservas y actualización del stock.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("     SISTEMA DE LIBRERÍA PAGETURNER");
        System.out.println("======================================");

        // Creación de un cliente
        Cliente cliente = new Cliente(
                1,
                "Carlos Ramírez Gonzales",
                "72894561",
                "carlos@gmail.com"
        );

        // Creación de un libro con stock disponible
        Libro libroJava = new Libro(
                1,
                "Programación en Java",
                "Herbert Schildt",
                "9781234567890",
                120.00,
                10
        );

        // Creación de un libro sin stock
        Libro libroUML = new Libro(
                2,
                "Aprendiendo UML",
                "Martin Fowler",
                "9780987654321",
                95.00,
                0
        );

        System.out.println("\n1. DATOS REGISTRADOS");

        System.out.println("\nCliente:");
        System.out.println(cliente);

        System.out.println("\nLibros:");
        System.out.println(libroJava);
        System.out.println(libroUML);

        /*
         * PRUEBA DE VENTA
         */

        System.out.println("\n======================================");
        System.out.println("2. REGISTRO DE VENTA");
        System.out.println("======================================");

        System.out.println(
                "Stock antes de la venta: " +
                        libroJava.getStock()
        );

        // Se crea una venta de dos libros
        Venta venta = new Venta(
                1,
                LocalDate.now(),
                2,
                cliente,
                libroJava
        );

        try {
            // Confirma la venta y descuenta automáticamente el stock
            venta.confirmarVenta();

            System.out.println("Venta registrada correctamente.");
            System.out.println(
                    "Libro vendido: " +
                            libroJava.getTitulo()
            );

            System.out.println(
                    "Cantidad vendida: " +
                            venta.getCantidad()
            );

            System.out.printf(
                    "Total de la venta: S/ %.2f%n",
                    venta.calcularTotal()
            );

            System.out.println(
                    "Stock después de la venta: " +
                            libroJava.getStock()
            );

        } catch (IllegalStateException error) {
            System.out.println(
                    "Error al registrar la venta: " +
                            error.getMessage()
            );
        }

        /*
         * CONSULTA DE VENTAS E INGRESOS
         */

        System.out.println("\n======================================");
        System.out.println("3. REPORTE DEL LIBRO");
        System.out.println("======================================");

        System.out.println(
                "Libro: " +
                        libroJava.getTitulo()
        );

        System.out.println(
                "Unidades vendidas: " +
                        libroJava.getCantidadVentas()
        );

        System.out.printf(
                "Dinero generado: S/ %.2f%n",
                libroJava.calcularIngresos()
        );

        /*
         * PRUEBA DE RESERVA
         */

        System.out.println("\n======================================");
        System.out.println("4. REGISTRO DE RESERVA");
        System.out.println("======================================");

        Reserva reserva = new Reserva(
                1,
                LocalDate.now(),
                cliente,
                libroUML
        );

        try {
            reserva.registrar();

            System.out.println("Reserva registrada correctamente.");
            System.out.println(
                    "Cliente: " +
                            reserva.getCliente().getNombre()
            );

            System.out.println(
                    "Libro reservado: " +
                            reserva.getLibro().getTitulo()
            );

            System.out.println(
                    "Fecha: " +
                            reserva.getFecha()
            );

            System.out.println(
                    "Estado: " +
                            reserva.getEstado()
            );

        } catch (IllegalStateException error) {
            System.out.println(
                    "Error al registrar la reserva: " +
                            error.getMessage()
            );
        }

        /*
         * RESUMEN DEL CLIENTE
         */

        System.out.println("\n======================================");
        System.out.println("5. RESUMEN DEL CLIENTE");
        System.out.println("======================================");

        System.out.println(
                "Cantidad de ventas registradas: " +
                        cliente.getVentas().size()
        );

        System.out.println(
                "Cantidad de reservas registradas: " +
                        cliente.getReservas().size()
        );

        System.out.println("\nPrograma finalizado correctamente.");
    }
}