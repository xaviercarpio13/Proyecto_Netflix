package SistemaPersistencia;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Conexion {
    private String url;
    private String driver;
    private Connection conex;
    
    public Conexion(){
        this.driver = "jdbc:sqlite";
        this.url="db_netflix.db";
    }
    
    public void conectar() throws SQLException{
        this.conex=DriverManager.getConnection(this.driver+":"+this.url);
        if(!this.conex.isClosed()){
            //System.out.println("Conexion realizada correctamente");
        } 
    }
    
    public void cerrar() throws SQLException{
        if(!this.conex.isClosed()){
            this.conex.close();
        }
        //System.out.println("Base de datos cerrada");
    }
    
    protected Connection getConexion(){
        return this.conex;
    }
    
    //Para probar base de datos 
    public void ejecutarConsulta(String sql) throws SQLException{
        Statement consulta;
        consulta=conex.createStatement();
        consulta.execute(sql);
        
        ResultSet rs=consulta.executeQuery(sql);
        
    }

    public Connection getConex() {
        return conex;
    }
    
    
}
