package models;

import java.awt.Point;

import models.Flowers.Flowerstate;

public class Forager extends Bees {

	protected enum foragerState {
		lookfor, onway, collecting, wayback, storing
	};

	private foragerState state;
	private Flowers target;
	protected boolean isalive;
	private Point position;
	private Hive ruche;
	private int pollen;
	private int liveTime;
	private int deathTime;
	
	public Forager() {

		isalive = true;
	}

	public Forager(Flowers target, Point position, Hive ruche, int liveTime) {
		super();
		state = foragerState.lookfor;
		this.target = target;
		this.isalive = true;
		this.position = position;
		this.pollen = 0;
		this.ruche = ruche;
		this.liveTime = liveTime;
		this.deathTime = 0;
	}

	public foragerState getState() {
		return state;
	}

	public void setState(foragerState state) {
		this.state = state;
	}

	public Flowers getTarget() {
		return target;
	}

	public void setTarget(Flowers target) {
		this.target = target;
	}

	public int getPollen() {
		return pollen;
	}

	public void setPollen(int pollen) {
		this.pollen = pollen;
	}

	public int getLiveTime() {
		return liveTime;
	}

	public void setLiveTime(int liveTime) {
		this.liveTime = liveTime;
	}

	public int getDeathTime() {
		return deathTime;
	}

	public void setDeathTime(int deathTime) {
		this.deathTime = deathTime;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public boolean isIsalive() {
		return isalive;
	}

	public void setIsalive(boolean isalive) {
		this.isalive = isalive;
	}

	// Méthode pour déterminer le vainqueur du combat entre deux abeilles (le plus
	// jeune gagne)
	public void fightOfForager(Forager input) {
		if (this.liveTime <= input.liveTime) {
			for (Forager f : ruche.getlForager()) {
				if (input.equals(f))
					f.setIsalive(false);
			}
		} else
			this.setIsalive(false);
	}

	// Méthode pour le mouvement des abeilles
	public boolean moveTo(Point position) {
		boolean arrived = true;
		if (position.x != this.position.x) {
			arrived = false;
			int distance = position.x - this.position.x;
			this.position.x += (distance > 0 ? 1 : -1) * Math.min(Application.vitesse, Math.abs(distance));
		}
		if (position.y != this.position.y) {
			arrived = false;
			int distance = position.y - this.position.y;
			this.position.y += (distance > 0 ? 1 : -1) * Math.min(Application.vitesse, Math.abs(distance));
		}
		return arrived;
	}

	public void nextFrame() {
		// lookfor , onway , collecting, wayback, storing

		switch (this.state) {
		// l'abeille choisit une nouvelle fleur
		case lookfor:

			target = ruche.findFlower();
			if (this.target.isIsalive()) {
				this.state = foragerState.onway;
			}
			break;
		// l'abeille vole jusqu'à la fleur
		case onway:
			if (this.moveTo(this.target.getPosition())) {
				this.state = foragerState.collecting;
			}
			break;
		// l'abeille collecte le pollen, si nécessaire, il y a des bagarres avec
		// d'autres abeilles
		case collecting:
			for (Forager forager : ruche.getlForager()) { // pas encore teste
				if (forager.position.equals(this.position) && !forager.equals(this) && forager.isalive
						&& this.isalive) {
					this.fightOfForager(forager);
				}
			}
			if (target.getState() == (Flowerstate.carnivore) || target.getState() == (Flowerstate.poisoned)) {
				this.setIsalive(false);
				target.setIsalive(false); // fleur est mort
			} else {
				if (target.isIsalive()) {
					int collected = this.target.decrementerPollen();
					this.setPollen(collected + pollen);
					if (this.pollen >= Application.MaxNectar || collected == 0) {
						this.state = foragerState.wayback;
						this.setTarget(null);
					}
				} else
					this.state = foragerState.lookfor;
			}
			break;
		// l'abeille retourne à la ruche
		case wayback:
			if (this.moveTo(this.ruche.getPositionHiveDoor())) {
				this.state = foragerState.storing;
			}
			break;
		// l'abeille stocke le pollen dans la ruche
		case storing:
			int toStore = Math.min(Application.nectarPerFrame, this.pollen);
			setPollen(pollen - toStore);
			this.ruche.setPollen(this.ruche.getPollen() + toStore);
			if (this.pollen == 0) {
				this.state = foragerState.lookfor;
			}
			break;
		}

	}

	@Override
	public String toString() {
		return "Forager [state=" + state + ", target=" + target + ", isalive=" + isalive + ", position=" + position
				+ ", pollen=" + pollen + ", liveTime=" + liveTime + "]";
	}

}
