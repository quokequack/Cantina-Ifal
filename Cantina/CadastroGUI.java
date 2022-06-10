import java.awt.Container;

public class CadastroGUI extends JFrame {
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
    private JButton voltar;
    private JButton limparTudo;


    public CadastroGUI(){
        setSize(500,400);
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
        voltar = new JButton("VOLTAR");
        limparTudo = new JButton("LIMPAR TUDO");
        lblText.setBounds(80, 10, 200, 90);
        lblText.setBounds(80, 15, 200, 90);
        lblLogin.setBounds(40, 30, 100, 25);
        txtLogin.setBounds(40, 60, 100, 25);
        lblNome.setBounds(40, 90, 100, 25);
        txtNome.setBounds(40, 120, 100, 25);
        lblSenha.setBounds(40, 150, 100, 25);
        txtSenha.setBounds(40, 180, 100, 25);
        container.add(lblText);
        container.add(txtLogin);
        container.add(lblLogin);
        container.add(lblNome);
        container.add(txtNome);
        container.add(lblSenha);
        container.add(txtSenha);
    }
    public static void main(String args[]){
        CadastroGUI cadastroTeste = new CadastroGUI();
    }

}
