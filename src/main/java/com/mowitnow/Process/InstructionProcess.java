package com.mowitnow.Process;


import com.mowitnow.Exception.ApplicationException;
import com.mowitnow.entites.Coordinates;
import com.mowitnow.entites.TondeusePosition;
import com.mowitnow.enums.InstructionTondeuse;
import com.mowitnow.Exception.ExceptionTondeuse;
import com.mowitnow.enums.Orientation;

/**
 * Class that handles the execution of a mower instruction and updates the coordinates.
 * @author Fakher Saafi
 */
public class InstructionProcess {

	private InstructionProcess(){

	}
	/**
	 * Moves the tondeuse forward while respecting the pelouse's boundary coordinates.
	 * @param TondeusePosition The tondeuse's initial orientation.
	 * @param coordinatesMax The pelouse's coordinates - the top-right corner of the pelouse.
	 * @return coordinates The new coordinates of the tondeuse.
	 * @throws ExceptionTondeuse If an error occurs during the operation.
	 */
	public static Coordinates avancerTondeuse(TondeusePosition TondeusePosition, Coordinates coordinatesMax) throws ExceptionTondeuse {
		Coordinates nextCoordinates = null;
		int x, y;
		switch (TondeusePosition.getOrientationTondeuse()) {
		case NORTH:
			x = TondeusePosition.getCoordinatesTondeuse().getX();
			y = TondeusePosition.getCoordinatesTondeuse().getY() + 1;
			break;
		case EAST:
			x = TondeusePosition.getCoordinatesTondeuse().getX() + 1;
			y = TondeusePosition.getCoordinatesTondeuse().getY();
			break;
		case SOUTH:
			x = TondeusePosition.getCoordinatesTondeuse().getX();
			y = TondeusePosition.getCoordinatesTondeuse().getY() - 1;
			break;
		case WEST:
			x = TondeusePosition.getCoordinatesTondeuse().getX() - 1;
			y = TondeusePosition.getCoordinatesTondeuse().getY();
			break;
		default:
			throw new ExceptionTondeuse(ApplicationException.INCORRECT_POSITION);
		}
		nextCoordinates = new Coordinates(x, y);
		// If the new coordinates are outside the lawn, keep the last position
		if (coordinatesMax.isOutsideCoordinatesPelouse(nextCoordinates)) {
			return nextCoordinates;
		} else {
			return TondeusePosition.getCoordinatesTondeuse();
		}
	}
	
	/**
	 * Rotate the Tondeuse to the right
	 * @param orientation : initial Tondeuse orientation
	 * @return new orientation
	 * @throws ExceptionTondeuse
	 */
	
	public static Orientation pivoterDroite(Orientation orientation) throws ExceptionTondeuse{
		Orientation orientationSuivante = null ;
		switch (orientation){
			case NORTH : 
				orientationSuivante =  Orientation.EAST;
				break;
			case EAST : 
				orientationSuivante =  Orientation.SOUTH;
				break;
			case SOUTH : 
				orientationSuivante =  Orientation.WEST;
				break;
			case WEST : 
				orientationSuivante =  Orientation.NORTH;
				break;
			default : 
				throw new ExceptionTondeuse(ApplicationException.INCORRECT_ORIENTATION);
		}
		return orientationSuivante;		
	}
	
	/**
	 * Rotate the Tondeuse to the left
	 * @param orientation : initial Tondeuse orientation
	 * @return new orientation
	 * @throws ExceptionTondeuse
	 */
	public static Orientation pivoterGauche(Orientation orientation) throws ExceptionTondeuse{
		Orientation orientationSuivante = null ;
		switch (orientation){
			case NORTH : 
				orientationSuivante =  Orientation.WEST; 
				break;
			case EAST : 
				orientationSuivante =  Orientation.NORTH; 
				break;
			case SOUTH : 
				orientationSuivante =  Orientation.EAST; 
				break;
			case WEST : 
				orientationSuivante =  Orientation.SOUTH; 
				break;
			default : 
				throw new ExceptionTondeuse(ApplicationException.INCORRECT_ORIENTATION);
		}
		return orientationSuivante;		
	}

	/**
	 * execute a single instruction ( A, D ou G)
	 * @param TondeusePosition
	 * @param instruction
	 * @param coordonnesMax
	 * @throws ExceptionTondeuse
	 */
	public static void executerInstruction(TondeusePosition TondeusePosition, InstructionTondeuse instruction, Coordinates coordonnesMax) throws ExceptionTondeuse{
		
		switch (instruction){
			case FORWARD :
				TondeusePosition.setCoordinatesTondeuse(InstructionProcess.avancerTondeuse(TondeusePosition, coordonnesMax));
				break;
			case RIGHT :
				TondeusePosition.setOrientationTondeuse(InstructionProcess.pivoterDroite(TondeusePosition.getOrientationTondeuse()));
				break;
			case LEFT :
				TondeusePosition.setOrientationTondeuse(InstructionProcess.pivoterGauche(TondeusePosition.getOrientationTondeuse()));
				break;
			default: throw new ExceptionTondeuse(ApplicationException.INCORRECT_INSTRUCTION);
		}
	}
}