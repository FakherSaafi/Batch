package com.mowitnow.process;

import static org.fest.assertions.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import com.mowitnow.Exception.ExceptionTondeuse;
import com.mowitnow.entites.Coordinates;
import com.mowitnow.entites.Pelouse;
import com.mowitnow.entites.TondeusePosition;

import com.mowitnow.enums.InstructionTondeuse;
import com.mowitnow.enums.Orientation;
import org.junit.Test;


public class TraitementTondeuseTest {
	Coordinates coordonnesMax = new Coordinates(5, 5);
	
	@Test
	public void executer_instruction_aucune_instruction() throws ExceptionTondeuse{
		int x = 0;
		int y = 0;
		Coordinates coordonnees = new Coordinates(x, y);
		TondeusePosition TondeusePosition = new TondeusePosition(coordonnees, Orientation.NORTH);
		
		TondeuseProcess traitemetT = new TondeuseProcess();
		traitemetT.setPelouse(new Pelouse(coordonnesMax));
		traitemetT.setTondeusePosition(TondeusePosition);
		traitemetT.setListeInstruction(new ArrayList<InstructionTondeuse>());
		traitemetT.executerInstructions();
		assertThat(traitemetT.toString()).isEqualTo("0 0 N");
	}
	
	@Test
	public void executer_instruction_unitaire() throws ExceptionTondeuse{
		List<InstructionTondeuse> listInstruction = new ArrayList<InstructionTondeuse>();
		listInstruction.add(InstructionTondeuse.FORWARD);
		int x = 1;
		int y = 1;
		Coordinates coordonnees = new Coordinates(x, y);
		TondeusePosition TondeusePosition = new TondeusePosition(coordonnees, Orientation.NORTH);
		TondeuseProcess traitemetT = new TondeuseProcess();
		traitemetT.setPelouse(new Pelouse(coordonnesMax));
		traitemetT.setTondeusePosition(TondeusePosition);
		traitemetT.setListeInstruction(listInstruction);
		traitemetT.executerInstructions();
		assertThat(traitemetT.toString()).isEqualTo("1 2 N");
	}
	
	@Test
	public void executer_instruction_senario() throws ExceptionTondeuse{
		List<InstructionTondeuse> listInstruction = new ArrayList<InstructionTondeuse>();
		listInstruction.add(InstructionTondeuse.LEFT);
		listInstruction.add(InstructionTondeuse.FORWARD);
		listInstruction.add(InstructionTondeuse.LEFT);
		listInstruction.add(InstructionTondeuse.FORWARD);
		listInstruction.add(InstructionTondeuse.LEFT);
		listInstruction.add(InstructionTondeuse.FORWARD);
		listInstruction.add(InstructionTondeuse.LEFT);
		listInstruction.add(InstructionTondeuse.FORWARD);
		listInstruction.add(InstructionTondeuse.FORWARD);
		int x = 1;
		int y = 2;
		Coordinates coordonnees = new Coordinates(x, y);
		TondeusePosition TondeusePosition = new TondeusePosition(coordonnees, Orientation.NORTH);
		TondeuseProcess traitemetT = new TondeuseProcess();
		traitemetT.setPelouse(new Pelouse(coordonnesMax));
		traitemetT.setTondeusePosition(TondeusePosition);
		traitemetT.setListeInstruction(listInstruction);
		traitemetT.executerInstructions();
		assertThat(traitemetT.toString()).isEqualTo("1 3 N");
	}
	
	@Test
	public void tondeuse_x_y_north_instruction_avancer() throws ExceptionTondeuse {
		int x = 0;
		int y = 0;
		Coordinates coordonnees = new Coordinates(x, y);
		TondeusePosition TondeusePosition = new TondeusePosition(coordonnees,Orientation.NORTH);
		InstructionProcess.executerInstruction(TondeusePosition, InstructionTondeuse.FORWARD, coordonnesMax);
		assertThat(TondeusePosition.getCoordinatesTondeuse()).isEqualTo(new Coordinates(x, y+1));
		assertThat(TondeusePosition.getOrientationTondeuse()).isEqualTo(Orientation.NORTH);
	}
	
	@Test
	public void tondeuse_x_y_East_instruction_avancer() throws ExceptionTondeuse {
		int x = 0;
		int y = 0;
		Coordinates coordonnees = new Coordinates(x, y);
		TondeusePosition TondeusePosition = new TondeusePosition(coordonnees,Orientation.EAST);
		InstructionProcess.executerInstruction(TondeusePosition, InstructionTondeuse.FORWARD, coordonnesMax);
		assertThat(TondeusePosition.getCoordinatesTondeuse()).isEqualTo(new Coordinates(x+1, y));
		assertThat(TondeusePosition.getOrientationTondeuse()).isEqualTo(Orientation.EAST);
	}
	
	@Test
	public void tondeuse_x_y_South_instruction_avancer() throws ExceptionTondeuse {
		int x = 5;
		int y = 5;
		Coordinates coordonnees = new Coordinates(x, y);
		TondeusePosition TondeusePosition = new TondeusePosition(coordonnees,Orientation.SOUTH);
		InstructionProcess.executerInstruction(TondeusePosition, InstructionTondeuse.FORWARD, coordonnesMax);
		assertThat(TondeusePosition.getCoordinatesTondeuse()).isEqualTo(new Coordinates(x, y-1));
		assertThat(TondeusePosition.getOrientationTondeuse()).isEqualTo(Orientation.SOUTH);
	}
	
	@Test
	public void tondeuse_x_y_West_instruction_avancer() throws ExceptionTondeuse {
		int x = 5;
		int y = 5;
		Coordinates coordonnees = new Coordinates(x, y);
		TondeusePosition TondeusePosition = new TondeusePosition(coordonnees,Orientation.WEST);
		InstructionProcess.executerInstruction(TondeusePosition, InstructionTondeuse.FORWARD, coordonnesMax);
		assertThat(TondeusePosition.getCoordinatesTondeuse()).isEqualTo(new Coordinates(x-1, y));
		assertThat(TondeusePosition.getOrientationTondeuse()).isEqualTo(Orientation.WEST);
	}
	@Test
	public void orientation_West_instruction_Tourner_gauche() throws ExceptionTondeuse {
		int x = 2;
		int y = 3;
		Coordinates coordonnees = new Coordinates(x, y);
		TondeusePosition TondeusePosition = new TondeusePosition(coordonnees,Orientation.WEST);
		InstructionProcess.executerInstruction(TondeusePosition, InstructionTondeuse.LEFT, coordonnesMax);
		assertThat(TondeusePosition.getCoordinatesTondeuse()).isEqualTo(new Coordinates(x, y));
		assertThat(TondeusePosition.getOrientationTondeuse()).isEqualTo(Orientation.SOUTH);
	}
	
	@Test
	public void orientation_east_instruction_Tourner_gauche() throws ExceptionTondeuse {
		int x = 2;
		int y = 3;
		Coordinates coordonnees = new Coordinates(x, y);
		TondeusePosition TondeusePosition = new TondeusePosition(coordonnees,Orientation.EAST);
		InstructionProcess.executerInstruction(TondeusePosition, InstructionTondeuse.LEFT, coordonnesMax);
		assertThat(TondeusePosition.getCoordinatesTondeuse()).isEqualTo(new Coordinates(x, y));
		assertThat(TondeusePosition.getOrientationTondeuse()).isEqualTo(Orientation.NORTH);
	}

	@Test
	public void orientation_instruction_Tourner_gauche() throws ExceptionTondeuse {
		int x = 2;
		int y = 3;
		Coordinates coordonnees = new Coordinates(x, y);
		TondeusePosition TondeusePosition = new TondeusePosition(coordonnees,Orientation.WEST);
		InstructionProcess.executerInstruction(TondeusePosition, InstructionTondeuse.LEFT, coordonnesMax);
		assertThat(TondeusePosition.getCoordinatesTondeuse()).isEqualTo(new Coordinates(x, y));
		assertThat(TondeusePosition.getOrientationTondeuse()).isEqualTo(Orientation.SOUTH);
	}
	@Test
	public void orientation_south_instruction_Tourner_gauche() throws ExceptionTondeuse {
		int x = 2;
		int y = 3;
		Coordinates coordonnees = new Coordinates(x, y);
		TondeusePosition TondeusePosition = new TondeusePosition(coordonnees,Orientation.SOUTH);
		InstructionProcess.executerInstruction(TondeusePosition, InstructionTondeuse.LEFT, coordonnesMax);
		assertThat(TondeusePosition.getCoordinatesTondeuse()).isEqualTo(new Coordinates(x, y));
		assertThat(TondeusePosition.getOrientationTondeuse()).isEqualTo(Orientation.EAST);
	}
	
	@Test
	public void orientation_north_instruction_Tourner_Droite() throws ExceptionTondeuse {
		int x = 2;
		int y = 3;
		Coordinates coordonnees = new Coordinates(x, y);
		TondeusePosition TondeusePosition = new TondeusePosition(coordonnees,Orientation.NORTH);
		InstructionProcess.executerInstruction(TondeusePosition, InstructionTondeuse.RIGHT, coordonnesMax);
		assertThat(TondeusePosition.getCoordinatesTondeuse()).isEqualTo(new Coordinates(x, y));
		assertThat(TondeusePosition.getOrientationTondeuse()).isEqualTo(Orientation.EAST);
	}
	
	@Test
	public void orientation_east_instruction_Tourner_Droite() throws ExceptionTondeuse {
		int x = 2;
		int y = 3;
		Coordinates coordonnees = new Coordinates(x, y);
		TondeusePosition TondeusePosition = new TondeusePosition(coordonnees,Orientation.EAST);
		InstructionProcess.executerInstruction(TondeusePosition, InstructionTondeuse.RIGHT, coordonnesMax);
		assertThat(TondeusePosition.getCoordinatesTondeuse()).isEqualTo(new Coordinates(x, y));
		assertThat(TondeusePosition.getOrientationTondeuse()).isEqualTo(Orientation.SOUTH);
	}

	@Test
	public void orientation_west_instruction_Tourner_Droite() throws ExceptionTondeuse {
		int x = 2;
		int y = 3;
		Coordinates coordonnees = new Coordinates(x, y);
		TondeusePosition TondeusePosition = new TondeusePosition(coordonnees,Orientation.WEST);
		InstructionProcess.executerInstruction(TondeusePosition, InstructionTondeuse.RIGHT, coordonnesMax);
		assertThat(TondeusePosition.getCoordinatesTondeuse()).isEqualTo(new Coordinates(x, y));
		assertThat(TondeusePosition.getOrientationTondeuse()).isEqualTo(Orientation.NORTH);
	}

}