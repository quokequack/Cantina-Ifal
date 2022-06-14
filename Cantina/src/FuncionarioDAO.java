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

    String sql2 = "select login from funcionario where login=?";
        

    public boolean validaLogin(String login) throws SQLException{
        try(
            PreparedStatement stmt2 = conexao.prepareStatement(sql2);
        ){
            stmt2.setString(1, login);
            try (ResultSet resultado = stmt2.executeQuery()){
                return resultado.next();
            }
        }
    }
    public void adiciona(Funcionario funcionario){
        try{
            String sql = "insert into funcionario(login, nomefuncionario, senha)"+"values(?,?,?)";
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
