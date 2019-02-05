package project;

import java.awt.Point;

public class Queen extends Bees {
	private Hive ruche;

	private long pollen = 0;

	private int newForagers = 0;

	public Queen(Hive ruche) {
		// TODO Auto-generated constructor stub
		this.ruche = ruche;
	}

	public int calculateNewForagers(long input) { // la méthode calcule combien de nouvelles abeilles sont nées cette
													// année
		int output = (int) input / 7; // le rythme des naissances
		int temp = output;
		output = output - newForagers;
		newForagers = temp;
		return output;
	}

	public void nextFrame() {

		boolean check = true;
		if (this.ruche.getPollen() == this.pollen) // vérifier si du nouveau pollen est arrivé dans la ruche
			check = false;
		if (check) {
			this.pollen = this.ruche.getPollen();
			System.out.println("Pollen for new foragers: " + this.pollen);
			int temp = calculateNewForagers(this.pollen);
			if (temp != 0) {
				for (int i = 0; i < temp; i++) { // Naissance de nouvelles abeilles
					Forager f = new Forager(null, new Point(ruche.getPositionHive()), ruche, 0);
					ruche.getlForager().add(f);
					System.out.println("New forager: " + f);
					this.ruche.setForagersAtAll(this.ruche.getForagersAtAll() + 1);
				}
			}
		}
	}

}
