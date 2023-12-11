package com.company.project.game.gamePlay;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class GameSteps implements Serializable {
    private String stepName;
    private String text;
    private Map<Integer, GameSteps> nextLevels;
    private boolean startStep;
    private boolean endGame;

    public GameSteps(String stepName, String text, boolean endGame, boolean startStep) {
        this.stepName = stepName;
        this.text = text;
        this.startStep = startStep;
        this.endGame = endGame;
        nextLevels = new HashMap<>();
    }

    public void setStartStep(boolean startStep) {
        this.startStep = startStep;
    }

    public void setNextStep(Integer count, GameSteps nextStep) {
        nextLevels.put(count, nextStep);
    }


    public boolean isEndGame() {
        return endGame;
    }

    public String getStepName() {
        return stepName;
    }

    public String getText() {
        return text;
    }

    public Map<Integer, GameSteps> getNextLevels() {
        return nextLevels;
    }

    public boolean startStep() {
        return startStep;
    }

    public boolean gameOver(GameSteps stepGame) {
        if (stepGame.isEndGame()) {
            return true;
        }
        return false;
    }
}