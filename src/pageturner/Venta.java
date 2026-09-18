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
    private double precioUnitario;
    private boolean confirmada;

    // Constructor de la clase Venta.
    public Venta(
            int idVenta,
            LocalDate fecha,
            int cantidad,
            Cliente cliente,
            Libro libro
    ) {

        // Validaciones de los parámetros de entrada
        if (idVenta <= 0) {
            throw new IllegalArgumentException("El identificador de venta debe ser mayor que cero.");
        }
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad vendida debe ser mayor que cero.");
        }
        if (cliente == null || libro == null) {
            throw new IllegalArgumentException("La venta debe tener un cliente y un libro.");
        }

        this.idVenta = idVenta;
        this.fecha = fecha != null ? fecha : LocalDate.now();
        this.cantidad = cantidad;
        this.cliente = cliente;
        this.libro = libro;
        this.precioUnitario = libro.getPrecio();
        this.confirmada = false;
    }

    // Verifica que la venta tenga datos válidos y que exista suficiente stock.
    public boolean validarStock() {
        return libro != null
                && cliente != null
                && cantidad > 0
                && libro.tieneStock(cantidad);
    }

    // Confirma la venta, descuenta el stock y registra la operación en el cliente y el libro.
    public void confirmarVenta() {

        // Evita registrar dos veces la misma venta
        if (confirmada) {
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

        // Se fija el precio vigente al momento de confirmar la venta.
        precioUnitario = libro.getPrecio();

        // Descuento automático del stock
        libro.descontarStock(cantidad);

        // Registro de la venta en las clases relacionadas
        cliente.agregarVenta(this);
        libro.agregarVenta(this);
        confirmada = true;
    }

    // Calcula el importe total de la venta.
    public double calcularTotal() {
        return cantidad * precioUnitario;
    }

    // Métodos getters y setters

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        validarNoConfirmada();
        if (idVenta <= 0) {
            throw new IllegalArgumentException("El identificador de venta debe ser mayor que cero.");
        }
        this.idVenta = idVenta;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        validarNoConfirmada();
        this.fecha = fecha != null ? fecha : LocalDate.now();
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        validarNoConfirmada();
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
        validarNoConfirmada();
        if (cliente == null) {
            throw new IllegalArgumentException("El cliente no puede ser nulo.");
        }
        this.cliente = cliente;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        validarNoConfirmada();
        if (libro == null) {
            throw new IllegalArgumentException("El libro no puede ser nulo.");
        }
        this.libro = libro;
        this.precioUnitario = libro.getPrecio();
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public boolean isConfirmada() {
        return confirmada;
    }

    // Función para mostrar los datos principales de la venta.
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
        System.out.println("Total            : S/ " + calcularTotal());
        System.out.println("Estado           : " + (confirmada ? "CONFIRMADA" : "PENDIENTE"));
        System.out.println("======================================");
    }

    private void validarNoConfirmada() {
        if (confirmada) {
            throw new IllegalStateException("No se puede modificar una venta confirmada.");
        }
    }
}
