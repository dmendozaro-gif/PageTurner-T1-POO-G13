package pageturner;

import java.util.ArrayList;
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

    /**
     * Constructor de la clase Libro.
     */
    public Libro(
            int idLibro,
            String titulo,
            String autor,
            String isbn,
            double precio,
            int stock
    ) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.precio = precio;
        this.stock = stock;

        // Inicialización de las listas
        this.ventas = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    /**
     * Verifica si existe stock suficiente para una venta.
     */
    public boolean tieneStock(int cantidad) {
        return cantidad > 0 && stock >= cantidad;
    }

    /**
     * Descuenta del stock la cantidad vendida.
     */
    public void descontarStock(int cantidad) {
        if (!tieneStock(cantidad)) {
            throw new IllegalArgumentException(
                    "No existe stock suficiente para realizar la venta."
            );
        }

        stock -= cantidad;
    }

    /**
     * Agrega una venta al historial del libro.
     */
    public void agregarVenta(Venta venta) {
        if (venta != null) {
            ventas.add(venta);
        }
    }

    /**
     * Agrega una reserva a la lista del libro.
     */
    public void agregarReserva(Reserva reserva) {
        if (reserva != null) {
            reservas.add(reserva);
        }
    }

    /**
     * Calcula la cantidad total de unidades vendidas.
     */
    public int getCantidadVentas() {
        int cantidadTotal = 0;

        for (Venta venta : ventas) {
            cantidadTotal += venta.getCantidad();
        }

        return cantidadTotal;
    }

    /**
     * Calcula el dinero generado por las ventas del libro.
     */
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
        if (precio < 0) {
            throw new IllegalArgumentException(
                    "El precio no puede ser negativo."
            );
        }

        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException(
                    "El stock no puede ser negativo."
            );
        }

        this.stock = stock;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    /**
     * Devuelve los datos principales del libro.
     */
    @Override
    public String toString() {
        return "Libro{" +
                "idLibro=" + idLibro +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", isbn='" + isbn + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                '}';
    }
}