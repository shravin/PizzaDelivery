package dev.pizzaDelivery.state;

import dev.pizzaDelivery.domain.Pizza;

/**
 * Created by Ravin Somi on 3/26/16.
 */
public class PizzaInitialState implements State
{
    Pizza pizza;

    public PizzaInitialState(Pizza pizza)
    {
        this.pizza = pizza;
    }

    @Override
    public void nextPhase()
    {
        System.out.println("Baking...");
        pizza.setState(new PizzaCookedState(pizza));
    }

    @Override
    public void getState()
    {

    }
}
