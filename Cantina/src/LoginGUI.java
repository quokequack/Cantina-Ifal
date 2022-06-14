import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginGUI extends JFrame implements ActionListener {
    private Container container;
    private JLabel lblNome;
    private JLabel lblSenha;
    private JLabel lblLogin;
    private JTextField txtNome;
    private JTextField txtSenha;
    private JTextField txtLogin;
    private JButton login;
    private JLabel lblText;
    private JLabel lblText2;

    public LoginGUI(){
        setSize(400,00);
        setTitle("Cantina IFAL -Login de funcionarios");
        lblText = new JLabel("LOGIN DE FUNCIONARIOS");
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
        login = new JButton("LOGAR");
        lblText.setBounds(130, 0, 200, 25);
        lblText2.setBounds(160, 15, 150,25);
        lblLogin.setBounds(95, 45, 200,25);
        txtLogin.setBounds(95, 75, 200, 25);
        lblNome.setBounds(95, 105, 200, 25);
        txtNome.setBounds(95, 135, 200, 25);
        lblSenha.setBounds(95, 165, 200, 25);
        txtSenha.setBounds(95, 195, 200, 25);
        login.setBounds(95, 255, 200, 25);
        container.add(lblText);
        container.add(lblText2);
        container.add(txtLogin);
        container.add(lblLogin);
        container.add(lblNome);
        container.add(txtNome);
        container.add(lblSenha);
        container.add(txtSenha);
        container.add(login);
        login.addActionListener(this);
    }
    public static void main(String args[]){
        LoginGUI telaLogin = new LoginGUI();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String username = txtNome.getText();
        int login = Integer.parseInt(txtLogin.getText());
        String senha = txtSenha.getText();
        try{
            String select = "select nome, login, senha from funcionario";
            FabricaCon fab = new FabricaCon();
            
            PreparedStatement stmt = fab.criaConexao().prepareStatement(select);
            stmt.setString(1, username);
            stmt.setInt(2, login);
            stmt.setString(3, senha);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                dispose();
                JOptionPane.showMessageDialog(null, "Você logou com sucesso!");
            }
        }catch(SQLException err){
            System.out.println("Não foi possível fazer login. Erro: "+ err);
        }

        
    }
}
