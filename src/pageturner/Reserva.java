package pageturner;

import java.time.LocalDate;

/**
 * Representa la reserva de un libro sin stock.
 */
public class Reserva {

    private int idReserva;
    private LocalDate fecha;
    private String estado;
    private boolean registrada;
    private Cliente cliente;
    private Libro libro;

    public Reserva(int idReserva, Cliente cliente, Libro libro) {
        this.idReserva = idReserva;
        this.fecha = LocalDate.now();
        this.estado = "ACTIVA";
        this.registrada = false;
        this.cliente = cliente;
        this.libro = libro;
    }

    public void registrar() {
        // Esta función registrará una reserva para un libro sin stock
        // y cambiará el atributo registrada a true.
    }

    public void cancelar() {
        // Esta función cambiará el estado de la reserva a CANCELADA.
    }

    public void marcarAtendida() {
        // Esta función cambiará el estado de la reserva a ATENDIDA.
    }

    // Getters y setters
    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
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
}
