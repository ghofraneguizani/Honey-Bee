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

	// Méthode pour trouver la position d'une fleur
	public Point getPos(int width, int height) {
		// zone de ruche
		int xLes = ((int) (width / 2) - 80);
		int xMore = ((int) (width / 2) + 120);
		int yLes = ((int) (height / 2) - 80);
		int yMore = ((int) (height / 2) + 120);

		int x = 0;
		int y = 0;
		Point p;
		Random rand = new Random();
		Boolean pointOk = true;
		while (pointOk) {
			pointOk = false;
			x = rand.nextInt(width - 60);
			y = rand.nextInt(height - 60);
			// Vérifier si le point est à l'extérieur de la zone du ruche
			if (xLes < x && x < xMore && yLes < y && y < yMore) {
				pointOk = true;
			}

		}

		p = new Point(x + 10, y + 10);
		return p;
	}

	// Méthode pour vérifier s'il y a déjà une fleur à ce point
	public Boolean existe(Point input) {
		for (Flowers flower : fleurs) {
			if (flower.getPosition().equals(input)) {
				return true;
			}
		}
		return false;
	}

	// Méthode pour déterminer combien de fleurs sont mortelles
	public int getState(int nbFlowers) {
		return (nbFlowers / 10);
	}

	// Méthode pour créer les fleurs du jardin au début
	public void createFlowers(int nbFlowers, int width, int height) {

		boolean condition;
		Flowers f;

		for (int i = 0; i < nbFlowers; i++) {
			point = getPos(width, height);
			// recherche d'un point libre pour la fleur
			boolean runWhile = true;
			while (runWhile) {
				condition = existe(point);
				if (condition) {
					point = getPos(width, height);
				} else
					runWhile = false;
			}
			// créer la nouvelle fleur et l'ajouter à la liste
			f = new Flowers(point);
			fleurs.add(f);
		}
		// Changement du statut des fleurs mortelles
		int s = getState(nbFlowers);
		for (int i = 0; i < s; i = i + 2) {
			fleurs.get(i).setState(Flowerstate.carnivore);
			fleurs.get(i + 1).setState(Flowerstate.poisoned);
		}
		for (Flowers flower : fleurs)
			System.out.println(flower);
	}

	public void nextFrame() {// minuteSuivante
		this.rounds++;
		this.ruche.nextFrame();

		for (int i = 0; i < fleurs.size(); i++) {
			if (fleurs.get(i).getPollen() == 0) {
				fleurs.get(i).setIsalive(false);
			}
		}
		// supprimer les fleurs mortes de la liste des fleurs vivantes et les ajouter à
		// la liste des fleurs mortes
		for (int i = fleurs.size() - 1; i >= 0; i--) {
			if (!fleurs.get(i).isIsalive()) {
				fleursMortes.add(fleurs.get(i));
				fleurs.remove(fleurs.get(i));
			}
		}
		// vérifiez s'il y a encore des fleurs vivantes, sinon appelez la fenêtre
		// jusqu'à la fin du jeu
		if (Garden.getFleurs().size() == 0) {
			boolean foragersWin = true;
			new FinFenetre(foragersWin, this.ruche.getForagersAtAll(), this.ruche.getPollen(), this.rounds);
		}
		// vérifiez s'il y a encore des abeilles vivantes, sinon appelez la fenêtre
		// jusqu'à la fin du jeu
		if (this.ruche.getlForager().size() == 0) {
			boolean foragersWin = false;
			new FinFenetre(foragersWin, this.ruche.getForagersAtAll(), this.ruche.getPollen(), this.rounds);
		}

	}

}
