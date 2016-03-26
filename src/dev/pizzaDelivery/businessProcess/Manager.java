package dev.pizzaDelivery.businessProcess;

public class Manager extends Thread 
{

	boolean closeStore = false;
	
	public void run() 
	{
		System.out.println("Waiting for order..");
		Order order = StoreManager.getInstance().takeOrder();
		System.out.println("Order procured..");
		Cook cook = CookPool.getInstance().getCook();
//		try
//		{
//			if (order != null && cook!=null)
//			{
//				System.out.println("Cook #" + cook.getCookId() + "is cooking: " + cook.getOrderId());;
////				cook.run(order);
//			}
//		}
//		catch (InterruptedException e)
//		{
//			e.printStackTrace();
//		}
		
		CookPool.getInstance().putCook(cook);
	}
	
//	@Override
//	public void start()
//	{
//		boolean stop = false;
//		while (!stop)
//		{
//			System.out.println("Manager: Running for order..");
//			run();
//			System.out.println("Manager: waiting " + "order size: " + StoreManager.getInstance().orderList.size());
//			
//			try 
//			{
////				this.wait((long) 5.0);
//				if (closeStore && StoreManager.getInstance().orderList.size() == 0)
//				{
//					System.out.println("Closing store");
//					stop=true;
//				}
//			} 
//			
//			catch (Exception e) 
//			{
//				e.printStackTrace();
//			}
//		}
//	}

	public void closeStore() 
	{
		this.closeStore=true;
	}

}
