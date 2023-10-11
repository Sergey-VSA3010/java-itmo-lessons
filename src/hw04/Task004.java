package hw04;

import java.util.Scanner;

public class Task004 {
    public static void main(String[] args) {

        ////Заполните массив на len элементов (размер массива вводит пользователь)
        //    // случайным целыми числами и выведете
        //    // максимальное,
        //    // минимальное и
        //    // среднее арифметическое значение элементов массива.

        System.out.println("Введите длинну массива");

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] array = new int[n];
        double sum = 0;
        int maxValue = array[0];

        for (int i = 0; i < array.length; i++) {
            int value = (int) (Math.random() * 100);
            array[i] = value;
            sum += array[i];

            System.out.print(array[i] + " ");
        }
        int minValue = array[0];
        for (int i = 0; i < array.length; i++) {

            if (array[i] > maxValue)
                maxValue = array[i];

            if (array[i] < minValue)
                minValue = array[i];
        }

        System.out.println("Макс. значение " + maxValue);
        System.out.println("Мин. значение " + minValue);
        System.out.println("Среднее арифм. " + sum / n);

    }
}



