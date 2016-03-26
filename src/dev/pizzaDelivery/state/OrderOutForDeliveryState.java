package dev.pizzaDelivery.state;

import dev.pizzaDelivery.businessProcess.Order;

/**
 * Created by Ravin Somi on 3/26/16.
 */
public class OrderOutForDeliveryState implements State
{
    private final Order order;

    public OrderOutForDeliveryState(Order order)
    {
        this.order = order;
    }

    @Override
    public void nextPhase()
    {
        System.out.println("Order Delivered...");
        order.setState(new OrderDeliveredState(order));
    }

    @Override
    public void getState()
    {

    }
}
