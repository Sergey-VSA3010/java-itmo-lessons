package game.gamePlay;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class StructureGame implements Serializable {
   private Set<GameSteps> stepsGame = new HashSet<>();

   public void addSteps(GameSteps step){
       stepsGame.add(step);
   }

    public Set<GameSteps> getStepsGame() {
        return stepsGame;
    }
}