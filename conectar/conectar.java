package conectar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;



/**
 *
 * @author fliza
 */
public class conectar {
    Connection con=null;
    String url="jdbc:mysql://db4free.net:3306/almacenitlafinal";
    String us = "estuditlafinal";
    String pass= "itla123.";
    
    public  conectar(){
        
        
     
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url,us,pass);
            System.out.println("Conexion establecida");
       
        } catch (Exception  e) {
            System.out.println("Error de conexion"+e);
        }
       
    }
    
    public int ejecutarsentenciaSQL(String strSentenciaSQL){
        try{
           PreparedStatement pstm= con.prepareStatement(strSentenciaSQL);
           pstm.execute();
           return 1;
            
        }catch(SQLException e){
            System.out.println(e);
            return 0;
            
            
        }
    }
        
        public ResultSet consultarRegistros(String strSentenciaSQL){
            try{
            PreparedStatement pstm= con.prepareStatement(strSentenciaSQL);
          ResultSet respuesta= pstm.executeQuery();
            return respuesta;
        }catch(Exception  e){
            System.out.println(e);
            return null;
        }
    }
    
    
}
  


    

    

