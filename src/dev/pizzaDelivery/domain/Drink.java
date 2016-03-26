package dev.pizzaDelivery.domain;

public class Drink implements Eatable
{

	private DrinkName drinkName;

	public Drink(DrinkName name)
	{
		this.drinkName = name;
	}
	
	public double getPrice() 
	{
		return 10;
	}
	
	@Override
	public String getEatableType() 
	{
		return "Drink";
	}

	@Override
	public int getCookingTime() 
	{
		return 5;
	}


}

