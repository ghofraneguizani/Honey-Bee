package com.polytech.projet.classes;

public class Flowers {
	private int x; 
	private int y; 
	private enum state {normal , carnivore , poisoned} ;
	private boolean isalive = true; 
	private int pollen= 100; 
	private String imagePath; 
	
	

	public Flowers() {
		
	}



	public Flowers(int x, int y, boolean isalive, int pollen, String imagePath) {
		super();
		this.x = x;
		this.y = y;
		this.isalive = isalive;
		this.pollen = pollen;
		this.imagePath = imagePath;
	}



	public int getX() {
		return x;
	}



	public void setX(int x) {
		this.x = x;
	}



	public int getY() {
		return y;
	}



	public void setY(int y) {
		this.y = y;
	}



	public boolean isIsalive() {
		return isalive;
	}



	public void setIsalive(boolean isalive) {
		this.isalive = isalive;
	}



	public int getPollen() {
		return pollen;
	}



	public void setPollen(int pollen) {
		this.pollen = pollen;
	}



	public String getImagePath() {
		return imagePath;
	}



	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	
	public void décrementerPollen(int cap){ // décrémente le nombre de pollen d'une fleur  d'un nombre "cap"= capacité d'une abeille 
		
		int y = getPollen();
		if(y>0 ){
			setPollen( y-cap);
		}
		
	}
	

}
