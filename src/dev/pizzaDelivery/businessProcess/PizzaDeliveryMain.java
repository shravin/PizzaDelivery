package dev.pizzaDelivery.businessProcess;

public class PizzaDeliveryMain
{

	public static void main(String[] args) throws InterruptedException 
	{

		System.out.println("Starting Terminal...");
		Thread terminal = new Thread(new Terminal());
		terminal.start();
		
		System.out.println("Started System...");
		Thread manager = new Thread(new Manager());
		manager.start();
		manager.join();
	}

}
