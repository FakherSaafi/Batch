package com.mowitnow.traitement;

import static org.fest.assertions.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import com.mowitnow.Exception.ExceptionTondeuse;
import com.mowitnow.entites.Coordonnees;
import com.mowitnow.entites.Pelouse;
import com.mowitnow.entites.PositionTondeuse;

import com.mowitnow.enums.InstructionTondeuse;
import com.mowitnow.enums.Orientation;
import org.junit.Test;


public class TraitementTondeuseTest {
	Coordonnees coordonnesMax = new Coordonnees(5, 5);
	
	@Test
	public void executer_instruction_aucune_instruction() throws ExceptionTondeuse{
		int x = 0;
		int y = 0;
		Coordonnees coordonnees = new Coordonnees(x, y);
		PositionTondeuse positionTondeuse = new PositionTondeuse(coordonnees, Orientation.NORTH);
		
		TraitementTondeuse traitemetT = new TraitementTondeuse();
		traitemetT.setPelouse(new Pelouse(coordonnesMax));
		traitemetT.setPositionTondeuse(positionTondeuse);
		traitemetT.setListeInstruction(new ArrayList<InstructionTondeuse>());
		traitemetT.executerInstructions();
		assertThat(traitemetT.toString()).isEqualTo("0 0 N");
	}
	
	@Test
	public void executer_instruction_unitaire() throws ExceptionTondeuse{
		List<InstructionTondeuse> listInstruction = new ArrayList<InstructionTondeuse>();
		listInstruction.add(InstructionTondeuse.AVANCER);
		int x = 1;
		int y = 1;
		Coordonnees coordonnees = new Coordonnees(x, y);
		PositionTondeuse positionTondeuse = new PositionTondeuse(coordonnees, Orientation.NORTH);
		TraitementTondeuse traitemetT = new TraitementTondeuse();
		traitemetT.setPelouse(new Pelouse(coordonnesMax));
		traitemetT.setPositionTondeuse(positionTondeuse);
		traitemetT.setListeInstruction(listInstruction);
		traitemetT.executerInstructions();
		assertThat(traitemetT.toString()).isEqualTo("1 2 N");
	}
	
	@Test
	public void executer_instruction_senario() throws ExceptionTondeuse{
		List<InstructionTondeuse> listInstruction = new ArrayList<InstructionTondeuse>();
		listInstruction.add(InstructionTondeuse.GAUCHE);
		listInstruction.add(InstructionTondeuse.AVANCER);
		listInstruction.add(InstructionTondeuse.GAUCHE);
		listInstruction.add(InstructionTondeuse.AVANCER);
		listInstruction.add(InstructionTondeuse.GAUCHE);
		listInstruction.add(InstructionTondeuse.AVANCER);
		listInstruction.add(InstructionTondeuse.GAUCHE);
		listInstruction.add(InstructionTondeuse.AVANCER);
		listInstruction.add(InstructionTondeuse.AVANCER);
		int x = 1;
		int y = 2;
		Coordonnees coordonnees = new Coordonnees(x, y);
		PositionTondeuse positionTondeuse = new PositionTondeuse(coordonnees, Orientation.NORTH);
		TraitementTondeuse traitemetT = new TraitementTondeuse();
		traitemetT.setPelouse(new Pelouse(coordonnesMax));
		traitemetT.setPositionTondeuse(positionTondeuse);
		traitemetT.setListeInstruction(listInstruction);
		traitemetT.executerInstructions();
		assertThat(traitemetT.toString()).isEqualTo("1 3 N");
	}
	
	@Test
	public void tondeuse_x_y_north_instruction_avancer() throws ExceptionTondeuse {
		int x = 0;
		int y = 0;
		Coordonnees coordonnees = new Coordonnees(x, y);
		PositionTondeuse positionTondeuse = new PositionTondeuse(coordonnees,Orientation.NORTH);
		TraitementInstruction.executerInstruction(positionTondeuse, InstructionTondeuse.AVANCER, coordonnesMax);
		assertThat(positionTondeuse.getCoordonneesTondeuse()).isEqualTo(new Coordonnees(x, y+1));
		assertThat(positionTondeuse.getOrientationTondeuse()).isEqualTo(Orientation.NORTH);
	}
	
	@Test
	public void tondeuse_x_y_East_instruction_avancer() throws ExceptionTondeuse {
		int x = 0;
		int y = 0;
		Coordonnees coordonnees = new Coordonnees(x, y);
		PositionTondeuse positionTondeuse = new PositionTondeuse(coordonnees,Orientation.EAST);
		TraitementInstruction.executerInstruction(positionTondeuse, InstructionTondeuse.AVANCER, coordonnesMax);
		assertThat(positionTondeuse.getCoordonneesTondeuse()).isEqualTo(new Coordonnees(x+1, y));
		assertThat(positionTondeuse.getOrientationTondeuse()).isEqualTo(Orientation.EAST);
	}
	
	@Test
	public void tondeuse_x_y_South_instruction_avancer() throws ExceptionTondeuse {
		int x = 5;
		int y = 5;
		Coordonnees coordonnees = new Coordonnees(x, y);
		PositionTondeuse positionTondeuse = new PositionTondeuse(coordonnees,Orientation.SOUTH);
		TraitementInstruction.executerInstruction(positionTondeuse, InstructionTondeuse.AVANCER, coordonnesMax);
		assertThat(positionTondeuse.getCoordonneesTondeuse()).isEqualTo(new Coordonnees(x, y-1));
		assertThat(positionTondeuse.getOrientationTondeuse()).isEqualTo(Orientation.SOUTH);
	}
	
	@Test
	public void tondeuse_x_y_West_instruction_avancer() throws ExceptionTondeuse {
		int x = 5;
		int y = 5;
		Coordonnees coordonnees = new Coordonnees(x, y);
		PositionTondeuse positionTondeuse = new PositionTondeuse(coordonnees,Orientation.WEST);
		TraitementInstruction.executerInstruction(positionTondeuse, InstructionTondeuse.AVANCER, coordonnesMax);
		assertThat(positionTondeuse.getCoordonneesTondeuse()).isEqualTo(new Coordonnees(x-1, y));
		assertThat(positionTondeuse.getOrientationTondeuse()).isEqualTo(Orientation.WEST);
	}
	@Test
	public void orientation_West_instruction_Tourner_gauche() throws ExceptionTondeuse {
		int x = 2;
		int y = 3;
		Coordonnees coordonnees = new Coordonnees(x, y);
		PositionTondeuse positionTondeuse = new PositionTondeuse(coordonnees,Orientation.WEST);
		TraitementInstruction.executerInstruction(positionTondeuse, InstructionTondeuse.GAUCHE, coordonnesMax);
		assertThat(positionTondeuse.getCoordonneesTondeuse()).isEqualTo(new Coordonnees(x, y));
		assertThat(positionTondeuse.getOrientationTondeuse()).isEqualTo(Orientation.SOUTH);
	}
	
	@Test
	public void orientation_east_instruction_Tourner_gauche() throws ExceptionTondeuse {
		int x = 2;
		int y = 3;
		Coordonnees coordonnees = new Coordonnees(x, y);
		PositionTondeuse positionTondeuse = new PositionTondeuse(coordonnees,Orientation.EAST);
		TraitementInstruction.executerInstruction(positionTondeuse, InstructionTondeuse.GAUCHE, coordonnesMax);
		assertThat(positionTondeuse.getCoordonneesTondeuse()).isEqualTo(new Coordonnees(x, y));
		assertThat(positionTondeuse.getOrientationTondeuse()).isEqualTo(Orientation.NORTH);
	}

	@Test
	public void orientation_instruction_Tourner_gauche() throws ExceptionTondeuse {
		int x = 2;
		int y = 3;
		Coordonnees coordonnees = new Coordonnees(x, y);
		PositionTondeuse positionTondeuse = new PositionTondeuse(coordonnees,Orientation.WEST);
		TraitementInstruction.executerInstruction(positionTondeuse, InstructionTondeuse.GAUCHE, coordonnesMax);
		assertThat(positionTondeuse.getCoordonneesTondeuse()).isEqualTo(new Coordonnees(x, y));
		assertThat(positionTondeuse.getOrientationTondeuse()).isEqualTo(Orientation.SOUTH);
	}
	@Test
	public void orientation_south_instruction_Tourner_gauche() throws ExceptionTondeuse {
		int x = 2;
		int y = 3;
		Coordonnees coordonnees = new Coordonnees(x, y);
		PositionTondeuse positionTondeuse = new PositionTondeuse(coordonnees,Orientation.SOUTH);
		TraitementInstruction.executerInstruction(positionTondeuse, InstructionTondeuse.GAUCHE, coordonnesMax);
		assertThat(positionTondeuse.getCoordonneesTondeuse()).isEqualTo(new Coordonnees(x, y));
		assertThat(positionTondeuse.getOrientationTondeuse()).isEqualTo(Orientation.EAST);
	}
	
	@Test
	public void orientation_north_instruction_Tourner_Droite() throws ExceptionTondeuse {
		int x = 2;
		int y = 3;
		Coordonnees coordonnees = new Coordonnees(x, y);
		PositionTondeuse positionTondeuse = new PositionTondeuse(coordonnees,Orientation.NORTH);
		TraitementInstruction.executerInstruction(positionTondeuse, InstructionTondeuse.DROITE, coordonnesMax);
		assertThat(positionTondeuse.getCoordonneesTondeuse()).isEqualTo(new Coordonnees(x, y));
		assertThat(positionTondeuse.getOrientationTondeuse()).isEqualTo(Orientation.EAST);
	}
	
	@Test
	public void orientation_east_instruction_Tourner_Droite() throws ExceptionTondeuse {
		int x = 2;
		int y = 3;
		Coordonnees coordonnees = new Coordonnees(x, y);
		PositionTondeuse positionTondeuse = new PositionTondeuse(coordonnees,Orientation.EAST);
		TraitementInstruction.executerInstruction(positionTondeuse, InstructionTondeuse.DROITE, coordonnesMax);
		assertThat(positionTondeuse.getCoordonneesTondeuse()).isEqualTo(new Coordonnees(x, y));
		assertThat(positionTondeuse.getOrientationTondeuse()).isEqualTo(Orientation.SOUTH);
	}

	@Test
	public void orientation_west_instruction_Tourner_Droite() throws ExceptionTondeuse {
		int x = 2;
		int y = 3;
		Coordonnees coordonnees = new Coordonnees(x, y);
		PositionTondeuse positionTondeuse = new PositionTondeuse(coordonnees,Orientation.WEST);
		TraitementInstruction.executerInstruction(positionTondeuse, InstructionTondeuse.DROITE, coordonnesMax);
		assertThat(positionTondeuse.getCoordonneesTondeuse()).isEqualTo(new Coordonnees(x, y));
		assertThat(positionTondeuse.getOrientationTondeuse()).isEqualTo(Orientation.NORTH);
	}

}