package Cliente;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import SistemaPersistencia.Conexion;

public class Usuario {

    private String id;
    private String name;
    private String email;
    private String contrasenia;
    private String fechaNacimiento;
    private ArrayList <ArrayList<String>> perfiles;

    public Usuario() {
    }

    public Usuario(String id, String name, String email, String contrasenia, String fechaNacimiento) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.contrasenia = contrasenia;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getContrasenia() {
        return contrasenia;
    }
    
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void crearUsuario(String id, String name, String email, String contrasenia, String fechaNacimiento) {
        try {
            Conexion conexion = new Conexion();
            conexion.conectar();
            Statement consulta;
            consulta = conexion.getConex().createStatement();
            consulta.execute("INSERT INTO Usuarios (id, nombre, email, password, fechaNacimiento) VALUES ('" + id + "', '" + name + "', '" + email + "', '" + contrasenia + "', '" + fechaNacimiento + "')");

            System.out.println("Usuario guardado con exito");
            conexion.cerrar();
        } catch (Exception SQLException) {
            System.out.println("Error al guardar usuario");
        }
    }

    public ArrayList obtenerPerfiles() {
        try {
            Conexion conexion = new Conexion();
            conexion.conectar();
            Statement consulta;
            Statement consulta2;
            consulta = conexion.getConex().createStatement();
            consulta2 = conexion.getConex().createStatement();

            ResultSet resultado = consulta.executeQuery("SELECT * FROM Perfil WHERE idUSuario='" + id + "'");
            ResultSet cantidad = consulta2.executeQuery("SELECT COUNT(*) FROM Perfil WHERE idUSuario='" + id + "'");

            int numPerfiles = 0;
            if (cantidad.next()) {
                numPerfiles = cantidad.getInt(1);
            }

            boolean datosEncontrados = false;

            ArrayList<ArrayList<String>> perfiles = new ArrayList<>(numPerfiles);

            while (resultado.next()) {
                ArrayList<String> fila = new ArrayList<>();
                fila.add(resultado.getString(1));
                fila.add(resultado.getString(2));
                fila.add(resultado.getString(3));
                fila.add(resultado.getString(4));
                perfiles.add(fila);
                datosEncontrados = true;
            }
            if (datosEncontrados) {
                this.perfiles = perfiles;
                conexion.cerrar();
                return perfiles;
            } else {
                conexion.cerrar();
                return null;
            }
            
        } catch (Exception SQLException) {
            System.out.println("Error al obtener perfiles");
            return null;
        }
    }

    public String getNombrePerfil(int index) {
        return perfiles.get(index).get(1);
    }
    
}
