package hw03;

import java.util.Scanner;

public class Task03 {
    public static void main(String[] args) {
        // Вывести на экран первые 10
        // элементов последовательности
        //       2 4 6 8 10 и тд

        int num = 0;
        for (int i = 0; i < 10; i++) {
            num += 2;
            System.out.println(num);
        }

        // Для введённого пользователем с клавиатуры
        // целого положительного числа посчитайте
        // сумму всех его цифр

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите целое положительное число");
        int number = scanner.nextInt();
        int sum = 0;
        while (number != 0) {

            sum += (number % 10);

            number /= 10;
        }
        System.out.println(sum);

        //Программа загадывает число в диапазоне [1;9]
        //Пользователь вводит число с клавиатуры
        //Программа в зависимости от введенного числа выводит в консоль следующее:
        //"загаданное число больше"
        //"загаданное число меньше"
        //"Вы угадали" (программа завершает работу)
        //Если введен 0, вывести "выход из программы" (программа завершает работу)


        int x = 1 + (int) (Math.random() * (10));// x - загаданное число
        System.out.println("Введите число.");
        Scanner scan = new Scanner(System.in);

        while (true) {
            int y = scan.nextInt();// y - число вводимое пользователем
            if (y == 0) {
                System.out.println("Вы ввели 0!");
                break;
            }
            if (y > x) {
                System.out.println("Загаданное число меньше!");
                continue;
            }
            if (y < x) {
                System.out.println("Загаданное число больше!");
                continue;
            } else if (x == y) System.out.print("Вы угадали!");
            break;


        }

    }
}
