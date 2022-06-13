import javax.swing.*;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.*;

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
        setSize(400,400);
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
        cancelar = new JButton("VOLTAR");
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
    }
    public static void main(String args[]){
        CadastroGUI cadastroTeste = new CadastroGUI();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Cadastrar")){
            
        }
        
    }

}
