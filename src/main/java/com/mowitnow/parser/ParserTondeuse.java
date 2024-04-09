package com.mowitnow.parser;

/**
 * class permetant la validation et le lancement d'une tondeuse
 * @author Fakher Saafi
 *
 */
public class ParserTondeuse {

	private String pelouse;
	private String tondeuse;
	private String instructions;

	public ParserTondeuse(){
		this.pelouse = "";
		this.tondeuse = "";
		this.instructions = "";
	}
	
	/**
	 * @return true si les informations de la tondeuse sont correctes
	 */
	public boolean executeParseValidation(){
		return ParserValidation.parseTondeuse(tondeuse)
				&& ParserValidation.parsePelouse(pelouse)
				&& ParserValidation.parseListInstruction(instructions);
	}
	
	public String getPelouse() {
		return pelouse;
	}

	public void setPelouse(String pelouse) {
		this.pelouse = pelouse;
	}

	public String getTondeuse() {
		return tondeuse;
	}

	public void setTondeuse(String tondeuse) {
		this.tondeuse = tondeuse;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
}