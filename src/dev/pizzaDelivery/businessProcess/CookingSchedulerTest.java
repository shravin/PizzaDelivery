package dev.pizzaDelivery.businessProcess;

import org.junit.Test;

/**
 * Created by Ravin Somi on 3/27/16.
 */
public class CookingSchedulerTest
{
    @Test
    public void testRun() throws Exception
    {
        Thread thread = new Thread(new CookingScheduler(StoreManager.getInstance()));
        thread.start();
    }
}