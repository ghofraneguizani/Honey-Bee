package project;

import java.awt.Point;

public class Queen extends Bees {
	private int minute;
	private Hive ruche;

	public Queen(Hive ruche) {
		// TODO Auto-generated constructor stub
		this.ruche = ruche;
	}

	public void createNewForager() {
		if (this.minute % 5 == 0) {
			Flowers fleur = new Flowers();

			fleur = ruche.findFlower();
			Forager f = new Forager(fleur, new Point(ruche.getPositionHive()), ruche, 0);
			ruche.getlForager().add(f);
			this.ruche.setForagersAtAll(this.ruche.getForagersAtAll() + 1);
		}
		minute++;
	}

	public void nextFrame() {
		if (this.minute % 5 == 0) {
			// this.ruche.abeilles.add(new Forager())
			// this.ruche.abeilles.add(new Butineuse())

		}
		this.minute++;

	}

}
