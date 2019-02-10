package models;

import java.awt.Point;

public class Queen extends Bees {

	private Hive ruche;
	private long pollen = 0;
	private int newForagers = 0;

	public Queen(Hive ruche) {

		this.ruche = ruche;
	}

	// Méthode pour déterminer si et combien de nouvelles abeilles sont nées au
	// cours de cette ronde
	public int calculateNewForagers(long input) {
		int output = (int) input / 10;
		int temp = output;
		output = output - newForagers;
		newForagers = temp;
		return output;
	}

	public void nextFrame() {
		boolean check = true;
		if (this.ruche.getPollen() == this.pollen)
			check = false;
		// s'il y a assez de nouveau pollen, de nouvelles abeilles vont naître
		if (check) {
			this.pollen = this.ruche.getPollen();
			int temp = calculateNewForagers(this.pollen);
			if (temp != 0) {
				for (int i = 0; i < temp; i++) {
					Forager f = new Forager(null, new Point(ruche.getPositionHiveDoor()), ruche, 0);
					ruche.getlForager().add(f);
					this.ruche.setForagersAtAll(this.ruche.getForagersAtAll() + 1);
				}
			}
		}
	}
}
