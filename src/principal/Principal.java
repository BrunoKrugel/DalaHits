/*
Observações:

*/
package principal;

import Dalahits.*;

public class Principal {

public static void main(String args[]) {
    Login l1 = new Login();
// Chama a tela de Login
    Commit c1 = Commit.get();
    c1.Connect();
    l1.CriaJanela();
    }
}
