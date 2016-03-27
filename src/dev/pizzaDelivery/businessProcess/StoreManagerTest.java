package dev.pizzaDelivery.businessProcess;

import org.junit.Test;

public class StoreManagerTest
{
    @Test
    public void test() throws InterruptedException
    {
        StoreManager storeManager = StoreManager.getInstance();
        storeManager.addOrder(new Order(1));
        storeManager.addOrder(new Order(2));
//        assertEquals(2, storeManager.getSize());
        storeManager.closeStore();
    }
}
