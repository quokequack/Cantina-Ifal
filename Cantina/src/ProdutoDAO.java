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
            //colocar aqui uma verificação de estoque, em caso de ele ter produtos, atualiza a quantidade
            String sql2 = "update Produto set qtddDisponivel = quantidadeDisponivelNoProduto and qtddVendida = quantidadeVendida where nomeProd = nomeProduto";
            PreparedStatement stmt2 = conexao.prepareStatement(sql2);
            stmt2.executeUpdate();
        }catch(SQLException e){
            System.out.println("Não foi possível atualizar os dados da tabela. Erro: "+e);
        }
    }
    //método que faz uma consulta no banco de dados e retorna os produtos ordenados pelo estoque
    public void prodPorQtdd(){
        try{
            String selectQtdd = "select nomeprod, qtdddisponivel from produto where qtdddisponivel > 0 order by qtdddiposnivel";
            PreparedStatement stmt3 = conexao.prepareStatement(selectQtdd);
            ResultSet resultado = stmt3.executeQuery();
            while(resultado.next()){
                String nomeProd = resultado.getString("nomeprod");
                System.out.println("Nome do produto: "+ nomeProd);
                int qtddDisp = resultado.getInt("qtdddisponivel");
                System.out.println("Quantidade disponível: "+ qtddDisp);
            }
        }catch(SQLException e){
            System.out.println("Não foi possível realizar a consulta. Erro: "+ e);
        }
    }
    //método que faz uma consulta no banco de dados e retorna os produtos ordenados pela descrição
    public void prodPorDesc(){
        try{
            String selectDesc = "select nomeprod, descprod from produto where qtdddisponivel > 0 order by descprod";
            PreparedStatement stmt4 = conexao.prepareStatement(selectDesc);
            ResultSet resultado2 = stmt4.executeQuery();
            while(resultado2.next()){
                String nomeProd = resultado2.getString("nomeprod");
                System.out.println("Nome do produto: "+ nomeProd);
                String descProd = resultado2.getString("descprod");
                System.out.println("Descrição: "+ descProd);
            }
        }catch(SQLException e){
            System.out.println("Não foi possível realizar a consulta. Erro: "+e);
        }
    }
    //método que faz uma pesquisa no banco de dados e retorna os produtos com estoque pequeno
    public void estoquePeq(){
        try{
            String selectQtddMin = "select nomeprod, qtdddisponivel from produto where qtdddisponivel <= 50 order by qtdddisponivel";
            PreparedStatement stmt4 = conexao.prepareStatement(selectQtddMin);
            ResultSet resultado3 = stmt4.executeQuery();
            while(resultado3.next()){
                String nomeProd = resultado3.getString("nomeprod");
                System.out.println("Nome do produto: "+ nomeProd);
                int qtddPeq = resultado3.getInt("qtdddisponivel");
                System.out.println("Quantidade Disponível: "+ qtddPeq);
            }
        }catch(SQLException e){
            System.out.println("Não foi possível realizar a consulta. Erro: "+e);
        }
    }
}
    
