package lesson05;

import javax.swing.*;

public class Massiv {
    public static void main(String[] args) {
        int[] task01 = {4, 6, 89, 90, 22, 56, 78};




        // Дан отсортированный массив положительных целых чисел task02.
        // Найти в данном массиве такие два числа (одну пару), чтобы их сумма была равна targetSum.
        int[] task02 = {1, 3, 7, 8, 9, 10, 13};
        int targetSum = 10;
          loop :for (int i = 0; i < task02.length; i++) {
            for (int j = i + 1; j < task02.length ; j++) {
                if (task02[i] + task02[j] == targetSum){

                    System.out.println(task02[j]);
                    System.out.println(task02[i]);
                    break loop;


                }

            }

        }


    }
}
