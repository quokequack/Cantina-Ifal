import java.sql.*;

public class FuncionarioDAO {
    private Connection conexao;
    private int login;
    private String username;
    private String senha;

    public FuncionarioDAO(){
        /*
        FabricaCon conexao = new FabricaCon();
        this.conexao = conexao.criaConexao(); */
        conexao = FabricaCon.criaConexao();
    }
    //ADICIONA O FUNCIONARIO NO BANCO
    public void adiciona(Funcionario funcionario){
        try{
            String sql = "insert into funcionario(login, nome, senha)"+"values(?,?,?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, funcionario.getLogin());
            stmt.setString(2, funcionario.getUsername());
            stmt.setString(3, funcionario.getSenha());
            stmt.execute();

            //adicionar aqui uma estrutura condicional

        }catch(SQLException e){
            throw new RuntimeException("Não foi possível adicionar. Erro: "+e);
        }
    }
}
