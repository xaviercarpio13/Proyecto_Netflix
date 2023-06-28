package Pelicula;
import java.util.ArrayList;

public class ControladorAudioVideo {
    private Pelicula pelicula;
    private GestorPelicula gestorPelicula;

    public ControladorAudioVideo() {
        this.gestorPelicula = new GestorPelicula();
    }

    public ControladorAudioVideo(GestorPelicula gestorPelicula) {
        this.gestorPelicula = gestorPelicula;
    }

    public void crearPelicula(String titulo, String genero, String anio, String productor, float duracion, String path) {
        pelicula = new Pelicula(titulo, genero, anio, productor, duracion, path);
        gestorPelicula.guardarPelicula(pelicula);
    }

    public void proyectarPelicula(String titulo) {

        Pelicula pelicula = gestorPelicula.obtenerPelicula(titulo);
        try {
            Process p = Runtime.getRuntime().exec("C:\\Program Files (x86)\\Windows Media Player\\wmplayer.exe " + pelicula.getPath());
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Error al reproducir la pelicula");
        }
    }

    public ArrayList<String> verListaPeliculas() {
        ArrayList<Pelicula> peliculas = gestorPelicula.obtenerPeliculas(3);
        ArrayList<String> listaPeliculas = new ArrayList<String>();

        for (Pelicula pelicula: peliculas) {
            listaPeliculas.add(pelicula.getTitulo());
        }

        return listaPeliculas;
    }
}

