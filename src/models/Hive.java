package models;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hive {
	private long pollen;
	protected static List<Forager> lForager;
	protected static List<Forager> lForagerMorts;
	protected Garden garden;
	protected Point positionHive;
	protected Point positionHiveDoor;
	private Queen queen; // pour les abeilles

	private int foragersAtAll;
	private static final int foragerLiveTime = 100;

	public Hive() {
		lForager = new ArrayList<>();
		lForagerMorts = new ArrayList<>();
	}

	public Hive(Garden garden, Point positionHive) {
		pollen = 0;
		this.garden = garden;
		this.positionHive = positionHive;
		this.positionHiveDoor = new Point(positionHive);
		positionHiveDoor.setLocation(positionHiveDoor.getX()+20, positionHiveDoor.getY()+60);
		queen = new Queen(this);
	}

	public int getForagersAtAll() {
		return foragersAtAll;
	}

	public void setForagersAtAll(int foragersAtAll) {
		this.foragersAtAll = foragersAtAll;
	}

	public List<Forager> getlForagerMorts() {
		return lForagerMorts;
	}

	public void setlForagerMorts(List<Forager> lForagerMorts) {
		Hive.lForagerMorts = lForagerMorts;
	}

	public long getPollen() {
		return pollen;
	}

	public void setPollen(long pollen) {
		this.pollen = pollen;
	}

	public Point getPositionHive() {
		return positionHive;
	}

	public void setPositionHive(Point positionHive) {
		this.positionHive = positionHive;
	}

	public Point getPositionHiveDoor() {
		return positionHiveDoor;
	}

	public void setPositionHiveDoor(Point positionHiveDoor) {
		this.positionHiveDoor = positionHiveDoor;
	}

	public List<Forager> getlForager() {
		return lForager;
	}

	public void setlForager(List<Forager> lForager) {
		this.lForager = lForager;
	}

	public void incrementerPollen(int cap) {
		setPollen(getPollen() + cap);
	}

	public int getRandomLiveTime() {
		Random rand = new Random();
		int output = rand.nextInt((int)foragerLiveTime/3);
		return output;
	}

	public void createForagers(int nbBees) {
//		System.out.println("in the Hive, creating foragers");
		// Flowers fleur = new Flowers();

		for (int i = 0; i < nbBees; i++) {
			int liveTime = this.getRandomLiveTime();
			// fleur = findFlower();
			Forager f = new Forager(null, new Point(positionHiveDoor), this, liveTime,"img/icons8-abeille-48.png");
			//Forager f = new Forager(null,new Point(positionHive),this, liveTime,
			System.out.println(f);
			lForager.add(f);
			foragersAtAll++;
		}
	}

	public Flowers findFlower() {// algo qui va retourner la position des fleurs
		int taille = Garden.fleurs.size();
		Random rand = new Random();
		int n = rand.nextInt(taille); 
		return Garden.fleurs.get(n);
	}

	public void nextFrame() {
		System.out.println("we are in the Hive");
		queen.nextFrame(); // nouvelle abeille
//		System.out.println("number of foragers (before loop): " + lForager.size());

		// int counter = 1;
		for (Forager forager : lForager) {
			if (forager.isalive == true) {
				forager.nextFrame();
			}
			// counter++;
		}
		for (int i = lForager.size() - 1; i >= 0; i--) {
			if (lForager.get(i).isalive == false) {
				this.getlForagerMorts().add(lForager.get(i));
				this.getlForager().remove(lForager.get(i));
			}
		}
		for (int i = lForager.size() - 1; i >= 0; i--) {
			lForager.get(i).setLiveTime(lForager.get(i).getLiveTime() + 1); // l'abeille vieillit
			if (lForager.get(i).getLiveTime() >= foragerLiveTime) {
				this.getlForagerMorts().add(lForager.get(i));
				this.getlForager().remove(lForager.get(i)); 
				// l'abeille meurt
			}
		}
//		System.out.println("number of foragers (after loop): " + lForager.size());
//		System.out.println("collected Pollen: " + this.pollen);
		
		
	}

}
