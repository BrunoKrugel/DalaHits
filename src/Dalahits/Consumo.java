
package Dalahits;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Consumo {
Commit c1 = Commit.get();
public void CriaJanelaConsumo(){
//Inicializa a criação da janela
        JFrame janela = new JFrame();
        janela.setTitle("Consumo");
        janela.setSize(235, 185);
        janela.setLocation(120, 300);
        try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
                System.out.println(e);
        }
//Criando Panel
        JPanel group = new JPanel();
        group.setVisible(true);
        group.setLayout(null);
        janela.add(group);
//--------------------------------------------------------------------------------------------------------------------//
//Criando Panel dos dados do produto
        JPanel groupbox = new JPanel();
        groupbox.setVisible(true);
        groupbox.setLayout(null);
        groupbox.setBorder(BorderFactory.createLineBorder(Color.black));
        groupbox.setLocation(10, 10);
        groupbox.setSize(200, 90);
        group.add(groupbox);
//Label do cliente
        JLabel labelNome = new JLabel("Cliente:");
        labelNome.setLocation(10, 0);
        labelNome.setVisible(true);
        labelNome.setSize(100, 20);
        groupbox.add(labelNome);
//Cria entry-field do código do cliente
        JTextField efCli = new JTextField(5);
        efCli.setSize(180, 20);
        efCli.setLocation(10, 15);
        efCli.setVisible(true);
        groupbox.add(efCli);
//Label do produto consumido
        JLabel labelPrv = new JLabel("Produto consumido:");
        labelPrv.setLocation(10, 35);
        labelPrv.setVisible(true);
        labelPrv.setSize(100, 30);
        groupbox.add(labelPrv);
//Cria entry-field de descriçõa do produto
        JTextField efPro = new JTextField(5);
        efPro.setSize(180, 20);
        efPro.setLocation(10, 55);
        efPro.setVisible(true);
        groupbox.add(efPro);
//--------------------------------------------------------------------------------------------------------------------//
//Cria botão de OK
        ImageIcon OK = new ImageIcon("C:\\OneDrive\\AGEIS\\DalaHits\\Icones\\tick.png");
        JButton btLogin = new JButton(OK);
        btLogin.setSize(30, 30);
        btLogin.setLocation(175, 110);
        btLogin.setVisible(true);
        btLogin.setToolTipText("Confirmar consumo?");
        group.add(btLogin);
        btLogin.addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e){
                                if (c1.readPro(efPro.getText(), false) && c1.readPes(efCli.getText(), false)) {
                                        c1.CommitConsumo(efCli.getText(), efPro.getText(), true);
                                        c1.updProQtd(efPro.getText());
                                }else {
                                  Mensagem m1 = new Mensagem();
                                  m1.ShowMessagem("Consumo não cadastrado!");
                                }
                        }
                });
//--------------------------------------------------------------------------------------------------------------------//
//Finaliza a criação da janela
        janela.setVisible(true);
}

}
