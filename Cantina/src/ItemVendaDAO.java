import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemVendaDAO {
    private Connection conexao;

    public ItemVendaDAO(){
        this.conexao = new FabricaCon().criaConexao();
    }
    public void adicionaItemVenda(ItemVenda itemVenda) throws SQLException{
        String insertItem = "insert into item_venda (iditem, codprod, codvenda, qtdd, preco)"+"values(?,?,?,?,?)";
        PreparedStatement stmt = conexao.prepareStatement(insertItem);
        stmt.setInt(1, itemVenda.getCodVenda());
        stmt.setInt(2, itemVenda.getCodproduto());
        stmt.setInt(3, itemVenda.getCodVenda());
        stmt.setInt(4, itemVenda.getQtdd());
        stmt.setDouble(5, itemVenda.getPreco());
        stmt.execute();
    }
    //metodo verifica se tem no banco
    public void verificaBanco(int codprod) throws SQLException{
        try{
            String select = "select nomeprod from produto where codprod = ? and qtdddisponivel > 0";
            PreparedStatement stmt7 = conexao.prepareStatement(select);
            stmt7.setInt(1, codprod);
            ResultSet resultado6 = stmt7.executeQuery();
            while(resultado6.next()){
                String produtoVnd = resultado6.getString("nomeprod");
                System.out.println("O produto que quer vender é: "+produtoVnd);
            }
        }catch(SQLException e){
            System.out.println("Não foi possível fazer a verificação. Erro: "+e);
        }
    }
    public void AtualizaItemVendido(int codprod, int qtdd) throws SQLException{
        String updateVenda2 = "update table produto set qtdddisponivel = qtdddisponivel - ? and qtddvendida = qtddvendida + ? where codprod = ?";
        PreparedStatement stmt2 = conexao.prepareStatement(updateVenda2);
        stmt2.setInt(1, qtdd);
        stmt2.setInt(2, qtdd);
        stmt2.setInt(3, codprod);
    }
}
