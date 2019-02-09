package models;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import ihm.FinFenetre;
import models.Flowers.Flowerstate;

public class Garden {
	protected static ArrayList<Flowers> fleurs;
	protected static ArrayList<Flowers> fleursMortes;
	protected Hive ruche;
	private Point point;
	private int rounds = 0;

	public Garden() {
		fleurs = new ArrayList<>();
		fleursMortes = new ArrayList<>();
		point = new Point();
		ruche = new Hive();
	}

	public Garden(Hive ruche) {

		this.ruche = ruche;

	}

	public void addFlower(Flowers f) {
		fleurs.add(f);
	}

	public static ArrayList<Flowers> getFleurs() {
		return fleurs;
	}

	public static ArrayList<Flowers> getFleursMortes() {
		return fleursMortes;
	}

	public static void setFleursMortes(ArrayList<Flowers> fleursMortes) {
		Garden.fleursMortes = fleursMortes;
	}

	public static void setFleurs(ArrayList<Flowers> fleurs) {
		Garden.fleurs = fleurs;
	}

	public Hive getRuche() {
		return ruche;
	}

	public void setRuche(Hive ruche) {
		this.ruche = ruche;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public Point getPos(int width, int height) {
		//Hive area:
		int xLes = ((int)(width/2)-80);
		int xMore = ((int)(width/2)+120);
//		System.out.println("xLes and xMore : " + xLes + " / " + xMore);
		int yLes = ((int)(height/2)-80);
		int yMore = ((int)(height/2)+120);
//		System.out.println("yLes and yMore : " + yLes + " / " + yMore);

	
		int x = 0;
		int y = 0;
		Boolean pointOk = true;
		Point p;
		Random rand = new Random();
		while (pointOk) {
			pointOk = false;
			x = rand.nextInt(width - 60);
			y = rand.nextInt(height - 60);
			if (xLes < x && x < xMore && yLes < y && y < yMore) {
				pointOk = true;
				System.out.println("extra round" + x + " / " + y);
			}

		}

		p = new Point(x+10, y+10);
		return p;
	}

	public Boolean existe(Point po) {
		for (Flowers flower : fleurs) {
			if (flower.getPosition().equals(po)) {
				return true;
			}
		}
		return false;
	}

	public int getState(int nbFlowers) {
		return (nbFlowers / 10);
	}

	public void createFlowers(int nbFlowers, int width, int height) {
//		System.out.println("in the garden, creating flowers");

		boolean condition;
		Flowers f;

		for (int i = 0; i < nbFlowers; i++) {
			point = getPos(width, height);
			boolean runWhile = true;
			while (runWhile) {
				condition = existe(point);
				if (condition) {
					point = getPos(width, height);
				} else
					runWhile = false;
			}
			f = new Flowers(point);
			fleurs.add(f);
		}

		int s = getState(nbFlowers);
		for (int i = 0; i < s; i = i + 2) {
			fleurs.get(i).setState(Flowerstate.carnivore);
			fleurs.get(i + 1).setState(Flowerstate.poisoned);
		}
		for (Flowers flower : fleurs)
			System.out.println(flower);
	}

	public void nextFrame() {// minuteSuivante
		System.out.println("we are in the garden");
		this.rounds++;
		this.ruche.nextFrame();
		System.out.println("we are back!! in the garden");


		for (int i = 0; i < fleurs.size(); i++) {
			if (fleurs.get(i).getPollen() == 0) {
				fleurs.get(i).setIsalive(false);
			}
//			System.out.println("Pollen:" + fleurs.get(i).getPollen());
		}
		for (int i = fleurs.size() - 1; i >= 0; i--) {
			if (!fleurs.get(i).isIsalive()) {
				fleursMortes.add(fleurs.get(i));
				fleurs.remove(fleurs.get(i));
			}
		}
//		System.out.println("number of existing flowers:" + fleurs.size());
	
		if (this.getFleurs().size() == 0) {
			System.out.println("number of foragers in the game: " + this.ruche.getForagersAtAll());
			System.out.println("number of collected pollen: " + this.ruche.getPollen());
			boolean foragersWin = true;
			new FinFenetre( foragersWin, this.ruche.getForagersAtAll(),this.ruche.getPollen(),this.rounds);
		}
		if (this.ruche.getlForager().size() == 0) {
			System.out.println("number of foragers in the game: " + this.ruche.getForagersAtAll());
			System.out.println("number of collected pollen: " + this.ruche.getPollen());
			boolean foragersWin = false;
			new FinFenetre(foragersWin, this.ruche.getForagersAtAll(),this.ruche.getPollen(),this.rounds);
		}

	}

}
