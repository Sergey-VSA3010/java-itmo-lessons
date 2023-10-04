package lesson02;

public class DataTypes {
    // комментариц
    /*многострочный комментарий
    *
    * */
    public static void main(String[] args) { // точка входа в приложение
        System.out.println("Консольный вывод");
        int yearOfBirth;
        int length,height;
        yearOfBirth=1990;// первое присвоение значения переменной - инициализация


        // примитивные типы данных
        byte readByte = 56;
        short userAge = 35;
        long temp = 12L, planetAge = 400_000_000_000L;
        // l и L явно указывают на тип long

        float outsideTemp = -12.5f, catAge = 4.5f;// f и F явно указывают на тип float
        double weigth = 200.5;
        // логические переменные
        boolean isActiv = true;
        boolean isConnected = false;
        System.out.println(isActiv);
        char aLetter = 'a';
        System.out.println(aLetter);
        int number01 = 12000;
        long number02 = number01;  // автоматическое приведение типов
        System.out.println(number01);
        System.out.println(number02);

        int distance = 100;
        byte smallDistance = (byte) distance; //явное приведение типов
        System.out.println(smallDistance);

        //объявление переменных через var
        // начиная с java 10
        var version = 10; // int
        var bigNumber = 10L;  // long
        var connected = true; // boolean
        var balance = 4000.8; // double
        var numberOfHours = 50.5F; //float
        var price = (short) 290; // short

    }
}
