package dev.pizzaDelivery.businessProcess;

import dev.pizzaDelivery.domain.DrinkName;
import dev.pizzaDelivery.domain.FlavorType;
import dev.pizzaDelivery.domain.PizzaType;
import dev.pizzaDelivery.domain.Topping;

import java.util.Scanner;

public class Terminal implements Runnable 
{

	private final Store store;

	public Terminal(Store store)
	{
		this.store = store;
	}

	@Override
	public void run() 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to Pizza Delivery System: ");
		System.out.println("Place Order: ");

		int choice=0;
		int customerId = 0;
		Order order = new Order(customerId++);
		while (choice < 8)
		{
			System.out.println("1. Pizza  2. Bread  3. Drink  4. Cancel Order 5. Place Order 6. Print Order 7. Close Store");
			if (scanner.hasNext())
			{
				choice = scanner.nextInt();
				System.out.println("Selected Choice: "+ choice);
				switch(choice)
				{
					case 1:
						order.addLargePizza(PizzaType.THIN_CRUST, null, 1);
						break;

					case 2:
						order.addBread(Topping.CHEESE, FlavorType.GARLIC,1);
						break;

					case 3:
						order.addDrink(DrinkName.COKE, 1);
						break;

					case 5:
						store.getStoreManager().addOrder(order);
						order = new Order(customerId++);
						System.out.println("Size of orderlist: " + store.getStoreManager().getSize());

						if (store.isCloseStore())
						{
							System.out.println("Store is closed and hence exiting terminal...");
							return;
						}
						break;

					case 4:
						order.cancelAll();
						break;

					case 6:
						order.printOrder();
						break;
					case 7:
						try
						{
							store.getStoreManager().closeStore();
						} catch (InterruptedException e)
						{
							e.printStackTrace();
						}
						break;
				}
			}
		}
		System.out.println("Thank you for placing the order!!");
		scanner.close();
	}
}


