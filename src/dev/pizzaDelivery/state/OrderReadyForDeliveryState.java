package dev.pizzaDelivery.state;

import dev.pizzaDelivery.businessProcess.Order;
import dev.pizzaDelivery.state.OrderOutForDeliveryState;
import dev.pizzaDelivery.state.State;

/**
 * Created by Ravin Somi on 3/26/16.
 */
public class OrderReadyForDeliveryState implements State
{
    private final Order order;

    public OrderReadyForDeliveryState(Order order)
    {
        this.order=order;
    }


    @Override
    public void nextPhase()
    {
        System.out.println("Out for delivery...");
        order.setState(new OrderOutForDeliveryState(order));
    }

    @Override
    public void getState()
    {

    }
}
