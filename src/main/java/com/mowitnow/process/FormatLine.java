package com.mowitnow.process;



import com.mowitnow.entites.Coordinates;
import com.mowitnow.entites.Pelouse;
import com.mowitnow.entites.TondeusePosition;
import com.mowitnow.enums.InstructionTondeuse;
import com.mowitnow.enums.Orientation;

import java.util.ArrayList;
import java.util.List;

/**
 * class that maps a line from the file to an object (Pelouse,Tondeuse,InstructionTondeuse)
 * @author Fakher Saafi
 */
public class FormatLine {

	private static final String ESPACE = " ";

	private FormatLine(){

	}

	/**
	 * @param ligneTondeuse : Tondeuse position line ( ex : 2 3 G)
	 * @return TondeusePosition Object
	 */
	public static TondeusePosition formaterLigneTondeuse(String ligneTondeuse){
		String[] tondeuse = ligneTondeuse.split(ESPACE);
		Coordinates coordonneesTondeuse = new Coordinates(Integer.valueOf(tondeuse[0]), Integer.valueOf(tondeuse[1]));
		Orientation orientationTondeuse = getOrientation(tondeuse[2].charAt(0));
		return new TondeusePosition(coordonneesTondeuse, orientationTondeuse);
	}

	/**
	 * @param lignePelouse : Pelouse info line ( ex : 2 3)
	 * @return Pelouse Object
	 */
	public static Pelouse formaterLignePelouse(String lignePelouse){
		String[] pelouse = lignePelouse.split(ESPACE);
		return new Pelouse(new Coordinates(Integer.valueOf(pelouse[0]), Integer.valueOf(pelouse[1])));
	}

	/**
	 * InstructionTondeuse
	 * @param ligneInstruction : list of instruction ( ex : GDAGD)
	 * @return an InstructionTondeuse enum list
	 */
	public static List<InstructionTondeuse> formaterLigneInstruction(String ligneInstruction){
		List<InstructionTondeuse> listInstruction = new ArrayList<InstructionTondeuse>();
		for(char instruction :ligneInstruction.toCharArray()){
			listInstruction.add(getInstruction(instruction));
		}
		return listInstruction;
	}

	/**
	 * Retrieves an Orientation enum corresponding to the orientation character.
	 * @param cOrientation The orientation character (E, W, N, S).
	 * @return The enum corresponding to the orientation.
	 */
	public static Orientation getOrientation(char cOrientation){
		for(Orientation orientation : Orientation.values()) {
			if (orientation.getOrientationCode() == cOrientation){
				return orientation;
			}
		}
		return null;
	}

	/**
	 * Retrieves a MowerInstruction enum corresponding to the instruction character.
	 * @param cInstruction The instruction character (A, G, D).
	 * @return The enum corresponding to the instruction.
	 */
	public static InstructionTondeuse getInstruction(char cInstruction){
		for(InstructionTondeuse instruction : InstructionTondeuse.values()) {
			if (instruction.getCodeInstruction() == cInstruction) {
				return instruction;
			}
		}
		return null;
	}
}