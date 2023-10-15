package hw05;

public class Task01 {
    public static void main(String[] args) {
        //Разобрать работу методов класса String:

        // charAt – возвращает символ, расположенный по указанному индексу строки.
        // Индексы строк в Java начинаются с нуля.

        // indexOf – возвращает индекс в данной строке первого вхождения
        // указанного символа или -1, если символ не встречается.

        // isBlank - возвращает результат запроса, является ли эта строка «пустой»,
        // не содержащих никаких символов, кроме пробелов,
        // табуляций и прочих невидимых символов.

        // isEmpty -- возвращает true только если строка абсолютно пустая ("")
        // или имеет значение null.

        // substring - возвращает новую строку, которая является подстрокой данной строки.

        String s = "Программирование!";
        char result1 = s.charAt(3);
        int res = s.indexOf('м');
        boolean isBlank = s.isBlank();
        boolean isEmpty = s.isEmpty();
        String substr = s.substring(4,10);
        String substr2 = s.substring(3);

        System.out.println("Третий символ строки " + result1);
        System.out.println(res);
        System.out.println(isBlank);
        System.out.println(isEmpty);
        System.out.println(substr);
        System.out.println(substr2);

        //Дана строка, содержащая только буквы и цифры.
        // Вывести информацию о том, является ли данная трока палиндромом.



        StringBuilder str = new StringBuilder("AbcddcbA") ;
        String str2 = str.toString();
           String str1 = str.reverse().toString();

           if (str1.equalsIgnoreCase(str2)){
               System.out.println("Полиндром!");}
           else
               System.out.println("Не полиндром!");

    }
}
