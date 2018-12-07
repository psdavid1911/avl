package avl;

public class main{

    public static void main(String args[]){
        No a = new No(10, 5, 15, 2, 14, 30, 1, 3, 35);
        a.imprime();
        a.equilibra();
        a.imprime();
        a.remove(10);
        a.imprime();
    }
}
