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
	private Queen queen;

	private int foragersAtAll;
	private static final int foragerLiveTime = 100;
	private static final int foragerDeathTime = 100;

	public Hive() {
		lForager = new ArrayList<>();
		lForagerMorts = new ArrayList<>();
	}

	public Hive(Garden garden, Point positionHive) {
		pollen = 0;
		this.garden = garden;
		this.positionHive = positionHive;
		this.positionHiveDoor = new Point(positionHive);
		positionHiveDoor.setLocation(positionHiveDoor.getX() + 20, positionHiveDoor.getY() + 60);
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
		Hive.lForager = lForager;
	}

	public void incrementerPollen(int cap) {
		setPollen(getPollen() + cap);
	}

	// Méthode pour varier l'âge des abeilles au début du jeu
	public int getRandomLiveTime() {
		Random rand = new Random();
		int output = rand.nextInt((int) foragerLiveTime / 3);
		return output;
	}

	// Méthode pour créer les abeilles au début du jeu
	public void createForagers(int nbBees) {

		for (int i = 0; i < nbBees; i++) {
			int liveTime = this.getRandomLiveTime();
			Forager f = new Forager(null, new Point(positionHiveDoor), this, liveTime);
			lForager.add(f);
			foragersAtAll++;
		}
		for (Forager f : lForager) {
			System.out.println(f);
		}
	}

	// Méthode pour trouver une fleur pour l'abeille sur laquelle elle vole pour
	// collecter le pollen
	public Flowers findFlower() {// algo qui va retourner la position des fleurs
		int taille = Garden.fleurs.size();
		Random rand = new Random();
		int n = rand.nextInt(taille);
		return Garden.fleurs.get(n);
	}

	public void nextFrame() {
		queen.nextFrame();

		for (Forager forager : lForager) {
			if (forager.isalive == true) {
				forager.nextFrame();
			}
		}
		// supprimer les abeilles mortes (mortes au combat) de la liste des abeilles
		// vivantes et les ajouter à la liste des abeilles mortes
		for (int i = lForager.size() - 1; i >= 0; i--) {
			if (lForager.get(i).isalive == false) {
				this.getlForagerMorts().add(lForager.get(i));
				this.getlForager().remove(lForager.get(i));
			}
		}
		// supprimer les abeilles mortes (mourantes de vieillesse) de la liste des
		// abeilles vivantes et les ajouter à la liste des abeilles mortes
		for (int i = lForager.size() - 1; i >= 0; i--) {
			lForager.get(i).setLiveTime(lForager.get(i).getLiveTime() + 1);
			if (lForager.get(i).getLiveTime() >= foragerLiveTime) {
				this.getlForagerMorts().add(lForager.get(i));
				this.getlForager().remove(lForager.get(i));
			}
		}
		//	supprimer les abeilles mortes de la liste si elles sont pourries
		for (int i = lForagerMorts.size() -1; i >= 0; i--) {
			lForagerMorts.get(i).setDeathTime(lForagerMorts.get(i).getDeathTime() + 1);
			if (lForagerMorts.get(i).getDeathTime() >= foragerDeathTime) {
				this.getlForagerMorts().remove(lForagerMorts.get(i));
			}
		}

	}

}
