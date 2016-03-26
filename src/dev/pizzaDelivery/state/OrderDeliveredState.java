package dev.pizzaDelivery.state;

import dev.pizzaDelivery.businessProcess.Order;

/**
 * Created by Ravin Somi on 3/26/16.
 */

public class OrderDeliveredState implements State
{
    private final Order order;

    public OrderDeliveredState(Order order)
    {
        this.order = order;
    }

    @Override
    public void nextPhase()
    {
        //do nothing as this is end of the state
    }

    @Override
    public void getState()
    {

    }
}
