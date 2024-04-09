package com.mowitnow.entites;

import static org.fest.assertions.Assertions.assertThat;

import com.mowitnow.enums.Orientation;
import org.junit.Test;

public class PositionTondeuseTest {

	@Test
	public void verifier_equals() {
		
		PositionTondeuse pt1 = new PositionTondeuse(new Coordonnees(1, 1), Orientation.NORTH);
		PositionTondeuse pt2 = new PositionTondeuse(new Coordonnees(1, 1), Orientation.NORTH);
		PositionTondeuse pt3 = new PositionTondeuse(new Coordonnees(1, 1), Orientation.SOUTH);
		
		assertThat(pt1.equals(pt2)).isTrue();
		assertThat(pt1.equals(pt3)).isFalse();
	}

}
