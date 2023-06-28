package InterfazCliente;

import SistemaPersistencia.GestorPersistencia;
import Servidor.Pelicula;

import java.util.ArrayList;

public class InterfazUsuario {

    private ControladorUsuarioSuscripcion constroladorUS;
    private ControladorAudioVideo controladorAV;
    private Usuario usuario;
    private Pelicula pelicula;
    private GestorPersistencia gestor;
    private ControladorUsuarioPerfil controladorUP;

    public InterfazUsuario() {
        this.constroladorUS = new ControladorUsuarioSuscripcion();
        this.controladorAV = new ControladorAudioVideo();
        this.controladorUP = new ControladorUsuarioPerfil();
    }

    public Pelicula getPelicula() {
        return pelicula;
    }
    
    public Usuario iniciarSesion(String email, String contrasenia) {
        this.gestor = new GestorPersistencia();
        ArrayList respuesta = gestor.buscar(email);

        if (respuesta == null) {
            return null;
        } 
    
        if (respuesta.get(3).toString().equals(contrasenia)) {
            Usuario us = new Usuario(respuesta.get(0).toString(), respuesta.get(1).toString(),
            respuesta.get(2).toString(), respuesta.get(3).toString(), respuesta.get(4).toString());
            this.usuario = us;
            return us;
        } else {
            System.out.println("Contrasenia no válida");
            return null;
        }
    }
    
    public void verPelicula(String titulo) {
        controladorAV.proyectarPelicula(titulo);
    }

    public ArrayList<String> verListaPeliculas() {
        return controladorAV.verListaPeliculas();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public GestorPersistencia getGestor() {
        return gestor;
    }
}
