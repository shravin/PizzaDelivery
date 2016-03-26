package dev.pizzaDelivery.businessProcess;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StoreManagerTest
{
    @Test
    public void test()
    {
        StoreManager.getInstance().addOrder(new Order(1));
        StoreManager.getInstance().addOrder(new Order(2));
        assertEquals(2, StoreManager.getInstance().getSize());
    }

}
