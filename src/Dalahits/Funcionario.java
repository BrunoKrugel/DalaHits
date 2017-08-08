
package Dalahits;


public class Funcionario extends Pessoa {

private static Funcionario instance = new Funcionario();

private Funcionario (){
}

public static Funcionario get(){
        return instance;
}

public void CriaFuncionario(){
        CriaPessoa("Funcionario");
}

public void GravaCadastro() {
        Commit c1 = Commit.get();
        c1.CommitFuncionario(efCod.getText(), efNom.getText(), efCPF.getText());
}

}
