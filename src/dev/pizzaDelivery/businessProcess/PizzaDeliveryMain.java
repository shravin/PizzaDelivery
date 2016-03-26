package dev.pizzaDelivery.businessProcess;

public class PizzaDeliveryMain
{

	public static void main(String[] args) throws InterruptedException 
	{
		Store store = new Store();
		store.startStore(1);
		store.closeStore();
	}

}
