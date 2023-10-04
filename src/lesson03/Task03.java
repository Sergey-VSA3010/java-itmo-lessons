package lesson03;

public class Task03 {
    public static void main(String[] args) {
        int price = 100000;
        double sum = 500000;
        double total = sum > price ?  sum * 0.9 : sum;
        System.out.println(total);

        int x = 4;
        int y = 7;
        int z =10;

        if(x > y && x > z)
            System.out.println(x);
        else if (y > x && y > z)
            System.out.println(y);
        else
            System.out.println(z);

    }
}
