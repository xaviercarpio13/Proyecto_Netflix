package SistemaPersistencia;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.SQLException;

public class GestorPersistencia<T> {

    private ArrayList<T> lista;
    private String nombreArchivo;

    private Conexion conexion;

    public GestorPersistencia() {
        conexion = new Conexion();
    }

    public GestorPersistencia(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
        lista = new ArrayList<>();
        conexion = new Conexion();
    }
    
    public void insertar(String query){
        try{
            conexion.conectar();
            Statement consulta;
            consulta = conexion.getConex().createStatement();
            consulta.executeUpdate(query);
        }catch (Exception SQLException) {
//            System.out.println("Error al cambiar la contrasenia");
            System.out.println(SQLException.getMessage());
        }
    }

    public ResultSet obtener(String query){
        try{
            conexion.conectar();
            Statement consulta;
            consulta = conexion.getConex().createStatement();
            ResultSet resultado = consulta.executeQuery(query);
            return resultado;
        }catch (Exception SQLException) {
            System.out.println(SQLException.getMessage());
        }
        return null;
    }

    public void eliminar(String query) {
        try{
            conexion.conectar();
            Statement consulta;
            consulta = conexion.getConex().createStatement();
            consulta.executeUpdate(query);
        }catch (Exception SQLException) {
            System.out.println("Error al cambiar la contrasenia");
        }
    }

    public void actualizar(String tabla, String columna, String id, String nuevoAtributo) {
        try {
            Conexion conexion = new Conexion();
            conexion.conectar();
            Statement consulta;
            consulta = conexion.getConex().createStatement();
            consulta.executeUpdate("Update '"+tabla+"' set '"+columna+"' = '" + nuevoAtributo
                    + "' where id='" + id + "'");
            System.out.println("Dato cambiado cambiada correctamente");

        } catch (SQLException e) {
            System.out.println("Error al cambiar la contrasenia");
        }
    }

    public ArrayList buscar(String id) {
        try {
            Conexion conexion = new Conexion();
            conexion.conectar();
            Statement consulta;
            consulta = conexion.getConex().createStatement();
            ResultSet resultado = consulta.executeQuery("Select * from Usuarios where email='" + id + "'");
            //ResultSet resultado = consulta.executeQuery("Select*from Usuarios where email='xaviercarpio26@gmail.com'");
            boolean datosEncontrados = false;

            ArrayList datos = new ArrayList();

            while (resultado.next()) {
                datosEncontrados = true;
                datos.add(resultado.getString(1));
                datos.add(resultado.getString(2));
                datos.add(resultado.getString(3));
                datos.add(resultado.getString(4));
                datos.add(resultado.getString(5));
            }

            if (datosEncontrados) {
                conexion.cerrar();
                return datos;
            } else {
                conexion.cerrar();
                return null;
            }

        } catch (Exception SQLException) {
            System.out.println("Error en método buscar");
            return null;
        }
    }
}
