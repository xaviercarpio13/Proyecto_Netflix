package Cliente;

import java.sql.Statement;
import SistemaPersistencia.Conexion;
import java.sql.SQLException;

public class Perfil {
    private String nombre;
    private Integer restriccion;
    private String idUsuario;
    private String Id;

    public Perfil() {
    }

    public Perfil(String id,String nombre, Integer restriccion,String idUsuario){
        Id = id;
        this.nombre = nombre;
        this.restriccion = restriccion;
        this.idUsuario = idUsuario;

    }

    public String getNombre() {
        return nombre;
    }

    public Integer getRestriccion() {
        return restriccion;
    }
    
    public String getIdUsuario() {
        return idUsuario;
    }

    public String getId() {
        return Id;
    }
    
    public void crearPerfil(String id,String nombre, Integer restriccion){
         try {
             
            Conexion conexion = new Conexion();
            conexion.conectar();
            Statement consulta;
            consulta = conexion.getConex().createStatement();

            consulta.execute("INSERT INTO Perfil (id, nombre, restriccion, idUsuario) VALUES ('"+id+"', '"+nombre+"', '"+restriccion+"', '"+this.idUsuario+"')"); 
           
            System.out.println("Usuario perfil con exito");
            conexion.cerrar();
        } catch (SQLException e) {
            System.out.println("Error al guardar perfil "+e.getMessage());
        }
    }
    
}
