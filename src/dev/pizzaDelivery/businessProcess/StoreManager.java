package dev.pizzaDelivery.businessProcess;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class StoreManager
{

    BlockingQueue<Order> orderList;
    List<Cook> availableCooks;
    List<Cook> deliveryStaff;
    static StoreManager storeManager;

    private StoreManager()
    {
        orderList = new LinkedBlockingQueue<Order>();
        availableCooks = new ArrayList<Cook>(3);
        deliveryStaff = new ArrayList<Cook>(3);
        for (int i=0;i<3;i++)
        {
            availableCooks.add(new Cook(i));
        }

    }

    public static StoreManager getInstance()
    {
        if (storeManager != null)
        {
            return storeManager;
        }
        storeManager = new StoreManager();
        return storeManager;

    }

    public void addOrder(Order order)
    {
        try
        {
            orderList.put(order);
            System.out.println("Size of order:" + getSize());
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public Order takeOrder()
    {
        try
        {
            Order order = orderList.poll(2, TimeUnit.SECONDS);
            if (order != null)
            {
                return order;
            }
            return null;
        } catch (InterruptedException e)
        {

            e.printStackTrace();
        }
        return null;
    }

    public int getSize()
    {
        return orderList.size();
    }

}
