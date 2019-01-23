package project;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hive {
	private long pollen;
	protected static List<Forager> lForager;
	protected Garden garden;
	protected Point positionHive;
	private Queen queen; // pour les abeilles

	public Hive() {
		lForager = new ArrayList<>();
	}

	public Hive(Garden garden, Point positionHive) {
		pollen = 0;
		this.garden = garden;
		this.positionHive = positionHive;
		queen = new Queen(this);
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

	public List<Forager> getlForager() {
		return lForager;
	}

	public void setlForager(List<Forager> lForager) {
		this.lForager = lForager;
	}

	public void incrementerPollen(int cap) {
		setPollen(getPollen() + cap);
	}

	public void createForagers(int nbBees) {
		Flowers fleur = new Flowers();

		for (int i = 0; i < nbBees; i++) {
			fleur = findFlower();
			Forager f = new Forager(fleur, positionHive, this);
			System.out.println(f);
			lForager.add(f);
		}
	}

	public Flowers findFlower() {// algo qui va retourner la position des fleurs
		int taille = Garden.fleurs.size();
		Random rand = new Random();
		int n = rand.nextInt(taille - 1); // je pense c'est pas taille-1, c'est taille (le-1 est automatique avec random
		return Garden.fleurs.get(n);
	}

	public void nextFrame() {
		for (Forager forager : lForager) {
			if (forager.isalive == true) {
				forager.nextFrame();
			}
		}
		queen.createNewForager(); // nouvelle abeille
	}

}
