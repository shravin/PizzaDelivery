package dev.pizzaDelivery.businessProcess;

import dev.pizzaDelivery.domain.*;
import dev.pizzaDelivery.state.OrderInitialState;
import dev.pizzaDelivery.state.State;

import java.util.ArrayList;
import java.util.List;


public class Order 
{
	int customerId;
	List<Item> eatables;
	float price;
	int lastReference;
	private State state;


	public int getCustomerId() {
		return customerId;
	}


	public Order(int customerId) 
	{
		super();
		this.customerId = customerId;
		this.lastReference =0;
		this.eatables = new ArrayList<Item>();
		this.setState(new OrderInitialState(this));
	}

	public Order createOrder(int customerId)
	{
		return new Order(customerId);
	}
	
	public boolean placeOrder()
	{
		return Orders.addOrder(this);
	}
	
	public void addLargePizza(PizzaType type, List<Topping> toppings, int quantity)
	{
		this.eatables.add(new Item(Pizza.createLargePizzaWith(type, toppings), quantity));
	}

	public void addBread(Topping topping, FlavorType flavor, int quantity)
	{
		this.eatables.add(new Item(new Bread(topping, flavor), quantity));
	}
	
	public void addDrink(DrinkName drink, int quantity)
	{
		if (isQuantityGreaterThanZero(quantity))
		{
			this.eatables.add(new Item(new Drink(drink), quantity));
		}
	}
	
	private boolean isQuantityGreaterThanZero(int quantity) 
	{
		return quantity > 0;
	}

	public void remove(int reference)
	{
		this.eatables.remove(reference);
	}

	public void cancelAll() 
	{
		this.eatables = new ArrayList<Item>();
		
	}
	
	public void printOrder()
	{
		int i=0;
		for (Item eatable : this.eatables)
		{
			System.out.println(i);
			System.out.println("Quantity: " + eatable.getQty());
			System.out.println("Type: " + eatable.getEatable().getEatableType());
			
		}
		System.out.println("Total cost is: " + getTotalCost());
	}

	private double getTotalCost() 
	{
		double cost=0;
		for (Item eatable : this.eatables)
		{
			cost = cost + eatable.getEatable().getPrice();
		}
		return cost;
	}

	public long getTotalCookingTime()
	{
		long time=0;
		for (Item eatable : this.eatables)
		{
			time = time + eatable.getEatable().getCookingTime();
		}
		return time;
	}


	public List<Item> getEatables() 
	{
		return this.eatables;
	}

	public void setState(State state)
	{
		this.state = state;
	}

	public State getState()
	{
		return state;
	}

	public int getDeliveryTime()
	{
		return 10;
	}
}
