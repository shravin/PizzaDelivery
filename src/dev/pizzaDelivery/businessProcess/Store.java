package dev.pizzaDelivery.businessProcess;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ravin Somi on 3/26/16.
 */
public class Store
{
    private StoreManager storeManager = StoreManager.getInstance();
    List<Thread> listOfTerminals;
    boolean closeStore = false;

    public void startStore(int terminals)
    {
        storeManager = StoreManager.getInstance();
        listOfTerminals = new ArrayList<Thread>(terminals);
        for (int i=0;i<terminals;i++)
        {
            Thread terminal = new Thread(new Terminal(this));
            listOfTerminals.add(terminal);
            terminal.start();
        }
    }

    public void closeStore(int terminals) throws InterruptedException
    {
        closeStore = true;
        for (int i=0;i<terminals;i++)
        {
            listOfTerminals.get(i).join();
        }
    }

    public StoreManager getStoreManager()
    {
        return storeManager;
    }

    public boolean isCloseStore()
    {
        return closeStore;
    }
}
