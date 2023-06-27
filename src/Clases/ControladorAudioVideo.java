public class ControladorAudioVideo {
    private String idioma;
    private String subtitulos;
    private Pelicula pelicula;

    private GestorPelicula gestorPelicula;

    public ControladorAudioVideo() {
    }

    public ControladorAudioVideo(String idioma, String subtitulos, GestorPelicula gestorPelicula) {
        this.idioma = idioma;
        this.subtitulos = subtitulos;
        this.gestorPelicula = gestorPelicula;
    }
    public Pelicula obtenerPelicula(String titulo) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    public void decargarPelicula(String titulo) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
