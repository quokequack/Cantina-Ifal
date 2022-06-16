import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

import java.awt.event.*;
import java.sql.SQLException;


public class MainGUI extends JFrame implements ActionListener {
    private Container container;
    private JLabel rotulo;
    private JLabel rotulo2;
    private JButton login;
    private JButton cadastro;

    public MainGUI() throws SQLException{
        DB database = new DB();
        database.CriaTabelas();
        setSize(400,200);
        setTitle("CANTINA DO IFAL");
        container = getContentPane();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rotulo = new JLabel("BEM-VINDO A CANTINA DO IFAL");
        rotulo2 = new JLabel("O QUE DESEJA FAZER?");
        login = new JButton("LOGIN");
        cadastro = new JButton("CADASTRO");
        setLayout(null);
        rotulo.setBounds(110, 0, 200, 30);
        rotulo2.setBounds(135, 20, 150, 25);
        login.setBounds(100, 55, 200, 30);
        cadastro.setBounds(100, 85, 200, 30);
        container.add(rotulo);
        container.add(rotulo2);
        container.add(login);
        container.add(cadastro);
        login.addActionListener(this);
        cadastro.addActionListener(this);
    }
    //TRATAMENTO DE EVENTO
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("LOGIN")){
            try {
                LoginGUI loginP = new LoginGUI();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            this.dispose();
        }else{
            CadastroGUI cadastroP = new CadastroGUI();
            this.dispose();
        }
    }
    //INICIALIZA O PROGRAMA
    public static void main(String args[]) throws SQLException{
        MainGUI telaP = new MainGUI();
    }
}
