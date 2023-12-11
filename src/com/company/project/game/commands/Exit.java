package com.company.project.game.commands;

public class Exit implements Command {
    private final ReceiverCommand command;

    public Exit(ReceiverCommand command) {
        this.command = command;
        System.out.println("ИГРА ОКОНЧЕНА!");
    }

    @Override
    public void execute() {
        command.exitGame();
    }

    @Override
    public String toString() {
        return "ВЫЙТИ ИЗ ИГРЫ!";
    }
}