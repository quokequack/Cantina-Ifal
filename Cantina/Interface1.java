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
