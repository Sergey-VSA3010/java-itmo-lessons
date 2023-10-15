package hw04;
import java.util.Arrays;
import java.util.Scanner;
public class Task04 {

    public static void main(String[] args) {

        //Объявить массив целых чисел. Длина массива - 15.
        // Заполнить массив четными числами в диапазоне [10, 100).
        // Для заполнения массива использовать цикл.

        int[] temps = new int[15];
        for (int i = 0; i < temps.length; i++) {
            int x = (10 + (int) (Math.random() * (100) - 10));
            if (x % 2 != 0) {
                x++;
            }
            temps[i] = x;
        }
        System.out.println(Arrays.toString(temps));

        //Создать два массива целых чисел на 5 элементов каждый.
        // Массивы необходимо заполнять значениями в цикле. Значения вводит пользователь с клавиатуры.
        //Если число отрицательное, добавить его в первый массив.
        //Если число положительное, добавить его во второй массив.
        //Программа завершает работу, когда оба массива заполнены или, если пользователь ввёл 0

        int[] temps01 = new int[5];
        int[] temps02 = new int[5];
        System.out.println("Введите число");
        Scanner y = new Scanner(System.in);
        int num = y.nextInt();
        int x =0,z = 0;


while (num !=0 && temps01.length ==temps02.length)
    for (int i = 0; i < temps01.length; i++)
       // for (int j = 0; j < temps02.length; j++)
            if (num > 0) {
            temps01[x] = num;
            x++;


        }else if (num < 0) {
            temps02[z] = num;
            z++;


            System.out.println(Arrays.toString(temps01));
            System.out.println(Arrays.toString(temps02));
        }
    }
}


