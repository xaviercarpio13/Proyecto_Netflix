import java.util.ArrayList;

public class GestorPerfil {
    private ArrayList<Perfil> perfil;
    private GestorPersistencia gestorPersistencia;

    public GestorPerfil() {
        perfil = new ArrayList<Perfil>();
    }
    public GestorPerfil(GestorPersistencia gestorPersistencia) {
        this.gestorPersistencia = gestorPersistencia;
        this.perfil = new ArrayList<Perfil>();
    }

    public Perfil crearPerfil(Perfil perfil) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public Perfil mostrarPerfil(Usuario usuario, String nombre) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void editatRestriccion(Integer restriccion) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
