package Clases;
import java.util.ArrayList;

public class GestorSuscripcion {
    private ArrayList<Suscripcion> suscripcion;
    private GestorPersistencia gestorPersistencia;

    public GestorSuscripcion() {
        suscripcion = new ArrayList<>();
    }

    public GestorSuscripcion(GestorPersistencia gestorPersistencia) {
        this.gestorPersistencia = gestorPersistencia;
        suscripcion = new ArrayList<>();
    }

    public void cambiarContrasenia(String email, String contrasenia, String nuevaContrasenia){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public Suscripcion cambiarPlan(String email, String contrasenia, String nuevoPlan){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public Suscripcion comprobarSuscripcion(String email, String contrasenia){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public Suscripcion obtenerSuscripcion(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
