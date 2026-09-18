package pageturner;

import java.time.LocalDate;

/**
 * Representa la reserva de un libro sin stock.
 * Cada reserva corresponde a un cliente y un libro.
 */
public class Reserva {

    // Atributos de la reserva
    private int idReserva;
    private LocalDate fecha;
    private String estado;
    private Cliente cliente;
    private Libro libro;

    /**
     * Constructor de la clase Reserva.
     * El estado inicial de toda reserva es ACTIVA.
     */
    public Reserva(
            int idReserva,
            LocalDate fecha,
            Cliente cliente,
            Libro libro
    ) {
        this.idReserva = idReserva;

        // Si no se proporciona una fecha, se utiliza la fecha actual
        this.fecha = fecha != null ? fecha : LocalDate.now();

        this.estado = "ACTIVA";
        this.cliente = cliente;
        this.libro = libro;
    }

    /**
     * Registra la reserva cuando el libro no tiene stock.
     */
    public void registrar() {

        if (cliente == null || libro == null) {
            throw new IllegalStateException(
                    "La reserva debe tener un cliente y un libro."
            );
        }

        // Solo se permite reservar un libro sin stock
        if (libro.getStock() > 0) {
            throw new IllegalStateException(
                    "No se puede reservar porque el libro tiene stock disponible."
            );
        }

        // Evita registrar dos veces la misma reserva
        if (cliente.getReservas().contains(this)) {
            throw new IllegalStateException(
                    "La reserva ya fue registrada anteriormente."
            );
        }

        cliente.agregarReserva(this);
        libro.agregarReserva(this);

        estado = "ACTIVA";
    }

    /**
     * Cambia el estado de la reserva a CANCELADA.
     */
    public void cancelar() {
        estado = "CANCELADA";
    }

    /**
     * Cambia el estado de la reserva a ATENDIDA.
     */
    public void marcarAtendida() {
        estado = "ATENDIDA";
    }

    // Métodos getters y setters

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
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
     * Devuelve un resumen de la reserva.
     */
    @Override
    public String toString() {
        return "Reserva{" +
                "idReserva=" + idReserva +
                ", fecha=" + fecha +
                ", estado='" + estado + '\'' +
                ", cliente=" + cliente.getNombre() +
                ", libro=" + libro.getTitulo() +
                '}';
    }
}