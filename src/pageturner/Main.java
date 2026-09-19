package pageturner;

/**
 * Clase principal del sistema PageTurner.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("     SISTEMA DE LIBRERÍA PAGETURNER");
        System.out.println("======================================");

        // Se crea un cliente para representar el registro de clientes.
        Cliente cliente = new Cliente(
                1,
                "Carlos Ramírez Gonzales",
                "72894561",
                "carlos@gmail.com"
        );

        // Se crea un libro con stock disponible.
        Libro libroJava = new Libro(
                1,
                "Programación en Java",
                "Herbert Schildt",
                "9781234567890",
                120.00,
                10
        );

        // Se crea un libro sin stock.
        Libro libroUML = new Libro(
                2,
                "Aprendiendo UML",
                "Martin Fowler",
                "9780987654321",
                95.00,
                0
        );

        // Se muestran los objetos creados, sin registrar ventas ni reservas.
        cliente.mostrarInfo();
        libroJava.mostrarInfo();
        libroUML.mostrarInfo();
    }
}
