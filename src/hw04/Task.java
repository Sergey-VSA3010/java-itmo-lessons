package hw04;

import java.util.Arrays;
import java.util.Scanner;

public class Task {
    public static void main(String[] args) {
        //Создать два массива целых чисел на 5 элементов каждый.
        // Массивы необходимо заполнять значениями в цикле. Значения вводит пользователь с клавиатуры.
        //Если число отрицательное, добавить его в первый массив.
        //Если число положительное, добавить его во второй массив.
        //Программа завершает работу, когда оба массива заполнены или, если пользователь ввёл 0

        int[] temps01 = new int[5];
        int[] temps02 = new int[5];
        int num ;
        int j = 0;
        int i = 0;

        do {
            System.out.println("Введите число");
            Scanner y = new Scanner(System.in);
            num = y.nextInt();

            if (num<0 && i< 5 ){
                temps01[i] = num;
                i++;


            } else if (num > 0 && j < 5) {
                temps02[j] = num;
                j++;

            }

        }while (num!=0);

    }
}