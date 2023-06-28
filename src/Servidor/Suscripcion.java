package Servidor;

import java.sql.Statement;
import proyecto_netflix.Conexion;

public class Suscripcion {
    private String id;
    private String plan;
    private float precio;
    private String fecha;
    private String emailUsuario;
   

    public Suscripcion() {
    }

    public Suscripcion(String id, String plan, float precio, String fecha, String emailUsuario) {
        this.id = id;
        this.plan = plan;
        this.precio = precio;
        this.fecha = fecha;
        this.emailUsuario = emailUsuario;
    }
    
    public void crearSuscripcion(String id, String plan, float precio, String fechaContratacion, String idUsuario){   
        try {
            Conexion conexion = new Conexion();
            conexion.conectar();
            Statement consulta;
            consulta = conexion.getConex().createStatement();
            consulta.executeUpdate("INSERT INTO Suscripcion (id, plan, precio, fechaContratacion, idUsuario) VALUES ('"+id+"', '"+plan+"', "+precio+", '"+fechaContratacion+"', '"+idUsuario+"')"); 
            System.out.println("Suscripcion guardada con exito");
            
        } catch (Exception SQLException) {
            System.out.println("Error al guardar la suscripcion");
        }
    }
    
    
}
