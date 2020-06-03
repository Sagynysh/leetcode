package patterns.factory;

public class NYPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        if(type.equals("cheese")){
            return new NYSTylePizza();
        }else{
            return null;
        }
    }
}
