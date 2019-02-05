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

	public static ArrayList<Flowers> getFleurs() {
		return fleurs;
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

	public Point getPosition(int width, int height) { // créer un point aléatoire
		Point p;
		Random rand = new Random();
		int x = rand.nextInt(width);
		int y = rand.nextInt(height);
		p = new Point(x, y);
		return p;
	}

	public Boolean existe(Point po) { // vérifier s'il y a déjà une fleur sur ce point
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

	public void createFlowers(int nbFlowers, int width, int height) { // créer les fleures
		System.out.println("in the garden, creating flowers");

		boolean condition;
		Flowers f;

		for (int i = 0; i < nbFlowers; i++) { // les bouclages pour les fleures
			point = getPosition(width, height); // trouver un poit aléatoire
			boolean runWhile = true;
			while (runWhile) { // les bouclages pour vérifier le point nouveaux
				condition = existe(point);
				if (condition) {
					point = getPosition(width, height);
				} else
					runWhile = false;
			}
			f = new Flowers(point);
			fleurs.add(f);
		}

		int s = getState(nbFlowers); // fixer le pourcentage de fleurs mortelles
		for (int i = 0; i < s; i = i + 2) {
			fleurs.get(i).setState(Flowerstate.carnivore);
			fleurs.get(i + 1).setState(Flowerstate.poisoned);
		}
		for (Flowers flower : fleurs)
			System.out.println(flower);
	}

	public void nextFrame() {// minuteSuivante
		this.ruche.nextFrame();

		for (int i = 0; i < fleurs.size(); i++) { // vérifier si une fleure n'a pas encore de pollen
			if (fleurs.get(i).getPollen() == 0) {
				fleurs.get(i).setIsalive(false);
			}
			System.out.println("Pollen:" + fleurs.get(i).getPollen());
		}
		for (int i = fleurs.size() - 1; i >= 0; i--) { // supprimer les fleurs mortes de la liste
			if (!fleurs.get(i).isIsalive()) {
				fleurs.remove(fleurs.get(i));
			}
		}
		System.out.println("number of existing flowers:" + fleurs.size());
		if (fleurs.size() == 0) { // afficher les résultats à la fin de la jeu (il ne reste plus de fleurs)
			System.out.println("number of foragers in the game: " + this.ruche.getForagersAtAll());
			System.out.println("number of collected pollen: " + this.ruche.getPollen());
		}

	}

}
