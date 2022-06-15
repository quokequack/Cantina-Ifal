import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DB {
    private Connection conexao;

    public DB(){
        this.conexao = FabricaCon.criaConexao();
    }
    public void CriaTabelas() throws SQLException{
        String createProduto = "CREATE TABLE PRODUTO"+
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
        String createIndex = "CREATE INDEX IDX_PRECOVENDA ON PRODUTO (PRECOVENDA)";
        PreparedStatement stmt2 = conexao.prepareStatement(createIndex);
        stmt2.executeUpdate(createIndex);
        String createFunc = "CREATE TABLE FUNCIONARIO("+
            "LOGIN CHAR(8) PRIMARY KEY,"+
            "NOME CHAR(40),"+
            "SENHA CHAR(8))";
        PreparedStatement stmt3 = conexao.prepareStatement(createFunc);
        stmt3.executeUpdate(createFunc);
        String createVenda = "CREATE TABLE VENDAS("+
            "CODVENDA INT(5) NOT NULL AUTO_INCREMENT PRIMARY KEY,"+
            "DATAVENDA DATE,"+
            "DESCONTO DECIMAL (4,2),"+
            "TOTALVENDA DECIMAL (5,2),"+
            "FORMAPAGAMENTO CHAR(40),"+
            "LOGIN CHAR(8),"+
            "FOREIGN KEY (LOGIN) REFERENCES FUNCIONARIO (LOGIN))";
        PreparedStatement stmt4 = conexao.prepareStatement(createVenda);
        stmt4.executeUpdate(createVenda);
        String createItemVenda = "CREATE TABLE ITEM_VENDA("+
            "IDITEM INT(5) PRIMARY KEY,"+
            "CODPROD INT(3),"+
            "CODVENDA INT(5),"+
            "QTDD INT(3),"+
            "PRECO DECIMAL(5,2),"+
            "PRECOVENDA DECIMAL(5,2),"+
            "FOREIGN KEY (CODPROD) REFERENCES PRODUTO(CODPROD),"+
            "FOREIGN KEY (CODVENDA) REFERENCES VENDAS (CODVENDA),"+
            "FOREIGN KEY (PRECOVENDA) REFERENCES PRODUTO (PRECOVENDA))";
        PreparedStatement stmt5 = conexao.prepareStatement(createItemVenda);
        stmt5.executeUpdate(createItemVenda);
        /*
        String addRest1 = "ALTER TABLE ITEM_VENDA ADD CONSTRAINT FK_COD_PROD FOREIGN KEY (CODPROD) REFERENCES PRODUTO(CODPROD)";
        PreparedStatement stmt6 = conexao.prepareStatement(addRest1);
        stmt6.executeUpdate(addRest1);
        String addRest2 = "ALTER TABLE ITEM_VENDA ADD CONSTRAINT FK _CODVENDA FOREIGN KEY (CODVENDA) REFERENCES VENDA (CODVENDA)";
        PreparedStatement stmt7 = conexao.prepareStatement(addRest2);
        stmt7.executeUpdate(addRest2);
        String addRest3 = "ALTER TABLE ITEM_VENDA ADD CONSTRAINT FK_PRECO_VENDA FOREIGN KEY (PRECOVENDA) REFERENCES PRODUTO (PRECOVENDA)";
        PreparedStatement stmt8 = conexao.prepareStatement(addRest3);
        stmt8.executeUpdate(addRest3);*/

    }
}
