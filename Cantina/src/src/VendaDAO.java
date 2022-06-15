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
    public void iniciaVenda(Venda venda) throws SQLException{
        String insertVenda = "insert into venda(datavenda, desconto, totalvenda, formapagamento, login)"+"values(?,?,?,?,?)";
        PreparedStatement stmt = conexao.prepareStatement(insertVenda);
        java.sql.Date data = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
        venda.setDataVenda(data);
        stmt.setDate(1, venda.getDataVenda());
        stmt.setDouble(2, venda.getDesconto());
        stmt.setDouble(3, venda.getTotalVenda());
        stmt.setString(4, venda.getCodFunc());
        stmt.execute();
    }
    public void atualizaVenda(int codvenda, Double totalVenda) throws SQLException{
        String updateVenda = "update table venda set totalvenda = ?  where codvenda = ?";
        PreparedStatement stmt = conexao.prepareStatement(updateVenda);
        stmt.setDouble(1, totalVenda);
        stmt.setInt(2, codvenda);

    }
    public int selecionaVenda(int iditem){
        try{
            String selectVenda = "select codvenda from item_venda where iditem = ?";
            PreparedStatement stmt = conexao.prepareStatement(selectVenda);
            stmt.setInt(1, iditem);
            ResultSet resultado = stmt.executeQuery(selectVenda);
            int codvenda = 0;
            while(resultado.next()){
               codvenda = resultado.getInt("codvenda");
               return codvenda;
            }
            return codvenda;
        }catch(SQLException e){
           throw new RuntimeException("Não foi possível realizar a consulta. Erro: "+e);
        }
    }

}
