package dev.pizzaDelivery.domain;

public class Item
{
	Eatable eatable;
	int qty;
	int reference;
	
	public Item(Eatable eatable, int qty) 
	{
		super();
		this.eatable = eatable;
		this.qty = qty;
	}
	public Eatable getEatable() {
		return eatable;
	}
	public void setEatable(Eatable eatable) {
		this.eatable = eatable;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
}
