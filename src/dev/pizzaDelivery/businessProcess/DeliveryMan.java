package dev.pizzaDelivery.businessProcess;

public class DeliveryMan extends Thread
{

	Order order;

	public DeliveryMan(Order order)
	{
		this.order = order;
	}

	@Override
	public void run()
	{
		try
		{
			System.out.println("Started delivering item from order id: " + order.getCustomerId());
			sleep(order.getDeliveryTime() * 10);
			System.out.println("Delivered item from order id: " + order.getCustomerId());
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void setOrder(Order order)
	{
		this.order = order;
	}
}
