package dev.pizzaDelivery.domain;

public class Bread implements Eatable
{

	Topping topping;
	FlavorType flavor;
	
	
	
	public Bread(Topping topping, FlavorType flavor) 
	{
		super();
		this.topping = topping;
		this.flavor = flavor;
	}



	@Override
	public double getPrice() 
	{
		return 5;
	}

	@Override
	public String getEatableType() 
	{
		return "Bread";
	}
	
	@Override
	public int getCookingTime() 
	{
		return 30;
	}

}
