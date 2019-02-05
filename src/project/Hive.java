package project;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hive {
	private long pollen;
	protected static List<Forager> lForager;
	private int maxLiveTimeForager = 500;

	protected Garden garden;
	protected Point positionHive;
	private Queen queen; 			// pour les abeilles

	private int foragersAtAll;			//une variable pour voir à la fin du jeu combien d'abeilles étaient dans le jeu au total

	public Hive() {
		lForager = new ArrayList<>();
	}

	public Hive(Garden garden, Point positionHive) {
		pollen = 0;
		this.garden = garden;
		this.positionHive = positionHive;
		queen = new Queen(this);
	}

	public int getForagersAtAll() {
		return foragersAtAll;
	}

	public void setForagersAtAll(int foragersAtAll) {
		this.foragersAtAll = foragersAtAll;
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

	public int getRandomLiveTime() {				//un nombre aléatoire, de sorte qu'au début toutes les abeilles n'ont pas le même âge
		Random rand = new Random();
		int output = rand.nextInt(this.maxLiveTimeForager/2);
		return output;
	}

	public void createForagers(int nbBees) {					//la méthode pour commencer à créer les abeilles
		System.out.println("in the Hive, creating foragers");

		for (int i = 0; i < nbBees; i++) {
			int liveTime = this.getRandomLiveTime();
			Forager f = new Forager(null, new Point(positionHive), this, liveTime);
			System.out.println(f);
			lForager.add(f);
			foragersAtAll++;
		}
	}

	public Flowers findFlower() {		// algo qui va retourner la position des fleurs
		int taille = Garden.fleurs.size();
		Random rand = new Random();
		int n = rand.nextInt(taille); 
		return Garden.fleurs.get(n);
	}

	public void nextFrame() {
		queen.nextFrame(); 		
		System.out.println("number of foragers (before loop): " + lForager.size());

		for (Forager forager : lForager) {
			if (forager.isalive == true) {
				forager.nextFrame();
			}
		}		
		for (int i = lForager.size() - 1; i >= 0; i--) {    	//retirer les abeilles mortes de la liste
			if (lForager.get(i).isalive == false)
				this.getlForager().remove(lForager.get(i));
		}
		for (int i = lForager.size() - 1; i >= 0; i--) {		//retirer les abeilles mortes de la liste
			lForager.get(i).setLiveTime(lForager.get(i).getLiveTime() + 1); // l'abeille vieillit
			if (lForager.get(i).getLiveTime() >= this.maxLiveTimeForager) {
				this.getlForager().remove(lForager.get(i)); 
			}
		}
		System.out.println("number of foragers (after loop): " + lForager.size());
		System.out.println("collected Pollen: " + this.pollen);
		if (lForager.size() == 0) {										//afficher les résultats à la fin de la jeu (il ne reste plus des abeilles) 
			System.out.println("number of foragers in the game: " + this.getForagersAtAll());
			System.out.println("number of collected pollen: " + this.getPollen());
		}
	}

}
