package dev.pizzaDelivery.domain;

import java.util.List;

import dev.pizzaDelivery.state.PizzaInitialState;
import dev.pizzaDelivery.state.State;

public class Pizza implements Eatable
{
	PizzaType type;
	List<Topping> toppings;
	int size;
	State state;
	
	private Pizza()
	{
		
	}
	
	private Pizza(PizzaType type, List<Topping> toppings)
	{
		this.type = type;
		this.toppings =toppings;
		this.initializePizzaState();
	}

	private void initializePizzaState()
	{
		this.state =new PizzaInitialState(this);
	}

	public static Pizza createLargePizzaWith(PizzaType type, List<Topping> toppings)
	{
		return new Pizza(type, toppings);
	}

	public double getPrice() 
	{
		return 30.0;
	}

	@Override
	public String getEatableType() 
	{
		return "Pizza";
	}

	@Override
	public int getCookingTime() 
	{
		return 60;
	}
	
	public State getState()
	{
		return this.state;
	}

	public void setState(State state)
	{
		this.state = state;
	}



}
