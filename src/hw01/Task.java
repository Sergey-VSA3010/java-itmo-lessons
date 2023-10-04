package hw01;

public class Task {
    public static void main(String[] args) {

        //объявите переменные для хранения информации об общем количестве писем
        // и о количестве отправленных писем.
        // Присвойте значения этим переменным.
        // Выведите в консоль, сколько писем осталось отправить.

        int totalEmails, sentEmails;
        totalEmails = 465;
        sentEmails = 278;
         int remainsToSend = totalEmails - sentEmails;
        System.out.println("Осталось отправить " + remainsToSend + " писем");

        //Объявить и инициализировать переменные для хранения
        // времени (в часах) и расстояния (в километрах).
        // Найти и вывести в консоль скорость, выраженную в метрах в секунду.

        double time,distance,speed;
        time = 3.4;
        distance = 78.8;
        speed = (distance*1000)/(time*3600);
        System.out.println("Скорость составила " + speed + " м/с" );

        //Найти сумму цифр целого положительного двузначного числа.
        // Результат вывести в консоль.

        int number, sum;
         number = 65;
         sum = number/10 + number%10;
         System.out.println("Сумма числа " + sum);

        //Поменять значения 2х переменных местами, используя арифметические операторы.
        // Результат вывести в консоль.

        int x,y;
        x = 10;
        y = 45;
        x = x + y;
        y = x - y;
        x = x - y;
        System.out.println("После перемены местами X = " + x + ",а Y = " + y);
    }
}
