
package Dalahits;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;


public class Produto {

private static Produto instance = new Produto();

private Produto (){
}

public static Produto get(){
        return instance;
}

Commit c1 = Commit.get();
JFrame janela = new JFrame();
JPanel group = new JPanel();
JLabel label1 = new JLabel("Código:");
JPanel groupbox = new JPanel();
JTextField efCod = new JTextField(5);
JLabel labelNome = new JLabel("Descrição:");
JTextField efDes = new JTextField(5);
JLabel labelPrv = new JLabel("Preço:");
JTextField efPrv = new JTextField(5);
JLabel labelQtd = new JLabel("Quantidade:");
JTextField efQtd = new JTextField(5);
ImageIcon OK = new ImageIcon("C:\\OneDrive\\AGEIS\\DalaHits\\Icones\\tick.png");
JButton btLogin = new JButton(OK);
ImageIcon DELETE = new ImageIcon("C:\\OneDrive\\AGEIS\\DalaHits\\Icones\\delete.png");
JButton btDelete = new JButton(DELETE);

public void setDescricao(String NOME){
        efDes.setText(NOME);
}
public void setPreco(Double PRECO){
        efPrv.setText(Double.toString(PRECO));
}
public void setQtd(Integer QTD){
        efQtd.setText(Integer.toString(QTD));
}

public void CriaProduto(){
//Inicializa a criação da janela
        janela.setTitle("Produtos");
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
                                c1.readPro(efCod.getText(), true);
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
//Cria entry-field de descriçõa do produto
        efDes.setSize(180, 20);
        efDes.setLocation(10, 25);
        efDes.setVisible(true);
        groupbox.add(efDes);
//Label
        labelPrv.setLocation(10, 45);
        labelPrv.setVisible(true);
        labelPrv.setSize(100, 30);
        groupbox.add(labelPrv);
//Cria entry-field de descriçõa do produto
        efPrv.setSize(85, 20);
        efPrv.setLocation(10, 65);
        efPrv.setVisible(true);
        groupbox.add(efPrv);
//Label
        labelQtd.setLocation(105, 45);
        labelQtd.setVisible(true);
        labelQtd.setSize(100, 30);
        groupbox.add(labelQtd);
//Cria entry-field de descriçõa do produto
        efQtd.setSize(85, 20);
        efQtd.setLocation(105, 65);
        efQtd.setVisible(true);
        groupbox.add(efQtd);
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
                                if(c1.readPro(efCod.getText(),false)) {
                                        c1.updPro(efCod.getText(), efDes.getText(), Double.parseDouble(efPrv.getText()), Integer.parseInt(efQtd.getText()));
                                } else {
                                        c1.commitProduto(efCod.getText(), efDes.getText(), Double.parseDouble(efPrv.getText()), Integer.parseInt(efQtd.getText()));
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
                                c1.deleteProduto(efCod.getText());
                        }
                });
//--------------------------------------------------------------------------------------------------------------------//
//Finaliza a criação da janela
        janela.setVisible(true);
}
}
