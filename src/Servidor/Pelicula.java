package Servidor;
import java.util.Date;

public class Pelicula {
    private String titulo;
    private String genero;
    private String anio;
    private String productor;
    private float duracion;
    private String id;
    private String path;

    public Pelicula() {
    }

    public Pelicula(String id,String titulo, String genero, String anio, String productor, float duracion, String path) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.anio = anio;
        this.productor = productor;
        this.duracion = duracion;
        this.path = path;
    }

    public Pelicula(String titulo, String genero, String anio, String productor, float duracion, String path) {
        this.titulo = titulo;
        this.genero = genero;
        this.anio = anio;
        this.productor = productor;
        this.duracion = duracion;
        this.path = path;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public String getAnio() {
        return anio;
    }

    public String getProductor() {
        return productor;
    }

    public float getDuracion() {
        return duracion;
    }

    public String getId() {
        return id;
    }

    public String getPath() {
        return path;
    }
}
