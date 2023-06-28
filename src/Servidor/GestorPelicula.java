package Servidor;
import java.sql.ResultSet;

import SistemaPersistencia.GestorPersistencia;
import java.util.UUID;

public class GestorPelicula {
    private Pelicula pelicula;
    private GestorPersistencia gestorPersistencia;

    public GestorPelicula() {
        gestorPersistencia = new GestorPersistencia();
        pelicula = new Pelicula();
    }

    public GestorPelicula(GestorPersistencia gestorPersistencia) {
        this.gestorPersistencia = gestorPersistencia;
        pelicula = new Pelicula();
    }

    public Pelicula guardarPelicula(Pelicula pelicula) {
        String id = UUID.randomUUID().toString();
        String titulo = pelicula.getTitulo();
        String genero = pelicula.getGenero();
        String anio = pelicula.getAnio();
        String productor = pelicula.getProductor();
        float duracion = pelicula.getDuracion();
        String path = pelicula.getPath();

        String query = "INSERT INTO pelicula (id, titulo, genero, anio, productor, duracion, path) VALUES ('"+id+"', '"+titulo+"', '"+genero+"', '"+anio+"', '"+productor+"', '"+duracion+"', '"+path+"')";
        gestorPersistencia.insertar(query);

        return new Pelicula(
            id,
            titulo,
            genero,
            anio,
            productor,
            duracion,
            path
        );
    }

    public Pelicula obtenerPelicula(String titulo){
        String query = "SELECT * FROM Peliculas WHERE titulo like '%"+titulo+"%'";
        ResultSet result = gestorPersistencia.obtener(query);
        try {
            String id = result.getString("id");
            String genero = result.getString("genero");
            String anio = result.getString("anio");
            String productor = result.getString("productor");
            float duracion = result.getFloat("duracion");
            String path = result.getString("path");

            return new Pelicula(
                id,
                titulo,
                genero,
                anio,
                productor,
                duracion,
                path
            );
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new Pelicula();
    }

    public void eliminarPelicula(String id) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
