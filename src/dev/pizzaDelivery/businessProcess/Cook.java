package dev.pizzaDelivery.businessProcess;

import java.util.concurrent.BlockingQueue;

public class Cook extends Thread 
{
	private BlockingQueue<Order> orderForDelivery;
	int cookId;
	Order order;

	@Override
	public void run()  
	{
		try
		{
			System.out.println("Started cooking item from order id: " + order.getCustomerId());
			sleep(order.getTotalCookingTime() * 10);
			System.out.println("Cooked item from order id: " + order.getCustomerId());
			orderForDelivery.put(order);
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public Cook(Order order, BlockingQueue<Order> orderListForDelivery)
	{
		super();
		this.order = order;
		this.orderForDelivery = orderListForDelivery;
	}

	public void setOrder(Order order)
	{
		this.order = order;
	}
}
