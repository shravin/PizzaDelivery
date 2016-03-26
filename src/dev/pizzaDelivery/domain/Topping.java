package dev.pizzaDelivery.domain;

public enum Topping 
{
		
	CHEESE(1),TOMATO(2);
	
	private int value;
	 
	private Topping(int value) {
		this.setValue(value);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}

