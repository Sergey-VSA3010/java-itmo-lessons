package lesson04;
import java.util.Scanner;
public class increment {
    public static void main(String[] args) {

       /* int b = 1;
        int result = b++ + ++b - b++ - b-- + ++b;
        System.out.println(result);

        // b = 1+3-3-4+4


        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите целое число");
        int intValue = scanner.nextInt();
        int count = 0;
        double sum = 0;
        int maxValue = 0;
        while  (scanner.hasNextInt() && ((intValue = scanner.nextInt()) > 0)) {
           // System.out.println("Введите целое положительное число или 0 для выхода из программы");
            //intValue = scanner.nextInt();
            if (intValue == 0) { // если пользователь введет 0
                break; // выход из текущего цикла
            }
            if (intValue > 0) {
                sum += intValue;
                ++count;
                sum = sum / count;
                if (intValue > maxValue) maxValue = intValue;
                //continue;


                System.out.println(intValue);
                System.out.println(count);
                System.out.println(sum);
                System.out.println(maxValue);*/

                double price = 200;
                for (double quantity = 0.1;quantity <=1; quantity += 0.1) {
                    double currentPrice = quantity*price;
                    System.out.println(quantity + "кг. " + " стоят " + currentPrice);

                }

            }
            int sum = 0;


}




