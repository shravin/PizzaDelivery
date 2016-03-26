package dev.pizzaDelivery.state;

import dev.pizzaDelivery.domain.Pizza;

public interface State
{
    void nextPhase();
    void getState();
}
