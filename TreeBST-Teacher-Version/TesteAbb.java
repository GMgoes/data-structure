package ABB;

public class TesteAbb {

    public static void main(String[] args) {
        Abb<Integer> abbInteiros = new Abb<Integer>();

        //50, 30, 70, 20, 40, 60, 80, 15, 25, 35, 45, 36
        abbInteiros.adicionar(50);
        abbInteiros.adicionar(30);
        abbInteiros.adicionar(70);
        abbInteiros.adicionar(20);
        abbInteiros.adicionar(40);
        abbInteiros.adicionar(60);
        //System.out.println(abbInteiros.raiz.info);
        //System.out.println(abbInteiros.toString());
        abbInteiros.remover();
        System.out.println(abbInteiros.toString());


    }
}
