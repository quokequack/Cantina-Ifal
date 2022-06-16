import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class DB {
    private Connection conexao;

    public DB(){
        this.conexao = FabricaCon.criaConexao();
    }
    //CRIA AS TABELAS NO BANCO DE DADOS
    public void CriaTabelas() throws SQLException{
        String createProduto = "CREATE TABLE IF NOT EXISTS PRODUTO"+
            "(CODPROD INT(3) PRIMARY KEY,"+
            "NOMEPROD CHAR(40),"+
            "DESCPROD CHAR(40),"+
            "PRECOCOMPRA DECIMAL(5,2),"+
            "PRECOVENDA DECIMAL(5,2),"+
            "QTDDCOMPRADA INT(4),"+
            "QTDDVENDIDA INT(4),"+
            "QTDDDISPONIVEL INT(4))";
        PreparedStatement stmt = conexao.prepareStatement(createProduto);
        stmt.executeUpdate(createProduto);
        String createIndex = "CREATE INDEX IF NOT EXISTS IDX_PRECOVENDA ON PRODUTO (PRECOVENDA)";
        PreparedStatement stmt2 = conexao.prepareStatement(createIndex);
        stmt2.executeUpdate(createIndex);
        String createFunc = "CREATE TABLE IF NOT EXISTS FUNCIONARIO("+
            "LOGIN CHAR(8) PRIMARY KEY,"+
            "NOME CHAR(40),"+
            "SENHA CHAR(8))";
        PreparedStatement stmt3 = conexao.prepareStatement(createFunc);
        stmt3.executeUpdate(createFunc);
        String createVenda = "CREATE TABLE IF NOT EXISTS VENDAS("+
            "CODVENDA INT(5) NOT NULL AUTO_INCREMENT PRIMARY KEY,"+
            "DATAVENDA DATE,"+
            "DESCONTO DECIMAL (4,2),"+
            "TOTALVENDA DECIMAL (5,2),"+
            "FORMAPAGAMENTO CHAR(40),"+
            "LOGIN CHAR(8),"+
            "FOREIGN KEY (LOGIN) REFERENCES FUNCIONARIO (LOGIN))";
        PreparedStatement stmt4 = conexao.prepareStatement(createVenda);
        stmt4.executeUpdate(createVenda);
        String createItemVenda = "CREATE TABLE IF NOT EXISTS ITEM_VENDA("+
            "IDITEM INT(5) NOT NULL AUTO_INCREMENT PRIMARY KEY,"+
            "CODPROD INT(3),"+
            "CODVENDA INT(5),"+
            "QTDD INT(3),"+
            "PRECO DECIMAL(5,2),"+
            "PRECOVENDA DECIMAL(5,2),"+
            "FOREIGN KEY (CODPROD) REFERENCES PRODUTO (CODPROD),"+
            "FOREIGN KEY (CODVENDA) REFERENCES VENDAS (CODVENDA),"+
            "FOREIGN KEY (PRECOVENDA) REFERENCES PRODUTO (PRECOVENDA))";
        PreparedStatement stmt5 = conexao.prepareStatement(createItemVenda);
        stmt5.executeUpdate(createItemVenda);
        String valor = "INSERT INTO FUNCIONARIO (LOGIN, NOME, SENHA)"+"VALUES(?,?,?) ON DUPLICATE KEY UPDATE LOGIN = LOGIN, NOME = NOME, SENHA = SENHA";
        PreparedStatement stmt6 = conexao.prepareStatement(valor);
        stmt6.setString(1, "001");
        stmt6.setString(2, "ADM");
        stmt6.setString(3, "123");
        stmt6.execute();
    }
}
