package com.mowitnow.Process;

import com.mowitnow.entites.Pelouse;
import com.mowitnow.entites.TondeusePosition;
import com.mowitnow.enums.InstructionTondeuse;
import com.mowitnow.Exception.ExceptionTondeuse;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that allows the execution of all instructions by a Tondeuse.
 * @author Fakher Saafi
 */
public class TondeuseProcess {

	private Pelouse pelouse;
	private TondeusePosition TondeusePosition;
	private List<InstructionTondeuse> listeInstruction;
	
	public void setPelouse(Pelouse pelouse) {
		this.pelouse = pelouse;
	}
	
	public void setTondeusePosition(TondeusePosition TondeusePosition) {
		this.TondeusePosition = TondeusePosition;
	}

	public void setListeInstruction(
			List<InstructionTondeuse> pListeInstruction) {
		this.listeInstruction = pListeInstruction;
		if(pListeInstruction == null){
			listeInstruction = new ArrayList<InstructionTondeuse>();
		}
	}
	/**
	 * Execute all instructions for a tondeuse
	 * @throws ExceptionTondeuse
	 */
	public void executerInstructions() throws ExceptionTondeuse{
		for(InstructionTondeuse instruction : listeInstruction){
			InstructionProcess.executerInstruction(TondeusePosition,
					instruction, this.pelouse.getMaxPosition());
		}
	}

	public String toString(){
		return 	TondeusePosition.getCoordinatesTondeuse().getX()
				+ " " 
				+ TondeusePosition.getCoordinatesTondeuse().getY()
				+ " " 
				+ TondeusePosition.getOrientationTondeuse().getOrientationCode() ;
	}
}