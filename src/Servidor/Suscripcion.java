package Servidor;

public class Suscripcion {
    private String id;
    private String plan;
    private float precio;
    private String fecha;
    private String emailUsuario;
   

    public Suscripcion() {
    }

    public Suscripcion(String id, String plan, float precio, String fecha, String emailUsuario) {
        id = id;
        this.plan = plan;
        this.precio = precio;
        this.fecha = fecha;
        this.emailUsuario = emailUsuario;
    }
    
    
}
