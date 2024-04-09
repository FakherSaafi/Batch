package com.mowitnow.enums;

public enum InstructionTondeuse {
    DROITE('D', "Pivoter à droite"),
    GAUCHE('G', "Pivoter à gauche"),
    AVANCER('A', "Avancer");

    private String libelleInstruction;
    private char codeInstruction;

    private InstructionTondeuse(char pCodeInstruction, String libelleInstruction) {
        this.libelleInstruction = libelleInstruction;
        this.codeInstruction = pCodeInstruction;
    }
    public char getCodeInstruction() {
        return codeInstruction;
    }
}
