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
    public void atualizaVenda(int codprod, Double totalVenda) throws SQLException{
        String updateVenda = "update table venda set totalvenda = ?  where codprod = ?";
        PreparedStatement stmt = conexao.prepareStatement(updateVenda);
        stmt.setDouble(1, totalVenda);
        stmt.setInt(2, codprod);

    }
    List<Venda> codigosVendas = new ArrayList<>();

    public void selecionaVenda() throws SQLException{
        String selectVenda = "select codvenda from venda";
        PreparedStatement stmt = conexao.prepareStatement(selectVenda);
        ResultSet resultado = stmt.executeQuery(selectVenda);
        while(resultado.next()){
            codigosVendas.addAll((Collection<? extends Venda>) resultado);
        }
    }
}
