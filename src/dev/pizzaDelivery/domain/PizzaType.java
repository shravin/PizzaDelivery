package dev.pizzaDelivery.domain;

public enum PizzaType 
{
		
	THIN_CRUST(1),THICK_CRUST(2);
	
	private int value;
	 
	private PizzaType(int value) {
		this.setValue(value);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
