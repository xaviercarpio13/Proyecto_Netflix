public class InterfazUsuario {

    private ControladorUsuarioSuscripcion constroladorUS;
    private ControladorAudioVideo constroladorAV;
    private Usuario usuario ;
    private  Pelicula pelicula;
    private ControladorUsuarioPerfil controladorUP;
    public InterfazUsuario() {
    }

    public InterfazUsuario(ControladorUsuarioSuscripcion constroladorUS, ControladorAudioVideo constroladorAV, ControladorUsuarioPerfil controladorUP) {
        this.constroladorUS = constroladorUS;
        this.constroladorAV = constroladorAV;
        this.controladorUP = controladorUP;
    }

    public Usuario iniciarSesion(String email, String contrasenia) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Pelicula verPelicula(String titulo){
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
