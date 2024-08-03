package com.mowitnow.enums;

public enum InstructionTondeuse {
    RIGHT('D', "Rotate right"),
    LEFT('G', "Rotate left"),
    FORWARD('A', "Move forward");

    private String libelInstruction;
    private char codeInstruction;

    private InstructionTondeuse(char pCodeInstruction, String libelleInstruction) {
        this.libelInstruction = libelleInstruction;
        this.codeInstruction = pCodeInstruction;
    }
    public char getCodeInstruction() {
        return codeInstruction;
    }
}
