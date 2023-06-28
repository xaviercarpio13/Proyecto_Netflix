package proyecto_netflix;

import InterfazCliente.ControladorAudioVideo;
import Servidor.GestorPelicula;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestMain {
    public static void main(String[] args) {
        ControladorAudioVideo controladorAudioVideo = new ControladorAudioVideo();

        controladorAudioVideo.proyectarPelicula("flores");
    }
}
