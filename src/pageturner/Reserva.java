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
    private static final String ESTADO_ACTIVA = "ACTIVA";
    private static final String ESTADO_CANCELADA = "CANCELADA";
    private static final String ESTADO_ATENDIDA = "ATENDIDA";

    private String estado;
    private Cliente cliente;
    private Libro libro;
    private boolean registrada;

    /**
     * Constructor de la clase Reserva.
     * El estado inicial de toda reserva es ACTIVA.
     */
    public Reserva(int idReserva, Cliente cliente, Libro libro) {
        
        // Validaciones de los parámetros de entrada
        if (idReserva <= 0) {
            throw new IllegalArgumentException("El identificador de reserva debe ser mayor que cero.");
        }
        if (cliente == null || libro == null) {
            throw new IllegalArgumentException("La reserva debe tener un cliente y un libro.");
        }
        this.idReserva = idReserva;
        this.fecha = LocalDate.now();
        this.estado = ESTADO_ACTIVA;
        this.cliente = cliente;
        this.libro = libro;
        this.registrada = false;
    }

    // Registra la reserva cuando el libro no tiene stock.
    public void registrar() {

        // Solo se permite reservar un libro sin stock
        if (libro.getStock() > 0) {
            throw new IllegalStateException(
                    "No se puede reservar porque el libro tiene stock disponible."
            );
        }

        // Evita registrar dos veces la misma reserva
        if (registrada) {
            throw new IllegalStateException(
                    "La reserva ya fue registrada anteriormente."
            );
        }

        cliente.agregarReserva(this);
        libro.agregarReserva(this);

        estado = ESTADO_ACTIVA;
        registrada = true;
    }

    // Cambia el estado de la reserva a CANCELADA.
    public void cancelar() {
        validarActiva();
        estado = ESTADO_CANCELADA;
    }

    // Cambia el estado de la reserva a ATENDIDA.
    public void marcarAtendida() {
        validarActiva();
        estado = ESTADO_ATENDIDA;
    }

    // Métodos getters y setters

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        if (registrada) {
            throw new IllegalStateException("No se puede modificar una reserva registrada.");
        }
        if (idReserva <= 0) {
            throw new IllegalArgumentException("El identificador de reserva debe ser mayor que cero.");
        }
        this.idReserva = idReserva;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Libro getLibro() {
        return libro;
    }

    // Función para mostrar los datos de la reserva.
    public void mostrarInfo() {
        System.out.println("\n======================================");
        System.out.println("           DATOS DE LA RESERVA");
        System.out.println("======================================");
        System.out.println("ID reserva : " + idReserva);
        System.out.println("Fecha      : " + fecha);
        System.out.println("Cliente    : " + cliente.getNombre());
        System.out.println("Libro      : " + libro.getTitulo());
        System.out.println("Estado     : " + estado);
        System.out.println("======================================");
    }

    private void validarActiva() {
        if (!registrada) {
            throw new IllegalStateException("La reserva debe registrarse antes de cambiar su estado.");
        }
        if (!ESTADO_ACTIVA.equals(estado)) {
            throw new IllegalStateException("Solo una reserva activa puede cambiar de estado.");
        }
    }
}
