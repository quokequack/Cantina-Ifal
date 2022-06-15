import java.sql.*;

import javax.swing.plaf.synth.SynthSplitPaneUI;

public class ProdutoDAO {
    private Connection conexao;

    public ProdutoDAO(){
        this.conexao = FabricaCon.criaConexao();
    }

    public void adiciona(Produto produto) throws SQLException{
        String sql = "insert into Produto(codProd, nomeProd, descProd, precoCompra, precoVenda, qtddComprada, qtddvendida, qtdddisponivel)"+"values(?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        int codProd = produto.getCodigoProduto();
        String nomeProd = produto.getNome();
        String descProd = produto.getDescricao();
        Double precoCompra = produto.getPrecoDeCompra();
        Double precoVenda = produto.getPrecoDeVenda();
        int qtddComprada = produto.getQuantidadeComprada();
        int qtddVendida = produto.getQuantidadeVendida();
        int qtddDisponivel = produto.getQuantidadeDisponivel();

        stmt.setInt(1, codProd);
        stmt.setString(2, nomeProd);
        stmt.setString(3, descProd);
        stmt.setDouble(4, precoCompra);
        stmt.setDouble(5, precoVenda);
        stmt.setInt(6, qtddComprada);
        stmt.setInt(7, qtddVendida);
        stmt.setInt(8, qtddComprada);
        stmt.execute();
    
    }
    public void atualizaQtdd(int codprod, int qtdd){
        try{
            String updateQtdd = "update produto set qtddcomprada = qtdddisponivel + ? and qtdddisponivel = qtddcomprada where codprod = ?";
            PreparedStatement stmt2 = conexao.prepareStatement(updateQtdd);
            stmt2.setInt(1, qtdd);
            stmt2.setInt(2, codprod);
            stmt2.executeUpdate();
        }catch(SQLException e){
            System.out.println("Não foi possível atualizar os dados da tabela. Erro: "+e);
        }
    }
    public void atualizaNome(int codprod, String nomeNovo){
        try{
            String updateNome = "update produto set nomeprod = ? where codprod = ?";
            PreparedStatement stmt3 = conexao.prepareStatement(updateNome);
            stmt3.setString(1, nomeNovo);
            stmt3.setInt(2, codprod);
            stmt3.executeUpdate();
        }catch(SQLException e){
            System.out.println("Não foi possível atualizar os dados da tabela. Erro: "+e);
        }
    }
    public void atualizaPrecoVenda(int codprod, Double precoVenda){
        try{
            String updatePrecoVenda = "update produto set precoVenda = ? where codprod = ?";
            PreparedStatement stmt4 = conexao.prepareStatement(updatePrecoVenda);
            stmt4.setDouble(1, precoVenda);
            stmt4.setInt(2, codprod);
            stmt4.executeUpdate();
    }catch(SQLException e){
        System.out.println("Não foi possível atualizar os dados da tabela. Erro: "+e);
    }
        /*contador = 0;
        while (contador > 5){
            scanner('voce quer adicionar algum item a venda? ')
            if (sim){
                qual item?
                metodo que adiciona o item a venda
            if (nao){
                finaliza a venda e printa o total e a forma de pagamento
            }
            }*/
        };
    //método que faz uma consulta no banco de dados e retorna os produtos ordenados pelo estoque
    public void prodPorQtdd(){
        try{
            String selectQtdd = "select nomeprod, qtdddisponivel from produto where qtdddisponivel > 0 order by qtdddisponivel";
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
    public void lucroProd(){
        try{
            String selectLuc = "select nomeprod, ((qtddvendida * precovenda) - (qtddcomprada * precocompra)) from produto where (qtddvendida * precovenda - qtddcomprada * precocompra) > 0";
            PreparedStatement stmt5 = conexao.prepareStatement(selectLuc);
            ResultSet resultado4 = stmt5.executeQuery();
            while(resultado4.next()){
                String nomeProd = resultado4.getString("nomeprod");
                Double lucro = resultado4.getDouble("((qtddvendida * precovenda) - (qtddcomprada * precocompra))");
                System.out.println("Nome do produto: "+nomeProd+"; Lucro: "+lucro);
                
            }
        }catch(SQLException e){
            System.out.println("Não foi possível realizar a consulta. Erro: "+e);
        }
    }
    public void prejuizoProd(){
        try{
            String selectPrej = "select nomeprod, ((qtddvendida * precovenda) - (qtddcomprada * precocompra)) from produto where (qtddvendida * precovenda - qtddcomprada * precocompra) < 0";
            PreparedStatement stmt6 = conexao.prepareStatement(selectPrej);
            ResultSet resultado5 = stmt6.executeQuery();
            while(resultado5.next()){
                String nomeProd = resultado5.getString("nomeprod");
                Double prejuizo = resultado5.getDouble("((qtddvendida * precovenda) - (qtddcomprada * precocompra))");
                System.out.println("Nome do produto: "+nomeProd+"; Prejuízo: "+prejuizo);
            }
        }catch(SQLException e){
            System.out.println("Não foi possível realizar a consulta. Erro: "+e);
        }
    }
    public void ExcluirItem(int codprod) throws SQLException{
        String delete = "delete from produto where codprod = ?";
        PreparedStatement stmt = conexao.prepareStatement(delete);
        stmt.setInt(1, codprod);
        stmt.executeUpdate(delete);
    }
    
}