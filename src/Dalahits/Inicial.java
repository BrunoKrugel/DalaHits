
package Dalahits;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Inicial {
public void TelaInicial(){
//Inicializa a criação da janela
        JFrame janela = new JFrame();
        janela.setTitle("DalaHits");
        janela.setSize(275, 220);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocation(500, 300);
//Seleciona o tema da aplicação
        try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
                System.out.println(e);
        }
//Criando panel principal
        JPanel group = new JPanel();
        group.setVisible(true);
        group.setLayout(null);
        janela.add(group);
//--------------------------------------------------------------------------------------------------------------------//
//Criando Panel de cadastro de pessoas
        JPanel groupcad = new JPanel();
        groupcad.setVisible(true);
        groupcad.setLayout(null);
        groupcad.setBorder(BorderFactory.createLineBorder(Color.black));
        groupcad.setLocation(10, 10);
        groupcad.setSize(240, 50);
        group.add(groupcad);
//Cria botão para cadastro do Cliente
        ImageIcon USER = new ImageIcon("C:\\OneDrive\\AGEIS\\DalaHits\\Icones\\user.png");
        JButton btCli = new JButton("Cliente", USER);
        btCli.setSize(110, 30);
        btCli.setLocation(10, 10);
        btCli.setVisible(true);
        groupcad.add(btCli);
        btCli.addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e){
                                Cliente c1 = Cliente.get();
                                c1.CriaCliente();
                        }
                });
//Cadastra funcionários
        ImageIcon FUNC = new ImageIcon("C:\\OneDrive\\AGEIS\\DalaHits\\Icones\\user_suit.png");
        JButton btFun = new JButton("Funcionario", FUNC);
        btFun.setSize(110, 30);
        btFun.setLocation(120, 10);
        btFun.setVisible(true);
        groupcad.add(btFun);
        btFun.addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e){
                                Funcionario c1 = Funcionario.get();
                                c1.CriaFuncionario();
                        }
                });
//--------------------------------------------------------------------------------------------------------------------//
//Cria o painel de produtos e consumos
        JPanel grouppro = new JPanel();
        grouppro.setVisible(true);
        grouppro.setLayout(null);
        grouppro.setBorder(BorderFactory.createLineBorder(Color.black));
        grouppro.setLocation(10, 70);
        grouppro.setSize(240, 50);
        group.add(grouppro);
//Cadastra produtos da DalaHits2
        ImageIcon PROD = new ImageIcon("C:\\OneDrive\\AGEIS\\DalaHits\\Icones\\bricks.png");
        JButton btPro = new JButton("Produtos", PROD);
        btPro.setSize(110, 30);
        btPro.setLocation(10, 10);
        btPro.setVisible(true);
        grouppro.add(btPro);
        btPro.addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e){
                                // Instancia a janela
                                Produto p1 = Produto.get();
                                p1.CriaProduto();
                        }
                });
//Cria o botão para consumo de bebidas
        ImageIcon drink = new ImageIcon("C:\\OneDrive\\AGEIS\\DalaHits\\Icones\\drink.png");
        JButton btCon = new JButton("Consumo", drink);
        btCon.setSize(110, 30);
        btCon.setLocation(120, 10);
        btCon.setVisible(true);
        grouppro.add(btCon);
        btCon.addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e){
                                // Instancia a janela
                                Consumo b1 = new Consumo();
                                b1.CriaJanelaConsumo();
                        }
                });
//--------------------------------------------------------------------------------------------------------------------//
//Cria o painel de ingressos e conta
        JPanel groupcon = new JPanel();
        groupcon.setVisible(true);
        groupcon.setLayout(null);
        groupcon.setBorder(BorderFactory.createLineBorder(Color.black));
        groupcon.setLocation(10, 125);
        groupcon.setSize(240, 50);
        group.add(groupcon);
//Venda de ingresso
        ImageIcon INGRESS = new ImageIcon("C:\\OneDrive\\AGEIS\\DalaHits\\Icones\\script.png");
        JButton btIng = new JButton("Ingresso", INGRESS);
        btIng.setSize(110, 30);
        btIng.setLocation(10, 10);
        btIng.setVisible(true);
        groupcon.add(btIng);
        btIng.addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e){
                                Ingresso i1 = new Ingresso();
                                i1.CriaJanelaIngresso();
                        }
                });
// Finaliza a conta
        ImageIcon Coins = new ImageIcon("C:\\OneDrive\\AGEIS\\DalaHits\\Icones\\coins.png");
        JButton btBil = new JButton("Conta", Coins);
        btBil.setSize(110, 30);
        btBil.setLocation(120, 10);
        btBil.setVisible(true);
        groupcon.add(btBil);
        btBil.addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e){
                                Conta b1 = new Conta();
                                b1.CriaJanelaConta();
                        }
                });
//--------------------------------------------------------------------------------------------------------------------//
//Finaliza a criação da janela
        janela.setVisible(true);
}
}
