package project;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import project.Flowers.Flowerstate;

public class Garden {
	protected static ArrayList<Flowers> fleurs;
	protected Hive ruche;
	private Point point;

	public Garden() {
		fleurs = new ArrayList<>();
		point = new Point();
		ruche = new Hive();
	}

	public Garden(Hive ruche) {

		this.ruche = ruche;

	}

	public void addFlower(Flowers f) {
		fleurs.add(f);
	}

	public Point getPosition(int width, int height) {
		Point p;
		Random rand = new Random();
		int x = rand.nextInt(width);
		int y = rand.nextInt(height);
		p = new Point(x, y);
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
		System.out.println("in the garden, creating flowers");

		boolean condition;
		Flowers f;

		for (int i = 0; i < nbFlowers; i++) {
			point = getPosition(width, height);
			boolean runWhile = true;
			while (runWhile) {
				condition = existe(point);
				if (condition) {
					point = getPosition(width, height);
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
		for (int i = 0; i < fleurs.size(); i++) {
			if (!fleurs.get(i).isIsalive()) {
				fleurs.remove(fleurs.get(i));
			}
		}
		for (int i = 0; i < fleurs.size(); i++) {
			if (fleurs.get(i).getPollen() == 0) {
				fleurs.get(i).setIsalive(false);
			}
			System.out.println("Pollen:" + fleurs.get(i).getPollen());
		}
		System.out.println("number of existing flowers:" + fleurs.size());
		this.ruche.nextFrame();
	}

}
