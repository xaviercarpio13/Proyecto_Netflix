package Servidor;
import java.util.Date;

public class Pelicula {
    private String titulo;
    private String genero;
    private String anio;
    private String productor;
    private float duracion;
    private String Id;

    public Pelicula() {
    }

    public Pelicula(String id,String titulo, String genero, String anio, String productor, float duracion) {
        Id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.anio = anio;
        this.productor = productor;
        this.duracion = duracion;
        
    }
}
