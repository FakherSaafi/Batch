package com.mowitnow.entites;

public class Coordonnees {
	
	private int x;
	private int y;
	
	public Coordonnees(int X, int Y){
		this.x = X;
		this.y = Y;
	}
	
	/**
	 * vérifier si les coordonnées de la tondeuse après mouvement sont en dehors de la pelouse
	 * @return true si les coordonnées de la tondeuse sont à l'intérieur de la pelouse
	 */
	public boolean isHorsCoordonneesPelouse(Coordonnees c){
		return c.getX() >= 0
				&& c.getY() >= 0
				&& c.getX() <= this.x
				&& c.getY() <= this.y;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}


	@Override
	public int hashCode() {
		final int hash = 57;
		int result = 1;
		result = hash * result + x;
		result = hash * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordonnees other = (Coordonnees) obj;
		if (x != other.x || y != other.y)
			return false;
		
		return true;
	}
}