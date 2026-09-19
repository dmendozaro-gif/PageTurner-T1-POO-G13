package pageturner;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa a un cliente de la librería PageTurner.
 */
public class Cliente {

    private int idCliente;
    private String nombre;
    private String dni;
    private String correo;
    private List<Venta> ventas;
    private List<Reserva> reservas;

    public Cliente(int idCliente, String nombre, String dni, String correo) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.dni = dni;
        this.correo = correo;
        this.ventas = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public void agregarVenta(Venta venta) {
        // Esta función agregará una venta al historial del cliente.
    }

    public void agregarReserva(Reserva reserva) {
        // Esta función agregará una reserva al historial del cliente.
    }

    // Getters y setters
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void mostrarInfo() {
        System.out.println("\n======================================");
        System.out.println("          DATOS DEL CLIENTE");
        System.out.println("======================================");
        System.out.println("ID      : " + idCliente);
        System.out.println("Nombre  : " + nombre);
        System.out.println("DNI     : " + dni);
        System.out.println("Correo  : " + correo);
        System.out.println("======================================");
    }
}
