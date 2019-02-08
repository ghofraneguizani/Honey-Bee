package models;

import java.awt.Point;

public class Queen extends Bees {
	
	private Hive ruche;
	private long pollen = 0;
	private int newForagers = 0;

	public Queen(Hive ruche) {
		
		this.ruche = ruche;
	}

	public int calculateNewForagers(long input) {
		int output = (int) input / 7;
		int temp = output;
		output = output - newForagers;
		newForagers = temp;
		return output;
	}



	public void nextFrame() {
		boolean check = true;
		if (this.ruche.getPollen() == this.pollen)
			check = false;
		if (check) {
			this.pollen = this.ruche.getPollen();
			System.out.println("Pollen for new foragers: " + this.pollen);
			int temp = calculateNewForagers(this.pollen);
			if (temp != 0) {
				for (int i = 0; i < temp; i++) {
					Forager f = new Forager(null, new Point(ruche.getPositionHive()), ruche, 0,null);
					ruche.getlForager().add(f);
					System.out.println("New forager: " + f);
					this.ruche.setForagersAtAll(this.ruche.getForagersAtAll() + 1);
				}
			}
		}
		
	}

}
