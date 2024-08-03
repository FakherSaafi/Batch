package com.mowitnow.entites;

import static org.fest.assertions.Assertions.assertThat;

import com.mowitnow.enums.Orientation;
import org.junit.Test;

public class TondeusePositionTest {

	@Test
	public void verifier_equals() {
		
		TondeusePosition pt1 = new TondeusePosition(new Coordinates(1, 1), Orientation.NORTH);
		TondeusePosition pt2 = new TondeusePosition(new Coordinates(1, 1), Orientation.NORTH);
		TondeusePosition pt3 = new TondeusePosition(new Coordinates(1, 1), Orientation.SOUTH);
		
		assertThat(pt1.equals(pt2)).isTrue();
		assertThat(pt1.equals(pt3)).isFalse();
	}

}
