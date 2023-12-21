package game.gamePlay;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


import static game.gamePlay.GameInit.structureGame;

public class GameProcess {

   static int countSave = (int) (Math.random() * 100);

    public static void play() {
        StructureGame structureGame = GameInit.getStructureGame();
        Scanner scanner = new Scanner(System.in);
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
            System.out.println(++countGame + ". Сохранить игру");
            System.out.println(++countGame + ". Выход");
            System.out.println("Выбрать вариант: ");
            int choice = 1;
            while (true) {
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    if (choice > countGame || choice <= 0) {
                        System.out.println("Нет такого пункта. Попробуйте снова:");

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
                saveGame();
                break;
            }
        }
    }
    public static void saveGame() {

        System.out.println("ИГРА СОХРАНЕНА!");
        try
                (FileOutputStream fileStream = new FileOutputStream(new File("./src/game/save/game" +
                        "_" + countSave + ".bin"), true);
                 ObjectOutputStream objectOutput = new ObjectOutputStream(fileStream)) {
            objectOutput.writeObject(structureGame);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException io) {
            System.out.println("IOException");
        }
        System.out.println("Под номером " + countSave + "!");
    }


    public static void loadGame() {
        Map<Integer, File> listFiles = new HashMap<>();
        File[] files = new File("./src/game/save").listFiles();
        int count = 0;
        for (File f : files) {
            count++;
            listFiles.put(count, f);
        }
        while (true) {
            int choice;
            System.out.println("Какой файл восстановить: ");
            for (Map.Entry<Integer, File> pair : listFiles.entrySet()) {
                System.out.println(pair.getKey() + "-----" + pair.getValue().getName());
            }
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice > 0 && choice <= listFiles.size()) {
                    try (FileInputStream fileInput = new FileInputStream(listFiles.get(choice));
                         ObjectInputStream objectInput = new ObjectInputStream(fileInput)) {
                        structureGame = (StructureGame) objectInput.readObject();
                        play();
                    } catch (FileNotFoundException ignored) {
                    } catch (IOException | ClassNotFoundException | NullPointerException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                System.out.println("Нет такого пункта! Пробуйте снова:");
            } else {
                System.out.println("Не корректный ввод! Пробуйте снова:");
                scanner.next();
            }
        }
    }



}