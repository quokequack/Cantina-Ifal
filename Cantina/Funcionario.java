public class Funcionario{
    private int login;
    private String username;
    private String senha;


    public int getLogin(){
        return this.login;
    }
    public String getUsername(){
        return this.username;
    }
    public String getSenha(){
        return this.senha;
    }
    public void setLogin(int login){
        this.login = login;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }
}
