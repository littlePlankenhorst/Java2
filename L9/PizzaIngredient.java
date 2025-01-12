
import java.awt.*;

abstract class PizzaIngredient implements Pizza {
    protected Pizza pizza;
    @Override
    public String getIngredients() {return pizza.getIngredients();}
    @Override
    public void bake(Graphics g) {pizza.bake(g);}
    @Override
    public int getPrice() {return pizza.getPrice();}
    public PizzaIngredient(Pizza pizza) {this.pizza = pizza;}
}
