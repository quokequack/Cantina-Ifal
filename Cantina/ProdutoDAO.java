import java.sql.*;

public class ProdutoDAO {
    private Connection conexao;

    public ProdutoDAO(){
        this.conexao = FabricaCon.criaConexao();
    }

    public void adiciona(Produto produto) throws SQLException{
        String sql = "insert into Produto"+"(codProd, nomeProd, descProd, precoCompra, precoVenda, qtddComprada)"+"values(?,?,?,?,?,?,?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        int codProd = produto.getCodigoProduto();
        String nomeProd = produto.getNome();
        String descProd = produto.getDescricao();
        Double precoCompra = produto.getPrecoDeCompra();
        Double precoVenda = produto.getPrecoDeVenda();
        int qtddComprada = produto.getQuantidadeComprada();

        stmt.setInt(1, codProd);
        stmt.setString(2, nomeProd);
        stmt.setString(3, descProd);
        stmt.setDouble(4, precoCompra);
        stmt.setDouble(5, precoVenda);
        stmt.setInt(6, qtddComprada);
        stmt.execute();
    
    }
    public void atualizaQtdd(Produto produto){
        try{
            String sql2 = "update Produto set qtddDisponivel = quantidadeDisponivelNoProduto and qtddVendida = quantidadeVendida where nomeProd = nomeProduto";
            PreparedStatement stmt2 = conexao.prepareStatement(sql2);
            stmt2.execute();
        }catch(SQLException e){
            System.out.println("Não foi possível atualizar os dados da tabela. Erro: "+e);
        }


    }
    
