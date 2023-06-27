package Clases;
import java.util.Date;

public class Pelicula {
    private String titulo;
    private String genero;
    private Date anio;
    private String productor;
    private float duracion;
    private String Id;

    public Pelicula() {
    }

    public Pelicula(String titulo, String genero, Date anio, String productor, float duracion, String id) {
        this.titulo = titulo;
        this.genero = genero;
        this.anio = anio;
        this.productor = productor;
        this.duracion = duracion;
        Id = id;
    }
}
