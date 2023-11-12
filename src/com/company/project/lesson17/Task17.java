package com.company.project.lesson17;

import java.util.*;

public class Task17 {
    public static void main(String[] args) {

        //Реализовать статический метод, который принимает Collection<String> strings и возвращает
        // количество одинаковых слов в коллекции strings в виде Map<String, Long>.
        // Где ключи - слова, а значения - количество повторений.


        Collection<String> words = new ArrayList<>();
        words.add("Понедельник");
        words.add("Вторник");
        words.add("Среда");
        words.add("Суббота");
        words.add("Среда");
        words.add("Понедельник");
        words.add("Понедельник");

        String text = "It is a uncover long established fact that a reader will be " +
                "distracted uncover by the readable content of a page " +
                "when looking at its layout The point of using uncover Lorem Ipsum is " +
                "that sites it has a more-or-less normal distribution of letters" +
                "as uncover opposed to still using Content here humour uncover content " +
                "here making it look like readable English Many desktop publishing " +
                "packages and web page editors now use Lorem Ipsum as their default model " +
                "text and a search for lorem ipsum will " +
                "uncover many web sites still uncover in their infancy Various versions " +
                "uncover have evolved over the years uncover sometimes by accident" +
                " sometimes on purpose injected humour and the like";
        System.out.println(method1((List<String>) words));
        System.out.print(sortWords(text));
        System.out.println();
    }


    private static Map<String, Integer> method1(List<String> words) {
        HashMap<String, Integer> mapa = new HashMap<>();
        for (String str : words) {
            mapa.put(str, mapa.getOrDefault(str, 0) + 1);
        }
        return mapa;
    }


    //Реализовать статический метод, принимающий на вход String word и String text
    // и возвращающий частоту встречаемости слова word в тексте text в виде Map<String, Long>.
    // Где ключ - слово, а значение - частота встречаемости

    private static HashMap<String, Long> method2(String text, String word) {
        text = text.toLowerCase();
        String[] strings = text.split(" ");
        HashMap<String, Long> map = new HashMap<String, Long>();

        for (String s : strings) {

            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1L);
            }

        }
        return map;
    }
    //Реализовать статический метод, принимающий на вход String text
    // и возвращающий Map<Integer, List<String>>где ключи - количество букв в словах,
    // значения - списки соответствующих слов.

    public static Map<Integer, HashSet<String>> sortWords(String text) {
        String[] strings = text.split(" ");
        Map<Integer, HashSet<String>> map2 = new HashMap<>();
        for (String word : strings) {
            if (map2.get(word.length()) == null) {
                map2.put(word.length(), new HashSet<>());
                map2.get(word.length()).add(word);
            } else {
                map2.get(word.length()).add(word);
            }
        }
        return map2;

    }

    private static void  tenWords(String text) {
        text = text.toLowerCase();
        String[] strings = text.split(" ");
        HashMap<String,Integer> map3 = new HashMap<>();
        for (String d : strings) {
            map3.put(d, map3.getOrDefault(d, 0) + 1);
        }


        int max = (Collections.max(map3.values()));
        int count = 1;
        for (int i = max; i > 0; i--) {
            for (Map.Entry<String, Integer> pair : map3.entrySet()) {
                if (count > 10) break;
                if (pair.getValue() == i) {
                    count++;
                }
            }
        }

    }
}
