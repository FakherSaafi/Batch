package com.mowitnow.entites;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class PelouseTest {

	@Test
	public void verifier_equals() {
		Pelouse p1 = new Pelouse(new Coordonnees(1, 1));
		Pelouse p2 = new Pelouse(new Coordonnees(1, 1));
		assertThat(p1.equals(p2)).isTrue();
		p2 = new Pelouse(new Coordonnees(1, 2));
		assertThat(p1.equals(p2)).isFalse();
	}
}
