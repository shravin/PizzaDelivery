package dev.pizzaDelivery.businessProcess;

import java.util.List;

public class Orders 
{
	private static List<Order> orders;
	
	private Orders()
	{
		
	}
	
	public static boolean addOrder(Order order)
	{
		order.getState().nextPhase();
		orders.add(order);
		return true;
	}
}
