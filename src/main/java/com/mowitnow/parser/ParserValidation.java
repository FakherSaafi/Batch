package com.mowitnow.parser;

import com.mowitnow.enums.InstructionTondeuse;
import com.mowitnow.enums.Orientation;

/**
 * A class containing methods to validate the format of the lines in the file
 * @author Fakher Saafi
 *
 */
public class ParserValidation {

	private ParserValidation(){

	}

	/**
	 * Parse the Tondeuse's position and orientation
	 * The position and orientation are provided as 2 digits and a letter,
	 * separated by a space
	 * @param tondeuse
	 * @return true if the position line is correct, false otherwise.
	 */
	public static boolean parseTondeuse(String tondeuse){
		StringBuilder stringBuilder = new StringBuilder("");
		stringBuilder.append(Orientation.NORTH.getOrientationCode())
			.append("|").append(Orientation.SOUTH.getOrientationCode())
			.append("|").append(Orientation.EAST.getOrientationCode())
			.append("|").append(Orientation.WEST.getOrientationCode());
		String regex = stringBuilder.toString();
		return tondeuse.matches("(\\d+) (\\d+) (" + regex +")");
	}
	
	/**
	 * Parse the instruction line
	 * The instructions are a sequence of characters "D", "G", "A" without spaces
	 * @param instructions
	 * @return true if the instruction line is correct.
	 */
	public static boolean parseListInstruction(String instructions){
		StringBuilder stringBuilder = new StringBuilder("");
		stringBuilder.append("(").append(InstructionTondeuse.FORWARD.getCodeInstruction())
		.append("|").append(InstructionTondeuse.RIGHT.getCodeInstruction())
		.append("|").append(InstructionTondeuse.LEFT.getCodeInstruction())
		.append(")+");
		String regex = stringBuilder.toString();
		return instructions.matches(regex);
	}

	/**
	 * Parses the lawn's position.
	 * The Pelouse's position is in the form of 2 digits separated by a space.
	 * @param pelouse
	 * @return true if the position line is correct, false otherwise.
	 */
	public static boolean parsePelouse(String pelouse){
		return pelouse.matches("(\\d+) (\\d+)");
	}
}