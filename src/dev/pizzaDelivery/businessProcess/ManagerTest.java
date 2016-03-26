package dev.pizzaDelivery.businessProcess;

import dev.pizzaDelivery.domain.FlavorType;
import org.junit.Test;

import dev.pizzaDelivery.domain.PizzaType;
import dev.pizzaDelivery.domain.Topping;

public class ManagerTest {

	@Test
	public void testRun() 
	{
		final StoreManager storeManager = StoreManager.getInstance();

		Manager manager= new Manager();
		manager.start();
		
		for (int i=0;i<10;i++)
		{
			Order order = new Order(i);
			order.addBread(Topping.CHEESE, FlavorType.GARLIC, 1);
			order.addLargePizza(PizzaType.THIN_CRUST, null,1);
			storeManager.addOrder(order);
		}
		
		manager.closeStore();
		
		try
		{
			manager.join();
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	
	}

}
