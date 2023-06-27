package Servidor;
import InterfazCliente.Usuario;
import SistemaPersistencia.GestorPersistencia;
import java.util.ArrayList;

public class GestorSuscripcion {
    private Usuario usuario;
    private ArrayList<Suscripcion> suscripcion;


    public GestorSuscripcion(Usuario us) {
        this.usuario=us;

    }
    
    
    public void cambiarContrasenia(String contrasenia, String nuevaContrasenia){
            
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
