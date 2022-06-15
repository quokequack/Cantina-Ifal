import java.sql.*;

public class FabricaCon {
    
    public static Connection criaConexao(){
        try{
            return DriverManager.getConnection("jdbc:mysql://localhost/cantinaifal","root","");
            
        }catch(SQLException e){
            throw new RuntimeException("A conexão não pôde ser estabelecida. Erro: "+e);
        }
    }
}
