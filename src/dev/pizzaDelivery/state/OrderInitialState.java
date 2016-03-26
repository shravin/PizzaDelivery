package dev.pizzaDelivery.state;

import dev.pizzaDelivery.businessProcess.Order;

/**
 * Created by Ravin Somi on 3/26/16.
 */
public class OrderInitialState implements State
{
    private final Order order;

    public OrderInitialState(Order order)
    {
        this.order = order;
    }

    @Override
    public void nextPhase()
    {
        System.out.println("Placing the order....");
        order.setState(new OrderPlacedState(order));
    }

    @Override
    public void getState()
    {

    }
}
