package com.mowitnow.parser;
import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class ParserDonneesTest {
	
	@Test
	public void parse_tondeuse(){
		assertThat(ParserValidation.parseTondeuse("")).isFalse();
		assertThat(ParserValidation.parseTondeuse("1 2 3")).isFalse();
		assertThat(ParserValidation.parseTondeuse("12N")).isFalse();
		assertThat(ParserValidation.parseTondeuse("1 2 N")).isTrue();
		assertThat(ParserValidation.parseTondeuse("1 2 S")).isTrue();
	}
	
	@Test
	public void parse_liste_instruction(){
		assertThat(ParserValidation.parseListInstruction("")).isFalse();
		assertThat(ParserValidation.parseListInstruction(" ")).isFalse();
		assertThat(ParserValidation.parseListInstruction("D G A")).isFalse();
		assertThat(ParserValidation.parseListInstruction("DGA")).isTrue();
		assertThat(ParserValidation.parseListInstruction("MOGGAGADX")).isFalse();
		assertThat(ParserValidation.parseListInstruction("GGAAA GADDA")).isFalse();
		assertThat(ParserValidation.parseListInstruction("GGAAAGADDA")).isTrue();
	}
	
	@Test
	public void parse_pelouse(){
		assertThat(ParserValidation.parsePelouse("")).isFalse();
		assertThat(ParserValidation.parsePelouse("1 2 3")).isFalse();
		assertThat(ParserValidation.parsePelouse("123")).isFalse();
		assertThat(ParserValidation.parsePelouse("1 2 ")).isFalse();
		assertThat(ParserValidation.parsePelouse("1 2")).isTrue();
		assertThat(ParserValidation.parsePelouse("1 N")).isFalse();
	}

}
