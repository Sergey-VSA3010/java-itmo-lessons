package game.commands;

import game.gamePlay.GameProcess;

public class ReceiverCommand {
    public void startGame() {
        GameProcess gameProcess = new GameProcess();
        gameProcess.play();


    }

    public void exitGame() {
        System.out.println("ИГРА ОКОНЧЕНА!!!");
    }

    public void saveGame() {
        GameProcess.saveGame();
    }

    public void loadGame() {
        GameProcess.loadGame();
    }
}