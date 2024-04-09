package com.mowitnow.parser;

import com.mowitnow.enums.InstructionTondeuse;
import com.mowitnow.enums.Orientation;

/**
 * class contenant les méthodes permettant de valider le format des lignes dans le fichier.
 * @author Fakher Saafi
 *
 */
public class ParserValidation {

	private ParserValidation(){

	}

	/**
	 * parser la position de la tondeuse et son orientation
	 * La position et l'orientation sont fournies sous la forme de 2 chiffres et une lettre,
	 * séparés par un espace
	 * @param tondeuse
	 * @return true si la ligne des positions est correcte, false sinon
	 */
	public static boolean parseTondeuse(String tondeuse){
		StringBuilder stringBuilder = new StringBuilder("");
		stringBuilder.append(Orientation.NORTH.getCodeOrientation())
			.append("|").append(Orientation.SOUTH.getCodeOrientation())
			.append("|").append(Orientation.EAST.getCodeOrientation())
			.append("|").append(Orientation.WEST.getCodeOrientation());
		String regex = stringBuilder.toString();
		return tondeuse.matches("(\\d+) (\\d+) (" + regex +")");
	}
	
	/**
	 * parser la ligne des instructions
	 * les instructions sont une suite de caractères <<D>> <<G>> <<A>> sans espaces
	 * @param instructions
	 * @return true si la ligne des instructions est correcte
	 */
	public static boolean parseListInstruction(String instructions){
		StringBuilder stringBuilder = new StringBuilder("");
		stringBuilder.append("(").append(InstructionTondeuse.AVANCER.getCodeInstruction())
		.append("|").append(InstructionTondeuse.DROITE.getCodeInstruction())
		.append("|").append(InstructionTondeuse.GAUCHE.getCodeInstruction())
		.append(")+");
		String regex = stringBuilder.toString();
		return instructions.matches(regex);
	}

	/**
	 * parser la position de la pelouse
	 * la position de la pelouse est sous forme de 2 chiffres séparés par espace
	 * @param pelouse
	 * @return true si la ligne des instructions est correcte, false sinon
	 */
	public static boolean parsePelouse(String pelouse){
		return pelouse.matches("(\\d+) (\\d+)");
	}
}