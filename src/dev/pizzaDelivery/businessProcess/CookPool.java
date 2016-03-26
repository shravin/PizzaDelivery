package dev.pizzaDelivery.businessProcess;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CookPool
{
	BlockingQueue<Cook> availableCooks;
	static CookPool cookPool;
	
	int size;
	
	private CookPool()
	{
		
	}
	
	public static CookPool getInstance()
	{
		if (cookPool == null) 
			return new CookPool(2);
		return cookPool;
	}
	
	
	
	private CookPool(int size) 
	{
		super();
		this.size = size;
		this.availableCooks = new LinkedBlockingQueue<>();
		for (int i=0; i<size; i++)
		{
			this.availableCooks.add(new Cook(i));
		}
	}
	
	public Cook getCook()
	{
		try 
		{
			return availableCooks.take();
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean putCook(Cook cook)
	{
		return availableCooks.add(cook);
	}
	
	public boolean freeCook()
	{
		 return true;
	}

}
