package com.mowitnow.traitement;



import com.mowitnow.entites.Coordonnees;
import com.mowitnow.entites.Pelouse;
import com.mowitnow.entites.PositionTondeuse;
import com.mowitnow.enums.InstructionTondeuse;
import com.mowitnow.enums.Orientation;

import java.util.ArrayList;
import java.util.List;

/**
 * class permetant de mapper une ligne du fichier vers un objet (Pelouse,Tondeuse,InstructionTondeuse)
 * @author Fakher Saafi
 */
public class FormaterLigne {

	private static final String ESPACE = " ";

	private FormaterLigne(){

	}

	/**
	 * @param ligneTondeuse : ligne de la position de la tondeuse ( ex : 2 3 G)
	 * @return l'objet PositionTondeuse
	 */
	public static PositionTondeuse formaterLigneTondeuse(String ligneTondeuse){
		String[] tondeuse = ligneTondeuse.split(ESPACE);
		Coordonnees coordonneesTondeuse = new Coordonnees(Integer.valueOf(tondeuse[0]), Integer.valueOf(tondeuse[1]));
		Orientation orientationTondeuse = getOrientation(tondeuse[2].charAt(0));
		return new PositionTondeuse(coordonneesTondeuse, orientationTondeuse);
	}

	/**
	 * @param lignePelouse : ligne de la pelouse ( ex : 2 3)
	 * @return l'objet Pelouse
	 */
	public static Pelouse formaterLignePelouse(String lignePelouse){
		String[] pelouse = lignePelouse.split(ESPACE);
		return new Pelouse(new Coordonnees(Integer.valueOf(pelouse[0]), Integer.valueOf(pelouse[1])));
	}

	/**
	 * list InstructionTondeuse correspondante à la ligne d'instruction
	 * @param ligneInstruction : suite d'instruction ( ex : GDAGD)
	 * @return une liste d'enum InstructionTondeuse
	 */
	public static List<InstructionTondeuse> formaterLigneInstruction(String ligneInstruction){
		List<InstructionTondeuse> listInstruction = new ArrayList<InstructionTondeuse>();
		for(char instruction :ligneInstruction.toCharArray()){
			listInstruction.add(getInstruction(instruction));
		}
		return listInstruction;
	}

	/**
	 * récuperer un enum Orientation correspondant au caractère de l'orientation
	 * @param cOrientation : caractère de l'orientation (E, W, N, S)
	 * @return l'enum correspondant à l'orientation 
	 */
	public static Orientation getOrientation(char cOrientation){
		for(Orientation orientation : Orientation.values()) {
			if (orientation.getCodeOrientation() == cOrientation){
				return orientation;
			}
		}
		return null;
	}

	/**
	 * récuperer un enum InstructionTondeuse correspondant au caractère d'instruction
	 * @param cInstruction : caractère de l'instruction (A, G, D)
	 * @return l'enum correspondant à l'instruction 
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