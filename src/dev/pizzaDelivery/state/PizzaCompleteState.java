package dev.pizzaDelivery.state;

import dev.pizzaDelivery.domain.Pizza;

/**
 * Created by Ravin Somi on 3/26/16.
 */
public class PizzaCompleteState implements State
{
    private final Pizza pizza;

    public PizzaCompleteState(Pizza pizza)
    {
        this.pizza = pizza;
    }


    @Override
    public void nextPhase()
    {
        //do nothing as this is end of any state
    }

    @Override
    public void getState()
    {

    }
}
