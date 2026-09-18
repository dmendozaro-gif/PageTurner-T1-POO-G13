package pageturner;

import java.util.ArrayList;
import java.util.Collections;
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


   // Constructor de la clase Cliente.
    public Cliente(int idCliente, String nombre, String dni, String correo) {
        this.idCliente = validarId(idCliente);
        this.nombre = validarTexto(nombre, "El nombre no puede estar vacío.");
        this.dni = validarTexto(dni, "El DNI no puede estar vacío.");
        this.correo = validarCorreo(correo);

        // Las listas se inicializan vacías para evitar valores nulos
        this.ventas = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    // Agrega una venta al historial del cliente.    
    public void agregarVenta(Venta venta) {
        if (venta != null && !ventas.contains(venta)) {
            ventas.add(venta);
        }
    }

    // Agrega una reserva al historial del cliente.
    public void agregarReserva(Reserva reserva) {
        if (reserva != null && !reservas.contains(reserva)) {
            reservas.add(reserva);
        }
    }

    // Métodos getters y setters
    
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = validarId(idCliente);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = validarTexto(nombre, "El nombre no puede estar vacío.");
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = validarTexto(dni, "El DNI no puede estar vacío.");
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = validarCorreo(correo);
    }

    public List<Venta> getVentas() {
        return Collections.unmodifiableList(ventas);
    }

    public List<Reserva> getReservas() {
        return Collections.unmodifiableList(reservas);
    }

    // Función para mostrar los datos principales del cliente.
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

    // Funciones privadas para validar los datos del cliente
    private static int validarId(int idCliente) {
        if (idCliente <= 0) {
            throw new IllegalArgumentException("El identificador del cliente debe ser mayor que cero.");
        }
        return idCliente;
    }

    private static String validarCorreo(String correo) {
        String correoValidado = validarTexto(correo, "El correo no puede estar vacío.");
        if (!correoValidado.contains("@")) {
            throw new IllegalArgumentException("El correo debe contener @.");
        }
        return correoValidado;
    }

    private static String validarTexto(String valor, String mensaje) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(mensaje);
        }
        return valor.trim();
    }
}
