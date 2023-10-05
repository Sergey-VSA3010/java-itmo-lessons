package hw01;

public class Task2 {
    public static void main(String[] args) {
        int floorNumber = 1;
        switch (floorNumber){
            case 1,2 -> System.out.println("На этаже 7 квартир");
            case 3,4 -> System.out.println("На этаже 5 квартир");
            case 5 -> System.out.println("На этаже 2 квартиры");
        }
    }
}
