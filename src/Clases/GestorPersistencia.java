package Clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import proyecto_netflix.Conexion;

public class GestorPersistencia<T> {

    private ArrayList<T> lista;
    private String nombreArchivo;

    public GestorPersistencia() {
    }

    public GestorPersistencia(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
        lista = new ArrayList<>();
    }

    public void insertar(T objeto) {
        lista.add(objeto);
    }

    public void eliminar(T objeto) {
        lista.remove(objeto);
    }

    public void modificar(T objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ArrayList buscar(String id) {
        try {
            Conexion conexion = new Conexion();
            conexion.conectar();
            Statement consulta;
            consulta = conexion.getConex().createStatement();
            ResultSet resultado = consulta.executeQuery("Select*from Usuarios where email='"+id+"'");
            //ResultSet resultado = consulta.executeQuery("Select*from Usuarios where email='xaviercarpio26@gmail.com'");
            boolean datosEncontrados=false;

            ArrayList datos = new ArrayList();
              
            while (resultado.next()) {
                datosEncontrados=true;
                datos.add(resultado.getString(1));
                datos.add(resultado.getString(2));
                datos.add(resultado.getString(3));
                datos.add(resultado.getString(4));
                datos.add(resultado.getString(5));
            }
            
            if(datosEncontrados){
              return datos;  
            } else{
                return null;
            }
            
        } catch (Exception SQLException) {
            System.out.println("Error en método buscar");
            return null;
        }
    }

    public ArrayList<T> buscarTodos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void guardar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void cargar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
