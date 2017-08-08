
package Dalahits;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import javax.swing.JOptionPane;
//JOptionPane.showMessageDialog(null,"oi");

public class Commit {
//Mensagens de erro
Mensagem m1 = new Mensagem();

private static Commit instance = new Commit();

private Commit (){
}

public static Commit get(){
        return instance;
}


Connection BD;
//Conecta com o DB
public void Connect(){
        try {
                String URL = "jdbc:postgresql://localhost:5432/postgres";
                String USER = "postgres";
                String PASSWORD = "Bk17031996";
                Class.forName("org.postgresql.Driver");
                BD = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Conexão realizada com sucesso.");
                Statement stm = BD.createStatement();
                stm.execute("SET SEARCH_PATH TO AGEIS");
        } catch (ClassNotFoundException | SQLException e) {
                System.out.println(e);
        }
}
// Fecha a conexão com o banco de dados
public void Close(){
        try {
                BD.close();
        } catch (SQLException e) {
                System.out.println(e);
        }
}
// Commita uma mudança no banco de dados do Login
public boolean CommitLogin(String USUARIO, String SENHA){
        try {
                PreparedStatement stm = BD.prepareStatement("INSERT INTO DBLOGIN VALUES (?, ?)");
                //  stm.setString(1, "ppk");
                stm.setString(1, USUARIO);
                stm.setString(2, SENHA);
                stm.executeUpdate();
                m1.ShowMessagem("Login cadastrado!");
                return true;
        } catch (SQLException e) {
                System.out.println(e);
                m1.ShowMessagem("Login inválido, tente outro!");
                return false;
        }
}
//Retorna o sequencial do próximo consumo
public int getSequencial(String CLIENTE){
        int i=1;
        try {
                PreparedStatement stm = BD.prepareStatement("select * from consumo where cliente = ?;");
                stm.setString(1, CLIENTE);
                ResultSet s = stm.executeQuery();
                while (s.next()) {
                        i++;
                }
                return i;
        } catch (SQLException e) {
                return i;
        }
}
//Cadastra o consumo
public boolean CommitConsumo(String CLIENTE, String PRODUTO, boolean MESSAGE){
        int i;
        try {
//Retorna o proximo sequencial valido para o consumo
                i = getSequencial(CLIENTE);
                PreparedStatement stm = BD.prepareStatement("INSERT INTO CONSUMO VALUES (?, ?, ?)");
                stm.setString(1, CLIENTE);
                stm.setInt(2, i);
                stm.setString(3, PRODUTO);
                stm.executeUpdate();
                if (MESSAGE) m1.ShowMessagem("Consumo cadastrado com sucesso!");
                return true;
        } catch (SQLException e) {
                System.out.println(e);
                m1.ShowMessagem("Erro");
                return false;
        }
}
//Retorna verdadeiro caso o usuário exista
public boolean SelectUser(String USUARIO){
        try {
                PreparedStatement stm = BD.prepareStatement("select desUsu, pasusu from dblogin where desUsu = ?");
                stm.setString(1, USUARIO);
                ResultSet s = stm.executeQuery();
                return s.next();
        } catch (SQLException e) {
                return false;
        }
}
//Retorna a senha
public String SelectPass(String USUARIO){
        ResultSet s;
        try {
                PreparedStatement stm = BD.prepareStatement("select desUsu, pasusu from dblogin where desUsu = ?");
                stm.setString(1, USUARIO);
                s = stm.executeQuery();
                if(s.next()) {
                        return s.getString("pasusu");
                }
                return "";
        } catch (SQLException e) {
                return "";
        }
}
//Deleta o produto
public void deleteProduto(String CODIGO){
        try {
                PreparedStatement stm = BD.prepareStatement("DELETE FROM produto WHERE codigo = ?");
                stm.setString(1, CODIGO);
                stm.executeUpdate();
                m1.ShowMessagem("Produto excluído com sucesso!");
        } catch (SQLException e) {
                System.out.println(e);
                m1.ShowMessagem("Erro");
        }
}
//Retorna a quantidade em estoque do produto
public Integer getProQtd(String CODIGO){
        ResultSet s;
        try {
                PreparedStatement stm = BD.prepareStatement("select quantidade from produto where codigo = ?");
                stm.setString(1, CODIGO);
                s = stm.executeQuery();
                if(s.next()) {
                        return s.getInt("quantidade");
                }
                return 0;
        } catch (SQLException e) {
                System.out.println(e);
                return 0;
        }
}

public Integer getProPRV(String CODIGO){
        ResultSet s;
        try {
                PreparedStatement stm = BD.prepareStatement("select preco from produto where codigo = ?");
                stm.setString(1, CODIGO);
                s = stm.executeQuery();
                if(s.next()) {
                        return s.getInt("preco");
                }
                return 0;
        } catch (SQLException e) {
                System.out.println(e);
                return 0;
        }
}


//Consome 1 da quantidade do produto
public void updProQtd(String CODIGO){
        Integer i = getProQtd(CODIGO);
        try {
                PreparedStatement stm = BD.prepareStatement("UPDATE produto SET quantidade = ? WHERE codigo = ?");
                stm.setInt(1, --i);
                stm.setString(2, CODIGO);
                stm.executeUpdate();
        } catch (SQLException e) {
                System.out.println(e);
        }
}
//Read na tabela de produtos
public boolean readPro(String CODIGO, boolean atu){
        ResultSet s;
        try {
                PreparedStatement stm = BD.prepareStatement("select * from produto where codigo = ?");
                stm.setString(1, CODIGO);
                s = stm.executeQuery();
                if(s.next() && atu) {
                        Produto p1 = Produto.get();
                        p1.setDescricao(s.getString("descricao"));
                        p1.setPreco(s.getDouble("preco"));
                        p1.setQtd(s.getInt("quantidade"));
                        return true;
                }
                return false;
        } catch (SQLException e) {
                return false;
        }
}

public void updPro(String CODIGO, String DESCRICAO, Double PRV, Integer QTD){
        try {
                PreparedStatement stm = BD.prepareStatement("UPDATE produto SET descricao = ?, preco = ?, quantidade = ? WHERE codigo = ?");
                stm.setString(1, DESCRICAO);
                stm.setDouble(2, PRV);
                stm.setInt(3, QTD);
                stm.setString(4, CODIGO);
                stm.executeUpdate();
                m1.ShowMessagem("Produto alterado com sucesso!");
        } catch (SQLException e) {
                System.out.println(e);
        }
}

public void commitProduto(String CODIGO, String DESCRICAO, Double PRV, Integer QTD){
        try {
                PreparedStatement stm = BD.prepareStatement("INSERT INTO PRODUTO VALUES (?, ?, ?, ?)");
                stm.setString(1, CODIGO);
                stm.setInt(2, QTD);
                stm.setString(3, DESCRICAO);
                stm.setDouble(4, PRV);
                stm.executeUpdate();
                m1.ShowMessagem("Produto cadastrado com sucesso!");
        } catch (SQLException e) {
                m1.ShowMessagem("Produto não foi cadastrado!");
                System.out.println(e);
        }
}

//Read na tabela de Pessoa
public boolean readPes(String CODIGO, boolean atu){
        ResultSet s;
        try {
                PreparedStatement stm = BD.prepareStatement("select * from pessoa where codigo = ?");
                stm.setString(1, CODIGO);
                s = stm.executeQuery();
                if(s.next() && atu) {
                        Cliente c1 = Cliente.get();
                        c1.setNome(s.getString("nome"));
                        c1.setCPF(s.getString("cpf"));
                        Funcionario f1 = Funcionario.get();
                        f1.setNome(s.getString("nome"));
                        f1.setCPF(s.getString("cpf"));
                        return true;
                }
                return false;
        } catch (SQLException e) {
                return false;
        }
}

public void updPes(String CODIGO, String NOME, String CPF){
        try {
                PreparedStatement stm = BD.prepareStatement("UPDATE pessoa SET nome = ?, CPF = ? WHERE codigo = ?");
                stm.setString(1, NOME);
                stm.setString(2, CPF);
                stm.setString(3, CODIGO);
                stm.executeUpdate();
                m1.ShowMessagem("Cadastro alterado com sucesso!");
        } catch (SQLException e) {
                System.out.println(e);
        }
}

public void commitPessoa(String CODIGO, String NOME, String CPF, String TIPO){
        try {
                PreparedStatement stm = BD.prepareStatement("INSERT INTO PESSOA VALUES (?, ?, ?, ?)");
                stm.setString(1, CODIGO);
                stm.setString(2, NOME);
                stm.setString(3, CPF);
                stm.setString(4, TIPO);
                stm.executeUpdate();
                m1.ShowMessagem("Cadastro efetuado com sucesso!");
        } catch (SQLException e) {
                m1.ShowMessagem("Cadastro não efetuado!");
                System.out.println(e);
        }
}

public void CommitCliente(String CODIGO, String NOME, String CPF){
        commitPessoa(CODIGO,NOME, CPF, "Cliente");
}

public void CommitFuncionario(String CODIGO, String NOME, String CPF){
        commitPessoa(CODIGO,NOME, CPF, "Funcionário");
}

public void deletePessoa(String CODIGO){
        try {
                PreparedStatement stm = BD.prepareStatement("DELETE FROM PESSOA WHERE codigo = ?");
                stm.setString(1, CODIGO);
                stm.executeUpdate();
                m1.ShowMessagem("Cadastro excluído com sucesso!");
        } catch (SQLException e) {
                System.out.println(e);
                m1.ShowMessagem("Erro");
        }
}

public double selectConta(String CODIGO){

        double total=0;
        try {
                PreparedStatement stm = BD.prepareStatement("select * from consumo where cliente = ?;");
                stm.setString(1, CODIGO);
                ResultSet s = stm.executeQuery();
                while (s.next()) {
                        total += getProPRV(s.getString("produto"));
                }
                return total;
        } catch (SQLException e) {
                System.out.println(e);
                return total;
        }




}

}
