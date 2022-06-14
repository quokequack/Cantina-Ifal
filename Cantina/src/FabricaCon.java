import java.sql.*;

public class FabricaCon {
    
    public static Connection criaConexao(){
        try{
            return DriverManager.getConnection("jdbc:mysql://localhost:3360/cantinaifal","root","");
            
        }catch(SQLException e){
            throw new RuntimeException("A conexão não pôde ser estabelecida. Erro: "+e);
        }
    }
}
