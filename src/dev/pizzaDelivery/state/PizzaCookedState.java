package dev.pizzaDelivery.state;

import dev.pizzaDelivery.domain.Pizza;

/**
 * Created by Ravin Somi on 3/26/16.
 */
public class PizzaCookedState implements State
{
    Pizza pizza;
    public PizzaCookedState(Pizza pizza)
    {
        this.pizza = pizza;
    }

    @Override
    public void nextPhase()
    {
        System.out.println("Out For Delivery...");
        pizza.setState(new PizzaCompleteState(pizza));
    }

    @Override
    public void getState()
    {

    }
}
