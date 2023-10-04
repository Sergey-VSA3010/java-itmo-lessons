package lesson02;

public class ArithmeticOperations {
    public static void main(String[] args) {
        // + - * / %
        // -1   унарный минус - оператор ,1 операнд
        // 3 - 4 бинарный минус
        int x = 20, y = -1;
        int result = x + y;
        System.out.println(result);// 19

        byte var01 = 89, var02 = 11;
        int byteResult01 = var01 + var02;
        byte byteresult02 =(byte)(var01 + var02);

        double bill = 500;
        double halfBill = bill/2;

        int number = 101, divisor =10;
        int withoutLastDigit = number/divisor;
        // результат 10 т.к int
        double withoutLastDigit02 = (double)number/divisor;
        System.out.println(withoutLastDigit);

        int n = 40;
        long m = 100L;// повышение до лонг
        long nmresult = n*m;
        number = 9;
        divisor = 2;
        int evenOrOddResult = number%divisor; // 1

        var var1 = 60l;
        var var2 = -20;
        var var3 = 10.5;
        var varResult = var1 + var2 * var3;
        System.out.println(varResult);// будет double

        int num = 10;
        num = num + 10;// + оператор присвоения
        num += 10;
        num -= 10;
        num *= 10;
        num /= 10;
        num %= 10;
        System.out.println(num);

    }
}
