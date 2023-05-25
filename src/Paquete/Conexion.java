
package Paquete;
import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {
    
    
    private Conexion(){}
    //creamos una variable donde vamos a guardar el estado de nuestra base de datos
    private static Connection conexion;
    
    //ahora creamos una variable para crear una sola instancia
    
    private static Conexion instancia;
    
    //creamos las variaBLES CARACTERISTICAS DE LA BASE DE DATOS
    
    private static final String URL="jdbc:mysql://localhost/bd_registros ";
    private static final String USERNAME ="root"; 
    private static final String PASSWORD = "Wawito29";
    
    public Connection conectar(){
    try{
        Class.forName("com.mysql.cj.jdbc.Driver"); 
        conexion = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    
    
    return conexion;
    
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, "ERROR" +e);
    }
      return conexion;
    }
    
    
    //creamos el metodo para cerrar la conexion
    
    public void cerrarConexion() throws SQLException{
        
        try{
            conexion.close();
            
        }catch(Exception e){
        
        JOptionPane.showMessageDialog(null, "Error : " +e);
             conexion.close();
        }
        finally{conexion.close();}
    
    }


    
    public static Conexion getInstance() {
        if(instancia == null){
            instancia = new Conexion();
        }
        return instancia;
    }


    
}


