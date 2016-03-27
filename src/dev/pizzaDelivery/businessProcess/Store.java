package dev.pizzaDelivery.businessProcess;

import java.util.ArrayList;
import java.util.List;

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

    public void closeStore() throws InterruptedException
    {
        closeStore = true;
        for (Thread listOfTerminal : listOfTerminals)
        {
            listOfTerminal.join();
        }
        storeManager.closeStore();
    }

    StoreManager getStoreManager()
    {
        return storeManager;
    }

    boolean isCloseStore()
    {
        return closeStore;
    }

}
