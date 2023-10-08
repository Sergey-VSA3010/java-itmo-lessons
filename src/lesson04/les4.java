package lesson04;
import java.util.Scanner;
public class les4 {
    public static void main(String[] args) {


        for (int x = 1; x<=6 ; x++) {
            for (int y = 1;y <= x; y++){

            System.out.print(y);
            }
            System.out.println();
        }
        for (int x = 6; x > 0;x--){
            for (int y = 1;y < x; y++){
                System.out.print(y);
            }
            System.out.println(x);
        }
    }
}
