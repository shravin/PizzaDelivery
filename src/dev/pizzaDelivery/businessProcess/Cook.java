package dev.pizzaDelivery.businessProcess;

import dev.pizzaDelivery.domain.Item;

public class Cook extends Thread 
{

	int cookId;
	Item item;
	int orderId;
	
	@Override
	public void run()  
	{
		try
		{
			System.out.println("Started cooking item from order id: " + orderId);
			this.wait(this.getItem().getEatable().getCookingTime() * 100);
			System.out.println("Cooked item from order id: " + orderId);
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public Cook(int cookId) 
	{
		super();
		this.cookId = cookId;
	}

	public Cook(Item item, int orderId) 
	{
		super();
		this.item = item;
		this.orderId = orderId;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getOrderId() {
		return orderId;
	}

	public int getCookId() {
		return cookId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
}
