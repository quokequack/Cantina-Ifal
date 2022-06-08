import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Interface1 extends JFrame{
    private JLabel lblNome;
    private JLabel lblCodigo;
    private JLabel lblSenha;
    private JTextField codigo;
    private JTextField senha;
    private JTextField txtNome;
    public Interface1(){
        lblNome = new JLabel("Nome:");
        txtNome = new JTextField();
        lblCodigo = new JLabel("Código: ");
        codigo = new JTextField();
        lblSenha = new JLabel("Senha: ");
        senha = new JTextField();
        setVisible(true);
        setSize(500,400);
        setLayout(null);
        lblNome.setBounds(10, 10, 100, 25);
        txtNome.setBounds(50, 10, 200, 25);
        getContentPane().add(lblNome);
        getContentPane().add(txtNome);
        add(lblNome);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    public static void main(String args[]){
        Interface1 telaInicial = new Interface1();
        }
        
}

/*import javax.swing.*;

public class Interface1 extends JFrame{
    private JButton botao;
    private JTextField txtNome;
    private JLabel lblNome;
    private Container container;

    public Interface1(){
        setSize(300, 140);
        setTitle("Primeiros passos em Swing");
        container.getContentPane();
        container.setLayout(null);
        botao = new JButton("Okay!");
        lblNome = new JLabel("Nome");
        txtNome = new JTextField();
        lblNome.setBounds(10, 10, 100, 25);
        txtNome.setBounds(40, 10, 100, 25);
        botao.setBounds(70, 10, 100, 25);
        container.add(lblNome);
        container.add(txtNome);
        container.add(botao);
        setVisible(true);
    }
    public static void main(String args[]){
        Interface1 tela = new Interface1();
    }
    botao.addActionListener(this);
        @Override
        public void actionPerformed(ActionEvent e){
            if (e.getActionCommand().equals("Enviar")){
                txtNome.setText("Botão clicado"))
            }
        }
}*/
