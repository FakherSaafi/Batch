package com.mowitnow.entites;
public class Pelouse {

	private Coordinates maxPosition;
	public Pelouse(){
		
	}
	public Pelouse(Coordinates pMaxPosition) {
		this.maxPosition = pMaxPosition;
	}

	public Coordinates getMaxPosition() {
		return maxPosition;
	}

	public void setMaxPosition(Coordinates maxPosition) {
		this.maxPosition = maxPosition;
	}

	@Override
	public int hashCode() {
		final int hash = 57;
		int result = 1;
		result = hash * result
				+ ((maxPosition == null) ? 0 : maxPosition.hashCode());
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
		Pelouse other = (Pelouse) obj;
		if (maxPosition == null) {
			if (other.maxPosition != null)
				return false;
			} else if (!maxPosition.equals(other.maxPosition))
				return false;
		return true;
	}
}