package dev.pizzaDelivery.businessProcess;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class DeliveryScheduler implements Runnable
{
    private StoreManager storeManager;
    ThreadPoolExecutor executor;
    BlockingQueue blockingQueue;
    int countDown;

    public DeliveryScheduler(StoreManager storeManager)
    {
        this.storeManager = storeManager;
        blockingQueue = new LinkedBlockingQueue(3);
        executor = new ThreadPoolExecutor(3,3,(long)1, TimeUnit.MINUTES, blockingQueue);
        countDown=0;
    }

    @Override
    public void run()
    {
        System.out.println("Inside delivery scheduler...");
        try
        {
            while (!storeManager.isCloseStore())
            {
                scheduleDeliveries();
            }
            scheduleDeliveries();
            executor.shutdown();
            executor.awaitTermination(10, TimeUnit.MINUTES);
        }
        catch (InterruptedException e)
        {
            System.out.println("SOS");
            e.printStackTrace();
        }
    }

    private void scheduleDeliveries() throws InterruptedException
    {
        while (!storeManager.orderListForDelivery.isEmpty() || storeManager.getCountDown() > 0)
        {
            Order order = storeManager.takeOrderForDelivery();
            assignOrderToDeliver(order);
        }
    }

    private void assignOrderToDeliver(Order order) throws InterruptedException
    {
        System.out.println("assign order to deliver");
        if (order != null)
        {
            DeliveryMan deliveryMan = new DeliveryMan(order);
            executor.execute(deliveryMan);
        }
    }
}
