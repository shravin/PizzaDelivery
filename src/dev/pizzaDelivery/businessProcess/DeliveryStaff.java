package dev.pizzaDelivery.businessProcess;

public class DeliveryStaff extends Thread
{
	int dsId;
	Order order;

	@Override
	public void run()
	{
		try
		{
			Order order = this.getOrder();
			order.getState().nextPhase();
			System.out.println("Out for delivery to customer with ID: " + order.getCustomerId());
			this.wait(order.getDeliveryTime() * 100);
			System.out.println("Delivered to customer with ID: " + order.getCustomerId());
			order.getState().nextPhase();
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public DeliveryStaff(int dsId)
	{
		super();
		this.dsId = dsId;
	}

	public DeliveryStaff(Order order)
	{
		super();
		this.order= order;
	}

	public int getDsId() {
		return dsId;
	}

	public Order getOrder()
	{
		return order;
	}
}
