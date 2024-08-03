package com.mowitnow.entites;

import com.mowitnow.enums.Orientation;

public class TondeusePosition {
	
	private Coordinates coordinatesTondeuse;
	private Orientation orientationTondeuse;

	public TondeusePosition(Coordinates pCoordinatesTondeuse,
							Orientation pOrientationTondeuse) {
		this.coordinatesTondeuse = pCoordinatesTondeuse;
		this.orientationTondeuse = pOrientationTondeuse;
	}

	public Orientation getOrientationTondeuse() {
		return orientationTondeuse;
	}

	public void setOrientationTondeuse(Orientation pOrientationTondeuse) {
		this.orientationTondeuse = pOrientationTondeuse;
	}

	public Coordinates getCoordinatesTondeuse() {
		return coordinatesTondeuse;
	}

	public void setCoordinatesTondeuse(Coordinates pCoordinatesTondeuse) {
		this.coordinatesTondeuse = pCoordinatesTondeuse;
	}

	@Override
	public int hashCode() {
		final int hash = 57;
		int result = 1;
		result = hash * result + ((coordinatesTondeuse == null) ? 0 : coordinatesTondeuse.hashCode());
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
		TondeusePosition other = (TondeusePosition) obj;
		if (coordinatesTondeuse == null) {
			if (other.coordinatesTondeuse != null)
				return false;
			} else if (!coordinatesTondeuse.equals(other.coordinatesTondeuse))
				return false;
		if (orientationTondeuse != other.orientationTondeuse)
			return false;
		return true;
	}
}