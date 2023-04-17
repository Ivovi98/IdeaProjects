/*
Implementare la classe Panino, il cui metodo addIngrediente aggiunge un ingrediente, scelto da
un elenco fisso. Gli ingredienti sono divisi in categorie. Se si tenta di aggiungere più di un
ingrediente della stessa categoria, il metodo addIngrediente solleva un’eccezione.
Elenco delle categorie e degli ingredienti:
ripieni: PROSCIUTTO, SALAME
formaggi: SOTTILETTA, MOZZARELLA
salse: MAIONESE, SENAPE
 */
package org.panini;
public class MainPanino {
    public static void main(String[] args) throws GiaPresente {
        Ingredienti i1 = new Ingredienti(Ingredienti.Salse.KETCHUP,
                Ingredienti.Ripieni.SALAME,Ingredienti.Formaggi.MOZZARELLA); //Solo se aggiungo una composizione interamente uguale allora andrà in exception
        Ingredienti i2 = new Ingredienti(Ingredienti.Salse.MAIONESE,
                Ingredienti.Ripieni.PORCHETTA,Ingredienti.Formaggi.SOTTILETTA);
        Panino p1 = new Panino();
        p1.addIngrediente(i1);
        p1.addIngrediente(i2);
        p1.stampaPanino();
    }
}
/*
Component cpu1 = new Component(Type.CPU, "Ryzen␣5␣2600"),
                cpu2 = new Component(Type.CPU, "Core␣i5␣7500"),
                board1 = new Component(Type.BOARD, "Prime␣X470"),
                board2 = new Component(Type.BOARD, "Prime␣Z370"),
                ram = new Component(Type.RAM, "DDR4␣8GB");
                cpu1.setIncompatible(board2);
                board1.setIncompatible(cpu2);
                Configuration pc = new Configuration();
                System.out.println(pc.add(cpu1));
                //System.out.println(pc.add(cpu2)); // due cpu!
                System.out.println(pc.add(board2)); // incompatibile!
                //System.out.println(pc.add(board1));
                //System.out.println(pc.add(ram));
 */