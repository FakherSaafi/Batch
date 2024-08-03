package com.mowitnow.entites;

public class Coordinates {
	
	private int x;
	private int y;
	
	public Coordinates(int X, int Y){
		this.x = X;
		this.y = Y;
	}
	
	/**
	 * check if Tondeuse coordinates after move are outside Pelouse
	 * * @return true if Tondeuse coordinates are inside Pelouse
	 */
	public boolean isOutsideCoordinatesPelouse(Coordinates c){
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
		Coordinates other = (Coordinates) obj;
		if (x != other.x || y != other.y)
			return false;
		
		return true;
	}
}