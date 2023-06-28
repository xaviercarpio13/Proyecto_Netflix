package InterfazCliente;

import InterfazCliente.Usuario;
import InterfazCliente.Perfil;
import Servidor.GestorPerfil;

public class ControladorUsuarioPerfil {
    private GestorPerfil gestorPerfil;

    public ControladorUsuarioPerfil() {
        this.gestorPerfil = new GestorPerfil();
    }

    public Perfil crearPerfil(Usuario usuario, String nombre, Integer restriccion) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public Perfil mostrarPerfil(Usuario usuario, String nombre) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
