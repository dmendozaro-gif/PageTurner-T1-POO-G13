package pageturner;

import java.time.LocalDate;

/**
 * Representa la venta de un libro a un cliente.
 * Cada venta corresponde a un cliente y un solo libro.
 */
public class Venta {

    // Atributos de la venta
    private int idVenta;
    private LocalDate fecha;
    private int cantidad;
    private Cliente cliente;
    private Libro libro;

    /**
     * Constructor de la clase Venta.
     */
    public Venta(
            int idVenta,
            LocalDate fecha,
            int cantidad,
            Cliente cliente,
            Libro libro
    ) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.cliente = cliente;
        this.libro = libro;
    }

    /**
     * Verifica que la venta tenga datos válidos
     * y que exista suficiente stock.
     */
    public boolean validarStock() {
        return libro != null
                && cliente != null
                && cantidad > 0
                && libro.tieneStock(cantidad);
    }

    /**
     * Confirma la venta, descuenta el stock y registra
     * la operación en el cliente y el libro.
     */
    public void confirmarVenta() {

        // Evita registrar dos veces la misma venta
        if (cliente != null && cliente.getVentas().contains(this)) {
            throw new IllegalStateException(
                    "La venta ya fue confirmada anteriormente."
            );
        }

        if (!validarStock()) {
            throw new IllegalStateException(
                    "No se puede confirmar la venta: revise el cliente, " +
                            "el libro, la cantidad y el stock disponible."
            );
        }

        // Descuento automático del stock
        libro.descontarStock(cantidad);

        // Registro de la venta en las clases relacionadas
        cliente.agregarVenta(this);
        libro.agregarVenta(this);
    }

    /**
     * Calcula el importe total de la venta.
     */
    public double calcularTotal() {
        if (libro == null) {
            return 0;
        }

        return cantidad * libro.getPrecio();
    }

    // Métodos getters y setters

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
        if (cantidad <= 0) {
            throw new IllegalArgumentException(
                    "La cantidad vendida debe ser mayor que cero."
            );
        }

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

    /**
     * Devuelve un resumen de la venta.
     */
    @Override
    public String toString() {
        return "Venta{" +
                "idVenta=" + idVenta +
                ", fecha=" + fecha +
                ", cantidad=" + cantidad +
                ", cliente=" + cliente.getNombre() +
                ", libro=" + libro.getTitulo() +
                ", total=" + calcularTotal() +
                '}';
    }
}