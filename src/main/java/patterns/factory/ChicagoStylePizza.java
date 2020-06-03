package patterns.factory;

public class ChicagoStylePizza extends Pizza {

    public ChicagoStylePizza(){
        name = "Chicago Style Sauce and Cheese Pizza";
        dough = "Extra thick";
        sauce = "Tomato Sauce";
        toppings.add("SHredded Mozarella cheese");
    }

    @Override
    void cut() {
        System.out.println("Pizza slice ");
    }
}
