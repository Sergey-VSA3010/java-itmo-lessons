package com.company.project.lesson13;

import java.lang.ref.WeakReference;

public class PrimitiveWrappers {//Примитивные обертки
    public static void main(String[] args) {
        int num = 567;
        Integer count = 34;

        // автоупаковка - переменная класса-обертки
        // присваивается значение примитива
        Integer age = 26;// автоупаковка
        count = num;// автоупаковка

        // Авторапаковка - переменной примитивного типа
        // присваивается значение обертки

        double price;
        Double value = 45.6;
        price =value;// значение обертки присваиваетя примитиву

        // ПРавила автоупаковки автораспаковки
        // 1. автоупаковка не работает,если тип
        // примитива не соответствует классу обертки
                  byte oneB = 1;
                  //Integer oneI = oneB;
                  Integer oneI = (int)oneB;// только через привидение
        // 2. На автораспаковку правило №1 не распространяется
        // 3. Аргументы методов подчиняются
        // правилам автоупаковки и автораспаковки
        print((int)oneB,(float)45.7);

        // 4. Автоупаковка и автораспаковка
        // не работает с массивами

        Integer x = 9;
        Integer y = 9;
        System.out.println(x == y);//true  == -сравнивает ссылки
        System.out.println(x.equals(y));//true
        Integer k = 900;// выход за байтовый диапазон
        Integer l = 900;
        System.out.println(k == l);//false
        System.out.println(k.equals(l));//true
         Number number = 800;
         if (number instanceof Integer i) System.out.println(i);

    }
    private static void print(Integer i,Float f){
        System.out.println(i);
        System.out.println(f);
    }
}
