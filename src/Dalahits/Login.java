
package Dalahits;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

public class Login {
//Instancia componentes
  ImageIcon OK = new ImageIcon("C:\\OneDrive\\AGEIS\\DalaHits\\Icones\\connect.png");
  ImageIcon CADASTRA = new ImageIcon("C:\\OneDrive\\AGEIS\\DalaHits\\Icones\\add.png");
  JFrame janela = new JFrame();
  JPanel group = new JPanel();
  JLabel labelUsu = new JLabel("Usuário:");
  JLabel labelPass = new JLabel("Senha:");
  JButton btLogin = new JButton("Login", OK);
  JButton btCad = new JButton(CADASTRA);
  JTextField efUser = new JTextField(5);
  JTextField efPass = new JTextField(5);
//Instancia a classe do BD
  Commit c1 = Commit.get();
//Desenha a janela de Login
    public void CriaJanela(){
//Inicializa a criação da janela
        janela.setTitle("Login");
        janela.setSize(235, 175);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocation(500, 300);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println(e);
        }
//Criando Panel principal
        group.setVisible(true);
        group.setLayout(null);
        janela.add(group);
//Cria Label usuário
        labelUsu.setLocation(10, 0);
        labelUsu.setVisible(true);
        labelUsu.setSize(100, 30);
        group.add(labelUsu);
//Cria Label password
        labelPass.setLocation(10, 50);
        labelPass.setSize(100, 30);
        labelPass.setVisible(true);
        group.add(labelPass);
//Cria botão de login
        btLogin.setSize(90, 30);
        btLogin.setLocation(120, 100);
        group.add(btLogin);
        btLogin.setVisible(true);
  // Se clicou no botão de login
          btLogin.addActionListener(new ActionListener(){
              @Override
              public void actionPerformed(ActionEvent e){
//Testa se o usuário é valido
                if (c1.SelectUser(efUser.getText())) {
                  Inicial i1 = new Inicial();
                  i1.TelaInicial();
                } else {
                  Mensagem m1 = new Mensagem();
                  m1.ShowMessagem("Login Inválido");
                }
              }
          });
//Cria entry-field
        efUser.setSize(200, 20);
        efUser.setLocation(10, 20);
        efUser.setVisible(true);
        group.add(efUser);
//Cria entry-field
        efPass.setSize(200, 20);
        efPass.setLocation(10, 70);
        efPass.setVisible(true);
        group.add(efPass);
//Cria botão
        btCad.setSize(30, 30);
        btCad.setLocation(10, 100);
        btCad.setVisible(true);
        btCad.setToolTipText("Cadastrar login?");
// Se clicou no botão de login
        btCad.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
              c1.CommitLogin(efUser.getText(), efPass.getText());
            }
        });
        group.add(btCad);
//--------------------------------------------------------------------------------------------------------------------//
//Finaliza a criação da janela
        janela.setVisible(true);
    }
}
