import java.sql.*;

public class FabricaCon {
    //ABRE UMA NOVA CONEXÃO COM O BANCO
    public static Connection criaConexao(){
        try{
            return DriverManager.getConnection("jdbc:mysql://localhost/cantinaif","root","");
            
        }catch(SQLException e){
            throw new RuntimeException("A conexão não pôde ser estabelecida. Erro: "+e);
        }
    }
}
