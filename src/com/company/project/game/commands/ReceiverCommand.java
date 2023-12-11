package com.company.project.game.commands;

import com.company.project.game.gamePlay.GameProcess;

public class ReceiverCommand {
    public void startGame() {
        GameProcess.play();
    }

    public void exitGame() {
        System.out.println("ИГРА ОКОНЧЕНА!!!");
    }

}