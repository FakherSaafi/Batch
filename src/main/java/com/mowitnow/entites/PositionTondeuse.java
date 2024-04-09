package com.mowitnow.entites;

import com.mowitnow.enums.Orientation;

public class PositionTondeuse {
	
	private Coordonnees coordonneesTondeuse;
	private Orientation orientationTondeuse;

	public PositionTondeuse(Coordonnees pCoordonneesTondeuse,
			Orientation pOrientationTondeuse) {
		this.coordonneesTondeuse = pCoordonneesTondeuse;
		this.orientationTondeuse = pOrientationTondeuse;
	}

	public Orientation getOrientationTondeuse() {
		return orientationTondeuse;
	}

	public void setOrientationTondeuse(Orientation pOrientationTondeuse) {
		this.orientationTondeuse = pOrientationTondeuse;
	}

	public Coordonnees getCoordonneesTondeuse() {
		return coordonneesTondeuse;
	}

	public void setCoordonneesTondeuse(Coordonnees pCoordonneesTondeuse) {
		this.coordonneesTondeuse = pCoordonneesTondeuse;
	}

	@Override
	public int hashCode() {
		final int hash = 57;
		int result = 1;
		result = hash * result + ((coordonneesTondeuse == null) ? 0 : coordonneesTondeuse.hashCode());
		result = hash * result + ((orientationTondeuse == null) ? 0 : orientationTondeuse .hashCode());
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
		PositionTondeuse other = (PositionTondeuse) obj;
		if (coordonneesTondeuse == null) {
			if (other.coordonneesTondeuse != null)
				return false;
			} else if (!coordonneesTondeuse.equals(other.coordonneesTondeuse))
				return false;
		if (orientationTondeuse != other.orientationTondeuse)
			return false;
		return true;
	}
}