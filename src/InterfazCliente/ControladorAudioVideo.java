/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InterfazCliente;

import Servidor.GestorPelicula;
import Servidor.Pelicula;

import java.io.File;
import java.util.ArrayList;

/**
 * @author juanf
 */

public class ControladorAudioVideo {
    private String idioma;
    private String subtitulos;
    private Pelicula pelicula;
    private GestorPelicula gestorPelicula;

    public ControladorAudioVideo() {
        this.gestorPelicula = new GestorPelicula();
    }

    public ControladorAudioVideo(String idioma, String subtitulos, GestorPelicula gestorPelicula) {
        this.idioma = idioma;
        this.subtitulos = subtitulos;
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

    public void decargarPelicula(String titulo) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}

