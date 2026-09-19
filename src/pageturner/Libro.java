package pageturner;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un libro disponible en la librería PageTurner.
 */
public class Libro {

    private int idLibro;
    private String titulo;
    private String autor;
    private String isbn;
    private double precio;
    private int stock;
    private List<Venta> ventas;
    private List<Reserva> reservas;

    public Libro(int idLibro, String titulo, String autor, String isbn,
                 double precio, int stock) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.precio = precio;
        this.stock = stock;
        this.ventas = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public boolean tieneStock(int cantidad) {
        // Esta función verificará si existe stock para la cantidad solicitada.
        return false;
    }

    public void descontarStock(int cantidad) {
        // Esta función descontará del stock la cantidad vendida.
    }

    public void agregarVenta(Venta venta) {
        // Esta función agregará una venta al historial del libro.
    }

    public void agregarReserva(Reserva reserva) {
        // Esta función agregará una reserva al historial del libro.
    }

    public int getUnidadesVendidas() {
        // Esta función calculará la cantidad total de unidades vendidas.
        return 0;
    }

    public int getNumeroVentas() {
        // Esta función obtendrá el número de ventas realizadas del libro.
        return 0;
    }

    public double calcularIngresos() {
        // Esta función calculará el dinero generado por las ventas del libro.
        return 0.0;
    }

    // Getters y setters
    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

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
}
