import java.sql.*;

public class VendaDAO {
    private Connection conexao;

    public VendaDAO(){
        this.conexao = new FabricaCon().criaConexao();
    }
    public void iniciaVenda(Venda venda) throws SQLException{
        String insertVenda = "insert into venda(codvenda, datavenda, desconto, totalvenda, formapagamento, login)"+"values(?,?,?,?,?,?)";
        PreparedStatement stmt = conexao.prepareStatement(insertVenda);
        stmt.setInt(1, venda.getCodvenda());
        stmt.setDate(2, venda.getDataVenda());
        stmt.setDouble(3, venda.getDesconto());
        stmt.setDouble(4, venda.getTotalVenda());
        stmt.execute();
    }
    public void atualizaVenda(int codprod, int quantidade) throws SQLException{
        String updateVenda = "update table venda set qtddcomprada = qtddcomprada - ? where codprod = ?";
        PreparedStatement stmt = conexao.prepareStatement(updateVenda);
        stmt.setInt(1, quantidade);
        stmt.setInt(2, codprod);
        String updateVenda2 = "update table venda set qtdddisponivel = qtdddisponivel - ? and qtddvendida = qtddvendida + ? where codprod = ?";
        PreparedStatement stmt2 = conexao.prepareStatement(updateVenda2);
        stmt2.setInt(1, quantidade);
        stmt2.setInt(2, quantidade);
        stmt2.setInt(3, codprod);

    }
}
