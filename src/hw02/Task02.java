package hw02;

public class Task02 {
    public static void main(String[] args) {


        //Задание 1.
        int number = 10+(int)(Math.random()*(490+1));
        System.out.println("Случайное чило " + number);
        if (number > 25 && number < 200)
            System.out.println("Число " + number +
                " содержится в интервале (25;200)");
        else System.out.println("Число " + number +
                " не содержится в интервале (25;200)");



        // Задание 2.
            int currentScoreValue = 90;
            if(currentScoreValue <= 100 && currentScoreValue >= 90)
                System.out.println("Первое место!");
            else if(currentScoreValue < 90 && currentScoreValue >= 80)
                System.out.println("Второе место!");
            else if(currentScoreValue < 80 && currentScoreValue >= 70)
                System.out.println("Третье место!");
            else System.out.println("Не занял место!");

            // Задание 3.
            int x,y;
            x = 33;
            y = 6;
            if (x>0 && y>0) System.out.println("Первая четверть");
            else if (x>0 &&y<0) System.out.println("Четвертая четверть");
            else if (x<0 && y<0) System.out.println("Третья четверть");
            else System.out.println("Вторая четверть");

            // Задание 4.




           // Задание 5.
        int couponNumber = 555;

        double resultSum = 5600;
        switch (couponNumber){
            case 111:
                resultSum = resultSum - resultSum * 0.1;
                System.out.println("Цена с учетом скидки 10%,равна " + resultSum);
                break;
            case 333:
                resultSum = resultSum - resultSum * 0.2;
                System.out.println("Цена с учетом скидки 20%,равна " + resultSum);
                break;
            case 555:
                resultSum = resultSum - resultSum * 0.3;
                System.out.println("Цена с учетом скидки 30%,равна " + resultSum);
                break;

            default:
                System.out.println(resultSum + " Cкидка не предусмотрена");
        }



    }


}