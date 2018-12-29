package com.polytech.projet.classes;

public class Forager extends Bees{
	
	
	protected enum foragerState  {lookfor , onway , collecting, wayback } ;
	private foragerState state; 

	public Forager() {
		
		
	}

	public foragerState getState() {
		return state;
	}

	public void setState(foragerState state) {
		this.state = state;
	}
	

	
	
	

}
