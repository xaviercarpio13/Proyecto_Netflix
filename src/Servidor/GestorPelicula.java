package Servidor;

import SistemaPersistencia.GestorPersistencia;
import Servidor.Pelicula;

public class GestorPelicula {
    private Pelicula pelicula;
    private GestorPersistencia gestorPersistencia;

    public GestorPelicula() {
        pelicula = new Pelicula();
    }

    public GestorPelicula(GestorPersistencia gestorPersistencia) {
        this.gestorPersistencia = gestorPersistencia;
        pelicula = new Pelicula();
    }

    public Pelicula obtenerPelicula(String titulo) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public Pelicula guardarPelicula(Pelicula pelicula) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void eliminarPelicula(String id) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
