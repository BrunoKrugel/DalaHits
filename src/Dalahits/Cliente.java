
package Dalahits;


public class Cliente extends Pessoa {

private static Cliente instance = new Cliente();

private Cliente (){
}

public static Cliente get(){
        return instance;
}

public void CriaCliente(){
        CriaPessoa("Cliente");
}

public void GravaCadastro() {
        Commit c1 = Commit.get();
        c1.CommitCliente(efCod.getText(), efNom.getText(), efCPF.getText());
}
}
