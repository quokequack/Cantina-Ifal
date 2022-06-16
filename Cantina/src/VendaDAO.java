import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

public class VendaDAO {
    private Connection conexao;

    public VendaDAO(){
        this.conexao = new FabricaCon().criaConexao();
    }
    //INICIALIZA A VENDA
    public void iniciaVenda(Venda venda) throws SQLException{
        String insertVenda = "insert into vendas (datavenda, desconto, formapagamento, login)"+"values(?,?,?,?)";
        PreparedStatement stmt = conexao.prepareStatement(insertVenda);
        java.sql.Date data = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
        venda.setDataVenda(data);
        stmt.setDate(1, venda.getDataVenda());
        stmt.setDouble(2, venda.getDesconto());
        stmt.setString(3, venda.getFormaPagamento());
        stmt.setString(4, venda.getCodFunc());
        stmt.execute();
    }
    //ATUALIZA O VALOR TOTAL DA VENDA NA TABELA VENDAS
    public void atualizaVenda(int codvenda, Double totalVenda) throws SQLException{
        String updateVenda = "update table vendas set totalvenda = ?  where codvenda = ?";
        PreparedStatement stmt = conexao.prepareStatement(updateVenda);
        stmt.setDouble(1, totalVenda);
        stmt.setInt(2, codvenda);
        stmt.executeUpdate();

    }
    //SELECIONA O CODIGO DE VENDA, QUE É AUTO INCREMENT
    public int selecionaVenda(int codprod){
        try{
            String selectVenda = "SELECT V.CODVENDA FROM ITEM_VENDA I, VENDAS V, PRODUTOS P WHERE I.CODPROD = P.CODPROD AND P.CODPROD = ?";
            PreparedStatement stmt = conexao.prepareStatement(selectVenda);
            stmt.setInt(1, codprod);
            ResultSet resultado = stmt.executeQuery(selectVenda);
            int codvenda = 0;
            while(resultado.next()){
               codvenda = resultado.getInt("codvenda");
            }
            return codvenda;
        }catch(SQLException e){
           throw new RuntimeException("Não foi possível realizar a consulta. Erro: "+e);
        }
    }

}
