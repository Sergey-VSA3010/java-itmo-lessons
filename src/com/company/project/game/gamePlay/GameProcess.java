package com.company.project.game.gamePlay;

import java.util.Map;
import java.util.Scanner;

public class GameProcess {
    public static StructureGame structureGame = GameInit.getStructureGame();
    public static Scanner scanner = new Scanner(System.in);

    public static void play() {
        System.out.println("НАЧАЛО ИГРЫ!!!");
        GameInit.initGame();
        GameSteps currentLevel = structureGame.getStepsGame().iterator().next();
        for (GameSteps st : structureGame.getStepsGame()) {
            if (st.startStep()) {
                currentLevel = st;
                currentLevel.setStartStep(false);
                break;
            }
        }
        while (true) {
            Map<Integer, GameSteps> menu = currentLevel.getNextLevels();
            System.out.println(currentLevel.getText() + "\n");
            int countLevel = 0;
            int countGame = 0;
            for (Map.Entry<Integer, GameSteps> pair : menu.entrySet()) {
                countLevel++;
                countGame++;
                System.out.println(pair.getKey() + ". " + pair.getValue().getStepName());
            }
            if (menu.size() == 0) break;
            System.out.println(++countGame + ". Выход");
            System.out.println("Выбрать вариант: ");
            int choice = 1;
            while (true) {
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    if (choice > countGame || choice <= 0) {
                        System.out.println("Нет такого пункта. Попробуйте снова:");
                        continue;
                    } else break;
                } else {
                    System.out.println("Не корректный ввод! Попробуйте снова:");
                    scanner.next();
                }
            }
            if (choice <= countLevel) {
                currentLevel = menu.get(choice);
            } else if (choice == countGame) {
                break;
            } else {
                currentLevel.setStartStep(true);

                break;
            }
        }
    }


}