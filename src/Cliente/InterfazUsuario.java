package Cliente;

import Pelicula.ControladorAudioVideo;
import SistemaPersistencia.GestorPersistencia;
import Pelicula.Pelicula;

import java.util.ArrayList;

public class InterfazUsuario {

    private ControladorAudioVideo controladorAV;
    private Usuario usuario;
    private Pelicula pelicula;
    private GestorPersistencia gestor;

    public InterfazUsuario() {
        this.controladorAV = new ControladorAudioVideo();
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
