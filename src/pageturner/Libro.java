package pageturner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Representa un libro disponible en la librería PageTurner.
 * Controla sus datos, stock, ventas y reservas.
 */
public class Libro {

    // Atributos principales del libro
    private int idLibro;
    private String titulo;
    private String autor;
    private String isbn;
    private double precio;
    private int stock;

    // Historial de ventas y reservas asociadas al libro
    private List<Venta> ventas;
    private List<Reserva> reservas;

    // Constructor de la clase Libro.    
    public Libro(
            int idLibro,
            String titulo,
            String autor,
            String isbn,
            double precio,
            int stock
    ) {
        this.idLibro = validarId(idLibro);
        this.titulo = validarTexto(titulo, "El título no puede estar vacío.");
        this.autor = validarTexto(autor, "El autor no puede estar vacío.");
        this.isbn = validarTexto(isbn, "El ISBN no puede estar vacío.");
        this.precio = validarPrecio(precio);
        this.stock = validarStockInicial(stock);

        // Inicialización de las listas
        this.ventas = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

  
    // Verifica si existe stock suficiente para una venta.
    public boolean tieneStock(int cantidad) {
        return cantidad > 0 && stock >= cantidad;
    }

    // Descuenta del stock la cantidad vendida.
    public void descontarStock(int cantidad) {
        if (!tieneStock(cantidad)) {
            throw new IllegalArgumentException(
                    "No existe stock suficiente para realizar la venta."
            );
        }
        stock -= cantidad;
    }

    // Agrega una venta al historial del libro.
    public void agregarVenta(Venta venta) {
        if (venta != null && !ventas.contains(venta)) {
            ventas.add(venta);
        }
    }

    // Agrega una reserva a la lista del libro.
    public void agregarReserva(Reserva reserva) {
        if (reserva != null && !reservas.contains(reserva)) {
            reservas.add(reserva);
        }
    }

    // Calcula la cantidad total de unidades vendidas.
    public int getUnidadesVendidas() {
        int cantidadTotal = 0;

        for (Venta venta : ventas) {
            cantidadTotal += venta.getCantidad();
        }

        return cantidadTotal;
    }

    // Devuelve el número de operaciones de venta registradas para este libro.
    public int getNumeroVentas() {
        return ventas.size();
    }

    // Se conserva para compatibilidad. Representa unidades, no operaciones.
    public int getCantidadVentas() {
        return getUnidadesVendidas();
    }

    // Calcula el dinero generado por las ventas del libro.
    public double calcularIngresos() {
        double ingresos = 0;

        for (Venta venta : ventas) {
            ingresos += venta.calcularTotal();
        }

        return ingresos;
    }

    // Métodos getters y setters

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = validarId(idLibro);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = validarTexto(titulo, "El título no puede estar vacío.");
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = validarTexto(autor, "El autor no puede estar vacío.");
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = validarTexto(isbn, "El ISBN no puede estar vacío.");
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = validarPrecio(precio);
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = validarStockInicial(stock);
    }

    public List<Venta> getVentas() {
        return Collections.unmodifiableList(ventas);
    }

    public List<Reserva> getReservas() {
        return Collections.unmodifiableList(reservas);
    }

    // Función para mostrar los datos principales del libro.
    public void mostrarInfo() {
        System.out.println("\n======================================");
        System.out.println("           DATOS DEL LIBRO");
        System.out.println("======================================");
        System.out.println("ID      : " + idLibro);
        System.out.println("Título  : " + titulo);
        System.out.println("Autor   : " + autor);
        System.out.println("ISBN    : " + isbn);
        System.out.println("Precio  : S/ " + precio);
        System.out.println("Stock   : " + stock);
        System.out.println("======================================");
    }

    // Funciones privadas para validar los datos del libro
    private static int validarId(int idLibro) {
        if (idLibro <= 0) {
            throw new IllegalArgumentException("El identificador del libro debe ser mayor que cero.");
        }
        return idLibro;
    }

    private static double validarPrecio(double precio) {
        if (!Double.isFinite(precio) || precio < 0) {
            throw new IllegalArgumentException("El precio debe ser un número mayor o igual que cero.");
        }
        return precio;
    }

    private static int validarStockInicial(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo.");
        }
        return stock;
    }

    private static String validarTexto(String valor, String mensaje) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(mensaje);
        }
        return valor.trim();
    }
}
