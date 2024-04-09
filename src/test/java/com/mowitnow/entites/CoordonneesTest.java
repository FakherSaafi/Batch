package com.mowitnow.entites;
import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class CoordonneesTest {

	@Test
	public void verifier_equals(){
		Coordonnees c1 = new Coordonnees(3, 2);
		Coordonnees c2 = new Coordonnees(3, 2);
		assertThat(c1.equals(c2)).isTrue();
		c2 = new Coordonnees(1, 3);
		assertThat(c1.equals(c2)).isFalse();
	}
	
	@Test
	public void verifier_coordonnees_isHorsCoordonneesPelouse(){
		Coordonnees coordonneesPelouse = new Coordonnees(5,5);
		Coordonnees c0 = new Coordonnees(-1,-1);
		Coordonnees c1 = new Coordonnees(1,1);
		assertThat(coordonneesPelouse.isHorsCoordonneesPelouse(c0)).isFalse();
		assertThat(coordonneesPelouse.isHorsCoordonneesPelouse(c1)).isTrue();
	}
}
