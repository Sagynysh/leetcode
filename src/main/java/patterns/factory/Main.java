package patterns.factory;

public class Main {
    public static void main(String[] args) {

        PizzaStore ps = new NYPizzaStore();
        Pizza pizza1 = ps.orderPizza("cheese");
        System.out.println(pizza1.getName());

        PizzaStore ps2 = new ChicagoPizzaStore();
        Pizza pizza2 = ps2.orderPizza("cheese");
        System.out.println(pizza2.getName());



    }
}
