package dev.pizzaDelivery.state;

import dev.pizzaDelivery.businessProcess.Order;

/**
 * Created by Ravin Somi on 3/26/16.
 */
public class OrderPlacedState implements State
{
    private final Order order;

    public OrderPlacedState(Order order)
    {
        this.order = order;
    }

    @Override
    public void nextPhase()
    {
        System.out.println("Ready for delivery state...");
        order.setState(new OrderReadyForDeliveryState(order));
    }

    @Override
    public void getState()
    {

    }
}
