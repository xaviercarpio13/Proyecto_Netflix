package InterfazCliente;

import Servidor.Suscripcion;
import Servidor.GestorSuscripcion;

public class ControladorUsuarioSuscripcion {
    private GestorSuscripcion gestorSuscripcion;

    public ControladorUsuarioSuscripcion() {
        this.gestorSuscripcion = new GestorSuscripcion();
    }

    public void verificarSuscripcion(String email, String contrasenia) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Suscripcion crearSuscripcion(String email, String contrasenia) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Suscripcion mostrarSuscripcion(String email, String contrasenia) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void cancelarSuscripcion(String email, String contrasenia) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
