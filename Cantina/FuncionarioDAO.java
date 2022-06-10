import java.sql.*;

public class FuncionarioDAO {
    private Connection conexao;
    private int login;
    private String username;
    private String senha;

    public FuncionarioDAO(){
        this.conexao = new FabricaCon().criaConexao();
    }

    public void adiciona(Funcionario funcionario){
        String sql = "insert into funcionario(login, nome, senha)"+"values(?,?,?)";
        try{
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, funcionario.getLogin());
            stmt.setString(2, funcionario.getUsername());
            stmt.setString(3, funcionario.getSenha());
        }catch(SQLException e){
            throw new RuntimeException("Não foi possível adicionar. Erro: "+e);
        }
    }
}
