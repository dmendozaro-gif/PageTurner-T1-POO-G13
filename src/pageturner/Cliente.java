package pageturner;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa a un cliente de la librería PageTurner.
 * Un cliente puede realizar varias compras y reservas.
 */
public class Cliente {

    // Atributos del cliente
    private int idCliente;
    private String nombre;
    private String dni;
    private String correo;

    // Listas que almacenan las ventas y reservas del cliente
    private List<Venta> ventas;
    private List<Reserva> reservas;

    /**
     * Constructor de la clase Cliente.
     */
    public Cliente(int idCliente, String nombre, String dni, String correo) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.dni = dni;
        this.correo = correo;

        // Las listas se inicializan vacías para evitar valores nulos
        this.ventas = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    /**
     * Agrega una venta al historial del cliente.
     */
    public void agregarVenta(Venta venta) {
        if (venta != null) {
            ventas.add(venta);
        }
    }

    /**
     * Agrega una reserva al historial del cliente.
     */
    public void agregarReserva(Reserva reserva) {
        if (reserva != null) {
            reservas.add(reserva);
        }
    }

    // Métodos getters y setters

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

    /**
     * Devuelve los datos principales del cliente.
     */
    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }
}
