
package proyecto_netflix;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Arrays;

public class Conexion {
    private String url;
    private String driver;
    private Connection conex;
    
    public Conexion(){
        this.driver="jdbc:sqlite";
        this.url="db_netflix.db";
    }
    
    protected void conectar() throws SQLException{
        this.conex=DriverManager.getConnection(this.driver+":"+this.url);
        if(!this.conex.isClosed()){
            System.out.println("Conexion realizada correctamente");
        } 
    }
    
    protected void cerrar() throws SQLException{
        if(!this.conex.isClosed()){
            this.conex.close();
        }
        System.out.println("Base de datos cerrada");
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
        
        
        String datos[]= new String [2];
        
        while(rs.next()){
            datos[0]=rs.getString(1);
            datos[1]=rs.getString(2);
        }
        for (int i = 0; i < datos.length; i++) {
            System.out.println(datos[i]);
        }
        
    }
}
