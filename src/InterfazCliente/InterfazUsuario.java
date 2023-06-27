package InterfazCliente;

import SistemaPersistencia.GestorPersistencia;
import InterfazCliente.ControladorUsuarioPerfil;
import InterfazCliente.ControladorUsuarioSuscripcion;
import InterfazCliente.Usuario;
import Servidor.Pelicula;
import Servidor.ControladorAudioVideo;
import java.sql.SQLException;
import java.util.ArrayList;

public class InterfazUsuario {

    private ControladorUsuarioSuscripcion constroladorUS;
    private ControladorAudioVideo constroladorAV;
    private Usuario usuario;
    private Pelicula pelicula;
    private ControladorUsuarioPerfil controladorUP;

    public InterfazUsuario() {
    }

    public InterfazUsuario(ControladorUsuarioSuscripcion constroladorUS,
            ControladorAudioVideo constroladorAV, ControladorUsuarioPerfil controladorUP) {
        this.constroladorUS = constroladorUS;
        this.constroladorAV = constroladorAV;
        this.controladorUP = controladorUP;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    
    public Usuario iniciarSesion(String email, String contrasenia) {
        GestorPersistencia gestor = new GestorPersistencia();
        ArrayList respuesta = gestor.buscar(email);

        if (respuesta == null) {
            return null;
        } 
      
        
        if (respuesta.get(3).toString().equals(contrasenia)) {
            Usuario us = new Usuario(respuesta.get(0).toString(), respuesta.get(1).toString(),
            respuesta.get(2).toString(), respuesta.get(3).toString(), respuesta.get(4).toString());
            return us;
        } else {
            System.out.println("Contrasenia no válida");
            return null;
        }
        

    }

    public Pelicula verPelicula(String titulo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
