package dev.pizzaDelivery.businessProcess;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class StoreManager
{
    BlockingQueue<Order> orderListForCooking;
    BlockingQueue<Order> orderListForDelivery;

    static StoreManager storeManager;
    Thread cookingSchedulerThread;
    Thread deliverySchedulerThread;

    private boolean closeStore;
    private int countDown;

    private StoreManager()
    {
        orderListForCooking = new LinkedBlockingQueue<Order>();
        orderListForDelivery = new LinkedBlockingQueue<Order>();

        closeStore = false;
        cookingSchedulerThread = new Thread(new CookingScheduler(this));
        cookingSchedulerThread.start();

        deliverySchedulerThread = new Thread(new DeliveryScheduler(this));
        deliverySchedulerThread.start();

        countDown=0;
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
            orderListForCooking.put(order);
            countDown++;
            System.out.println("Size of order:" + getSize());
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public Order takeOrderForCooking()
    {
        try
        {
            Order order = orderListForCooking.poll(2, TimeUnit.SECONDS);
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

    public Order takeOrderForDelivery()
    {
        try
        {
            System.out.println("Size delivery: " + orderListForDelivery.size());
            Order order = orderListForDelivery.poll(2, TimeUnit.SECONDS);
            if (order != null)
            {
                countDown--;
                return order;
            }
            return null;
        } catch (InterruptedException e)
        {
            System.out.println("SOS 1");
            e.printStackTrace();
        }
        return null;
    }

    public int getSize()
    {
        return orderListForCooking.size();
    }

    public void closeStore() throws InterruptedException
    {
        closeStore = true;
        cookingSchedulerThread.join();
        deliverySchedulerThread.join();
    }

    public boolean isCloseStore()
    {
        return closeStore;
    }

    public int getCountDown()
    {
        return countDown;
    }
}
