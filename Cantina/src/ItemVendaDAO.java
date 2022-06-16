import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

public class ItemVendaDAO {
    private Connection conexao;

    public ItemVendaDAO(){
        this.conexao = new FabricaCon().criaConexao();
    }
    //ADICIONA NA TABELA ITEMVENDA
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
    //metodo verifica se o produto tem no banco
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
    //ATUALIZA A QUANTIDADE DE ITEM VENDIDO
    public void AtualizaItemVendido(int codprod, int qtdd) throws SQLException{
        String updateVenda2 = "update table produto set qtdddisponivel = qtdddisponivel - ? and qtddvendida = qtddvendida + ? where codprod = ?";
        PreparedStatement stmt2 = conexao.prepareStatement(updateVenda2);
        stmt2.setInt(1, qtdd);
        stmt2.setInt(2, qtdd);
        stmt2.setInt(3, codprod);
    }
    //PESQUISA O PRECO DO ITEM NA TABELA ITEM
    public Double pesquisaPrecoProd(int codprod){
        try{
            String select = "select preco from item_venda where codprod = ?";
            PreparedStatement stmt = conexao.prepareStatement(select);
            stmt.setInt(1, codprod);
            ResultSet resultado = stmt.executeQuery();
            Double preco = 0.0;
            while(resultado.next()){
                preco = resultado.getDouble("preco");
                return preco;
            }
            return preco;
        }catch(SQLException e){
            throw new RuntimeException("Não foi possível realizar consulta. Erro: "+e);
        }
    }
    //FAZ UMA PESQUISA DO ITEM QUE ESTÁ NA VENDA E MULTIPLICA GERANDO O TOTAL DA VENDA, QUE É ARMAZENADO EM UMA VARIÁVEL PARA POSTERIORMENTE SER ASSOCIADO AO TOTAL DA VENDA NA TABELA VENDAS
    public Double totalVenda(int codvenda){
        try{
            String update = "select preco, qtdd from item_venda where codvenda = ?";
            PreparedStatement stmt = conexao.prepareStatement(update);
            stmt.setInt(1, codvenda);
            ResultSet resultado = stmt.executeQuery();
            Double total = 0.0;
            while(resultado.next()){
                total += resultado.getDouble("preco") * resultado.getInt("quantidade");
                return total;
            }
            return total;
        }catch(SQLException e){
            throw new RuntimeException("Não foi possível realizar a consulta. Erro: "+e);
        }
        
    }
    //GUARDA O NOME DE TODOS OS ITENS QUE ESTÃO EM UMA VENDA
    public String itensVenda(int codvenda){
        try{
            String select = "select p.nomeprod from produto p, item_venda i where i.codvenda = p.codvenda and p.codvenda = ?";
            PreparedStatement stmt = conexao.prepareStatement(select);
            stmt.setInt(1, codvenda);
            ResultSet resultado = stmt.executeQuery();
            String nome = "NOMES DOS PRODUTOS:  "+"\n";
            while(resultado.next()){
                nome += resultado.getString("p.nomeprod") + "\n";
                return nome;
            }
            return nome;
        }catch(SQLException e){
            throw new RuntimeException("Não foi possível realizar a consulta. Erro: "+e);
        }

    }
}
