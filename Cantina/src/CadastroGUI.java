import javax.swing.*;
import java.awt.Container;
import java.awt.event.*;
import java.lang.invoke.StringConcatFactory;
import java.sql.*;

public class CadastroGUI extends JFrame implements ActionListener {
    private JLabel lblText;
    private JLabel lblText2;
    private JLabel lblLogin;
    private JTextField txtLogin;
    private JLabel lblNome;
    private JTextField txtNome;
    private JLabel lblSenha;
    private JTextField txtSenha;
    private Container container;
    private JButton cadastrar;
    private JButton cancelar;
    private JButton limparTudo;


    public CadastroGUI(){
        setSize(400,00);
        setTitle("Cantina IFAL - Cadastro de funcionarios");
        lblText = new JLabel("CADASTRO DE FUNCIONARIOS");
        lblText2 = new JLabel("Cantina IFAL");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container = getContentPane();
        container.setLayout(null);
        lblLogin = new JLabel("LOGIN:");
        txtLogin = new JTextField();
        lblNome = new JLabel("NOME:");
        txtNome = new JTextField();
        lblSenha = new JLabel("SENHA:");
        txtSenha = new JTextField();
        cadastrar = new JButton("CADASTRAR");
        cancelar = new JButton("CANCELAR");
        limparTudo = new JButton("LIMPAR");
        lblText.setBounds(110, 0, 200, 25);
        lblText2.setBounds(160, 15, 150,25);
        lblLogin.setBounds(95, 45, 200,25);
        txtLogin.setBounds(95, 75, 200, 25);
        lblNome.setBounds(95, 105, 200, 25);
        txtNome.setBounds(95, 135, 200, 25);
        lblSenha.setBounds(95, 165, 200, 25);
        txtSenha.setBounds(95, 195, 200, 25);
        limparTudo.setBounds(95, 255, 100, 25);
        cancelar.setBounds(195, 255, 100, 25);
        cadastrar.setBounds(95,285, 200, 25);
        container.add(lblText);
        container.add(lblText2);
        container.add(txtLogin);
        container.add(lblLogin);
        container.add(lblNome);
        container.add(txtNome);
        container.add(lblSenha);
        container.add(txtSenha);
        container.add(cadastrar);
        container.add(cancelar);
        container.add(limparTudo);
        cadastrar.addActionListener(this);
        limparTudo.addActionListener(this);
        cancelar.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("LIMPAR")){
            txtLogin.setText("");
            txtNome.setText("");
            txtSenha.setText("");
        }else if (e.getActionCommand().equals("CANCELAR")){
            this.dispose();
        }else if(e.getActionCommand().equals("CADASTRAR")){
            Funcionario funcionarioNovo = new Funcionario();
            /*int login = Integer.parseInt(txtLogin.getText());*/
            funcionarioNovo.setLogin(txtLogin.getText());
            funcionarioNovo.setUsername(txtNome.getText());
            funcionarioNovo.setSenha(txtSenha.getText());
            boolean verificacao = verificaBancoFunc(txtLogin.getText(), txtNome.getText(), txtSenha.getText());
            if(verificacao = false){
                System.out.println("Funcionário já existe!");
                dispose();
            }else{
                if ((txtLogin.getText().isEmpty()) || (txtNome.getText().isEmpty()) || (txtSenha.getText().isEmpty())){
                    JOptionPane.showMessageDialog(null, "Preencha os campos!!");
                }else{
                    FuncionarioDAO fdao = new FuncionarioDAO();
                    fdao.adiciona(funcionarioNovo);
                    JOptionPane.showMessageDialog(null, "Funcionário "+txtNome.getText()+" inserido com sucesso!");
                    txtLogin.setText("");
                    txtNome.setText("");
                    txtSenha.setText("");
                    Main telaPrincipal = new Main();
                    try {
                        telaPrincipal.cantina();
                    } catch (PrecoInvalidoException | QuantidadeInvalidaException | SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    dispose();
                }
            }
        }
    }
    public boolean verificaBancoFunc(String login, String nome, String senha){
        try{
            FabricaCon fabCon = new FabricaCon();
            Connection conexao = fabCon.criaConexao();
            String selectFunc = "select login, nome, senha from funcionario where login = ? and nome = ? and senha = ?";
            PreparedStatement stmt = conexao.prepareStatement(selectFunc);
            stmt.setString(1, login);
            stmt.setString(2, nome);
            stmt.setString(3, senha);
            ResultSet resultado = stmt.executeQuery();
            boolean result = false;
            if(resultado.next()){
                JOptionPane.showMessageDialog(null, "Usuário já cadastrado. Tente novamente!");
                dispose();
                result = true;
            }
            return result;
        }catch(SQLException e){
            throw new RuntimeException("ERRO: ");
        }
    }
}
        


