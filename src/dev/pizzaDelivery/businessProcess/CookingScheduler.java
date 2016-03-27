package dev.pizzaDelivery.businessProcess;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class CookingScheduler implements Runnable
{
    private StoreManager storeManager;
    ThreadPoolExecutor executor;
    BlockingQueue blockingQueue;

    public CookingScheduler(StoreManager storeManager)
    {
        this.storeManager = storeManager;
        blockingQueue = new LinkedBlockingQueue(3);
        executor = new ThreadPoolExecutor(3,3,(long)10, TimeUnit.MINUTES, blockingQueue);
    }

    @Override
    public void run()
    {
        System.out.println("Inside cooking scheduler...");

        try
        {
            while (!storeManager.isCloseStore())
            {
                scheduleCooking();
            }
            scheduleCooking();
            executor.shutdown();
            executor.awaitTermination(10, TimeUnit.MINUTES);
        }

        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    private void scheduleCooking() throws InterruptedException
    {
        while (!storeManager.orderListForCooking.isEmpty())
        {
            Order order = storeManager.takeOrderForCooking();
            assignOrderToCook(order);
        }
    }

    private void assignOrderToCook(Order order) throws InterruptedException
    {
        Cook cook = new Cook(order, storeManager.orderListForDelivery);
        executor.execute(cook);
    }
}
