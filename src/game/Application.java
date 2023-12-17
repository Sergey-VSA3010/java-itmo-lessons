package game;

import game.commands.*;

import java.util.Map;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        ReceiverCommand command = new ReceiverCommand();
        Scanner scanner = new Scanner(System.in);
        Command startGame = new Start(command);
        Command exitGame = new Exit(command);
        Command saveGame = new Save(command);

        Menu menu = new Menu();
        menu.regCommand(1, startGame);
        menu.regCommand(2, exitGame);
        menu.regCommand(3, saveGame);

        while (true) {
            int choice;
            System.out.println("Выберите пункт: ");
            for (Map.Entry<Integer, Command> map : menu.getCommand().entrySet()) {
                System.out.println(map.getKey() + ". " + map.getValue());
            }
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice > 0 && choice <= menu.getCommand().size()) {
                    menu.execute(choice);
                    break;
                }
                System.out.println("Такой пункт отсутствует! Попробуйте снова:");
            } else {
                System.out.println("Не правильный ввод! Попробуйте снова:");
                scanner.next();
            }
        }

    }
}