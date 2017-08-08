
package Dalahits;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;

public abstract class Pessoa {


Commit c1 = Commit.get();
JFrame janela = new JFrame();
JPanel group = new JPanel();
JLabel label1 = new JLabel("Código:");
JPanel groupbox = new JPanel();
JTextField efCod = new JTextField(5);
JLabel labelNome = new JLabel("Nome");
JTextField efNom = new JTextField(5);
JLabel labelCPF = new JLabel("CPF");
JTextField efCPF = new JTextField(5);
ImageIcon OK = new ImageIcon("C:\\OneDrive\\AGEIS\\DalaHits\\Icones\\tick.png");
JButton btLogin = new JButton(OK);
ImageIcon DELETE = new ImageIcon("C:\\OneDrive\\AGEIS\\DalaHits\\Icones\\delete.png");
JButton btDelete = new JButton(DELETE);

public void setNome(String NOME){
        efNom.setText(NOME);
}

public void setCPF(String CPF){
        efCPF.setText(CPF);
}

public abstract void GravaCadastro();

public void CriaPessoa(String People){
//Inicializa a criação da janela
        janela.setTitle(People);
        janela.setSize(235, 230);
        janela.setLocation(120, 300);
        try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
                System.out.println(e);
        }
//Criando Panel
        group.setVisible(true);
        group.setLayout(null);
        janela.add(group);
//Cria Label 1
        label1.setLocation(10, 0);
        label1.setVisible(true);
        label1.setSize(100, 30);
        group.add(label1);
//Cria entry-field
        efCod.setSize(200, 20);
        efCod.setLocation(10, 20);
        efCod.setVisible(true);
        group.add(efCod);
        efCod.addFocusListener(new FocusListener() {
                        public void focusGained(FocusEvent e) {
                        };
                        public void focusLost(FocusEvent e) {
                                c1.readPes(efCod.getText(), true);
                        }
                });
//--------------------------------------------------------------------------------------------------------------------//
//Criando Panel dos dados do produto
        groupbox.setVisible(true);
        groupbox.setLayout(null);
        groupbox.setBorder(BorderFactory.createLineBorder(Color.black));
        groupbox.setLocation(10, 50);
        groupbox.setSize(200, 100);
        group.add(groupbox);
//Label
        labelNome.setLocation(10, 0);
        labelNome.setVisible(true);
        labelNome.setSize(100, 30);
        groupbox.add(labelNome);
//Cria entry-field de NOME
        efNom.setSize(180, 20);
        efNom.setLocation(10, 25);
        efNom.setVisible(true);
        groupbox.add(efNom);
//Label
        labelCPF.setLocation(10, 45);
        labelCPF.setVisible(true);
        labelCPF.setSize(100, 30);
        groupbox.add(labelCPF);
//Cria entry-field de CPF
        efCPF.setSize(180, 20);
        efCPF.setLocation(10, 65);
        efCPF.setVisible(true);
        groupbox.add(efCPF);
//--------------------------------------------------------------------------------------------------------------------//
//Cria botão de OK
        btLogin.setSize(30, 30);
        btLogin.setLocation(175, 155);
        btLogin.setVisible(true);
        btLogin.setToolTipText("Confirmar manutenção do produto?");
        group.add(btLogin);
        btLogin.addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e){
                                if(c1.readPes(efCod.getText(),false)) {
                                        c1.updPes(efCod.getText(), efNom.getText(), efCPF.getText());
                                } else {
                                        GravaCadastro();
                                }
                        }
                });
//Cria botão de excluir
        btDelete.setSize(30, 30);
        btDelete.setToolTipText("Excluir produto?");
        btDelete.setLocation(10, 155);
        btDelete.setVisible(true);
        group.add(btDelete);
        btDelete.addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e){
                                c1.deletePessoa(efCod.getText());
                        }
                });
//--------------------------------------------------------------------------------------------------------------------//
//Finaliza a criação da janela
        janela.setVisible(true);
}



}
