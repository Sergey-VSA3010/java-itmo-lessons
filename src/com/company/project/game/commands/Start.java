package com.company.project.game.commands;

public class Start implements Command {
private final ReceiverCommand command;

    public Start(ReceiverCommand command) {
        this.command = command;
    }

    @Override
    public void execute() {
       command.startGame();
    }

    @Override
    public String toString() {
        return "НАЧАТЬ ИГРУ!";
    }
}