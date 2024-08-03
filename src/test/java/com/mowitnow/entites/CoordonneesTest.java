package com.mowitnow.entites;
import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class CoordonneesTest {

	@Test
	public void verifier_equals(){
		Coordinates c1 = new Coordinates(3, 2);
		Coordinates c2 = new Coordinates(3, 2);
		assertThat(c1.equals(c2)).isTrue();
		c2 = new Coordinates(1, 3);
		assertThat(c1.equals(c2)).isFalse();
	}
	
	@Test
	public void verifier_coordonnees_isHorsCoordonneesPelouse(){
		Coordinates coordonneesPelouse = new Coordinates(5,5);
		Coordinates c0 = new Coordinates(-1,-1);
		Coordinates c1 = new Coordinates(1,1);
		assertThat(coordonneesPelouse.isOutsideCoordinatesPelouse(c0)).isFalse();
		assertThat(coordonneesPelouse.isOutsideCoordinatesPelouse(c1)).isTrue();
	}
}
