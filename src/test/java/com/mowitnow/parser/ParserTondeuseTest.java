package com.mowitnow.parser;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class ParserTondeuseTest {
	
	@Test
	public void parse_tondeuse(){
		ParserTondeuse parserTondeuse = new ParserTondeuse();
		parserTondeuse.setInstructions("DGDGA");
		parserTondeuse.setPelouse("50 5");
		parserTondeuse.setTondeuse("1 2 N");
		assertThat(parserTondeuse.executeParseValidation()).isTrue();
	}
	@Test
	
	public void parse_tondeuse_pelouse_incorrect(){
		ParserTondeuse parserTondeuse = new ParserTondeuse();
		parserTondeuse.setInstructions("DGDGA");
		parserTondeuse.setPelouse("0 -1");
		parserTondeuse.setTondeuse("1 2 N");
		assertThat(parserTondeuse.executeParseValidation()).isFalse();
	}
	
	@Test
	public void parse_tondeuse_donnees_vide(){
		ParserTondeuse parserTondeuse = new ParserTondeuse();
		assertThat(parserTondeuse.executeParseValidation()).isFalse();
	}
}
