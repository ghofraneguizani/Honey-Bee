package models;

import java.awt.Point;
import java.util.Arrays;

import java.util.Collections;
import java.util.List;
import java.util.Random;


public class Flowers {
	private Point position;

	protected enum Flowerstate {
		normal, carnivore, poisoned
	};

	protected Flowerstate state;
	private boolean isalive = true;
	private int pollen = 100;
	private String imagePath;

	public Flowers() {

	}

	public Flowers(Point position, Flowerstate state, boolean isalive, int pollen, String imagePath) {
		super();
		this.position = position;
		this.state = state;
		this.isalive = isalive;
		this.pollen = pollen;
		this.imagePath = imagePath;
	}

	public Flowers(Point position, boolean isalive, int pollen) {
		super();
		this.position = position;
		this.isalive = isalive;
		this.pollen = pollen;
	}

	public Flowers(Point position) {
		super();
		this.position = position;
		this.state = Flowerstate.normal;
	}

	public Flowers(Point position, Flowerstate state) {

		this.position = position;
		this.state = state;
	}

	public Flowerstate getState() {
		return state;
	}

	public void setState(Flowerstate state) {
		this.state = state;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
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

	public static Flowerstate getFirststate() {
		List<Flowerstate> Values = Collections.unmodifiableList(Arrays.asList(Flowerstate.values()));
		Random rand = new Random();
		int n = rand.nextInt(Values.size());
		return Values.get(n);
	}

	public int decrementerPollen() { // decremente le nombre de pollen d'une fleur d'un nombre "cap"= capacite d'une
										// abeille
		int toStore = Math.min(Application.nectarPerFrame, this.pollen);
		this.pollen -= toStore;
		return toStore;

		/*
		 * int y = getPollen(); if(y>0 ){ setPollen( y-cap); }
		 */

	}

	@Override
	public String toString() {
		return "Flowers [position=" + position + ", state=" + state + ", isalive=" + isalive + ", pollen=" + pollen
				+ ", imagePath=" + imagePath + "]";
	}

}
