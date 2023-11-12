package com.company.project.lesson12.record.exeptions;

public class Exceptions {
    public static void main(String[] args) {
        // Исключение времени выполнения(наследники RunTimeException)
        // необрабатываемые,unchecked
        int[] ints = new int[4];
        int index = 9;
        //ints[index] = 5;  --- java.lang.ArrayIndexOutOfBoundsException

        Object object = "Hello";//String
        //Integer integer = (Integer) object;//----java.lang.ClassCastException

        //System.out.println(5/0);//-----java.lang.ArithmeticException

        String string = null;
        //System.out.println(string.length());//-----java.lang.NullPointerException

        try {
            //потенциально опасный код
            System.out.println(string.length());


        } catch (NullPointerException exception) {
            System.out.println("exception");
        }
        try {// потенциально опасный код
             // несколько catch блоков используются
            // если есть необходимость реагировать на разные исключения
            // разными способами
            System.out.println(string.length());
            Integer integer = (Integer) object;

        } catch (NullPointerException e) {
            System.out.println(e.getMessage());

        } catch (ClassCastException e) {
            e.printStackTrace();
        }

        try {
            // потенциально опасный код
        }catch (NullPointerException | ClassCastException ex){
            System.out.println(ex.getMessage());
    }
        try {
            // потенциально опасный код
        }catch (RuntimeException exception){
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
}

}
