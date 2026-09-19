package pageturner;

import java.time.LocalDate;

/**
 * Representa la venta de un libro a un cliente.
 */
public class Venta {

    private int idVenta;
    private LocalDate fecha;
    private int cantidad;
    private double precioUnitario;
    private boolean confirmada;
    private Cliente cliente;
    private Libro libro;

    public Venta(int idVenta, LocalDate fecha, int cantidad,
                 Cliente cliente, Libro libro) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.precioUnitario = 0.0;
        this.confirmada = false;
        this.cliente = cliente;
        this.libro = libro;
    }

    public boolean validarStock() {
        // Esta función validará que exista stock antes de registrar la venta.
        return false;
    }

    public void confirmarVenta() {
        // Esta función confirmará la venta y actualizará el stock del libro.
    }

    public double calcularTotal() {
        // Esta función calculará el importe total de la venta.
        return 0.0;
    }

    // Getters y setters
    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public boolean isConfirmada() {
        return confirmada;
    }

    public void mostrarInfo() {
        System.out.println("\n======================================");
        System.out.println("            DATOS DE LA VENTA");
        System.out.println("======================================");
        System.out.println("ID venta         : " + idVenta);
        System.out.println("Fecha            : " + fecha);
        System.out.println("Cliente          : " + cliente.getNombre());
        System.out.println("Libro            : " + libro.getTitulo());
        System.out.println("Cantidad         : " + cantidad);
        System.out.println("Precio unitario  : S/ " + precioUnitario);
        System.out.println("Confirmada       : " + confirmada);
        System.out.println("======================================");
    }
}
