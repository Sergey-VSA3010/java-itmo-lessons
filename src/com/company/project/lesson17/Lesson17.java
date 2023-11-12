package com.company.project.lesson17;

import java.util.*;

public class Lesson17 {
    public static void main(String[] args) {
        HashMap<String, Integer> customers = new HashMap<>();
        // интерфейс Map<KeyType, ValueType>
        // предоставляет набор методов для работы с ассоциациями: ключ - значение
        // одному ключу всегда соответствует только одно значение
        // ключи не могут дублироваться
        // порядок хранения ключей и связанных с ними значений зависит от конкретных реализаций
        // есть возможность получения: set ключей, collection значений, set пар (ключ+значение)

        // Реализации:
        // 1. HashMap<KeyType, ValueType>
        // неупорядоченная по ключам ассоциация
        // позволяет использовать null в качестве ключа
        // реализована на основе hash таблицы

        // 2. LinkedHashMap<KeyType, ValueType>
        // упорядоченная по ключам ассоциация
        // позволяет использовать null в качестве ключа
        // реализована на основе hash таблицы

        // 3. EnumMap<KeyTypeEnum, ValueType>
        // использует только элементы перечислений в качестве ключей
        // хранит только массив значений
        // при создании экземпляра необходимо передавать ссылку на класс перечисления

        // 4. TreeMap<KeyType, ValueType>
        // хранит пары в отсортированном по ключам виде
        // для KeyType должен быть определен натуральный порядок сортировки или
        // в конструктор TreeMap необходимо передать экземпляр Comparator

        // 5. WeakHashMap<KeyType, ValueType>
        // неупорядоченная по ключам ассоциация
        // реализована на основе hash таблицы
        // очищается сборщиком, когда на ключи не остаётся сильных ссылок


        //  Ключи типа String
        //  Значения типа Integer
        customers.put("Москва", 790);
        customers.put("Ростов", 300);
        customers.put("Ростов", 400); // такой пары не будет т.к.  ключ "Ростов "
        // произойдет перезапись по ключу size = 3

        customers.put("Питер", 564);
        customers.put("Самара", 500);
        customers.put(null, 500);
        customers.put("Спб", null);


        customers.remove(null); // 1000 удаление пары по ключу
        // удалит,если в мапе существует пара "Ростов" : 400
        customers.remove(null);// null
        customers.remove("Спб");// null
        customers.remove("Ростов", 400); // true
        customers.remove("Самара", 400); // false  size = 3

        // Замена значения по ключу
        // Метод вернет старое значенте
        customers.replace("Самара", 1200); // 500
        // Заменит,если в мапе существует пара "Москва" : 790 вернёт True
        customers.replace("Москва", 790, 840); // True

        System.out.println(customers.size()); // 3
        System.out.println(customers.isEmpty()); // false

        // Получение значения по ключу (не удаление)
        System.out.println(customers.get("Москва"));// 840
        System.out.println(customers.get("Спб"));// null

        System.out.println(customers.getOrDefault("Москва", -1)); //вернет -1
        System.out.println(customers.getOrDefault("Спб", -1));
        Integer spbValue = customers.getOrDefault("Спб", -1);
        if (spbValue == -1) {
            System.out.println("Не удалось получить инфо по спб");
        } else {
            System.out.println(spbValue);// может быть null
        }
        if (customers.containsKey("Ростов")) { // по ключу
            System.out.println("Информация о Ростове уже содержится");
        }
        if (customers.containsValue(1000)) { // по значению
            System.out.println("Значение 1000 содержится в мапе");
        }
        // Коллекция значений
        Collection<Integer> customersValues = customers.values();
        // Множество ключей
        Set<String> customersKeys = customers.keySet();
        // Множество пар (ключ + значение)
        Set<Map.Entry<String, Integer>> customersPairs = customers.entrySet();

        for (Map.Entry<String, Integer> customersPair : customersPairs) {
            System.out.println(customersPair.getValue());
            System.out.println(customersPair.getKey());
            if (customersPair.getValue() > 1000) {
                System.out.println("Вгороде " + customersPair.getKey() +
                        " количество покупателей больше 1000");
            }
            ArrayList<String> cities = getCities(customers, 500);
            System.out.println(cities);


        }
        // Ключ типа ClientAuthData.Role
        // Значения типа List<ClientAuthData
        EnumMap<ClientAuthData.Role,List<ClientAuthData>> clientsByRole
                = new EnumMap<>(ClientAuthData.Role.class);
        System.out.println(clientsByRole.size());// 0

        //USER, ADMIN, MODERATOR
        clientsByRole.put(ClientAuthData.Role.USER,new ArrayList<>());
        clientsByRole.put(ClientAuthData.Role.MODERATOR,new ArrayList<>());
        System.out.println(clientsByRole.size());// 2
        clientsByRole.put(ClientAuthData.Role.ADMIN,new ArrayList<>());

        // List<ClientAuthData>[] values = new List<ClientAuthData>[3];
        //values[ClientAuthData.Role.USER.ordinal()] = new ArrayList<>();

        // создание объекта(клиента)
        ClientAuthData data01 = new ClientAuthData("qqq","123",ClientAuthData.Role.USER);
        // добавление в мапу
        clientsByRole.get(ClientAuthData.Role.USER).add( data01);
        ////values[ClientAuthData.Role.USER.ordinal()]
        System.out.println(clientsByRole.size());//2

        ClientAuthData clientData = new ClientAuthData("222", "222", ClientAuthData.Role.MODERATOR);
        add(clientsByRole, clientData);
        System.out.println(clientsByRole);


        EnumSet<ClientAuthData.Role> rolesFull = EnumSet.allOf(ClientAuthData.Role.class);//множество со всеми перечислениями
        EnumSet<ClientAuthData.Role> rolesEmpty = EnumSet.noneOf(ClientAuthData.Role.class);// пустой EnumSet в котороый можно добавлять
        rolesEmpty.add(ClientAuthData.Role.ADMIN);
        rolesEmpty.add(ClientAuthData.Role.MODERATOR);
        EnumSet<ClientAuthData.Role> rolesEx = EnumSet.complementOf(EnumSet.of(ClientAuthData.Role.USER));// хранятся все кроме указанных
        EnumSet<ClientAuthData.Role> fromTo = EnumSet.range(ClientAuthData.Role.USER, ClientAuthData.Role.values()[2]);

        TreeMap<String, List<String>> students = new TreeMap<>();
        students.put("AGroup", new ArrayList<>(Arrays.asList("Петрова", "Иванов")));
        students.put("KGroup", new ArrayList<>(Arrays.asList("Попова", "Романова")));
        students.put("TGroup", new ArrayList<>(Arrays.asList("Гурова", "Ртищев")));
        students.put("EGroup", new ArrayList<>(Arrays.asList("Бокарев", "Потапова")));


    }

    //написать static метод,
    // который принимает на вход HashMap<String, Integer> map и int max,
    // и возвращает список городов, где количество покупателей меньше max
    private static ArrayList<String> getCities(HashMap<String, Integer> map, int max) {
        ArrayList<String> cities = new ArrayList<>();
        for (Map.Entry<String, Integer> keyValuePair : map.entrySet()) {
            if (keyValuePair.getValue() < max) {
                cities.add(keyValuePair.getKey());

            }

        }
        return cities;

    }
    //Написать static метод, который принимает на вход
    //EnumMap<ClientAuthData.Role, List<ClientAuthData>> map
    //и ClientAuthData clientData и добавляет clientData
    //в список в зависимости от роли.
    public static void add(EnumMap<ClientAuthData.Role,List<ClientAuthData>> map,ClientAuthData authData){
        if (map.get(authData.getRole())==null){
            map.put(authData.getRole(),new ArrayList<>());
        }
        map.get(authData.getRole()).add(authData);

    }
    //написать static метод, который принимает на вход
    //EnumMap<ClientAuthData.Role, List<ClientAuthData>> map
    //и возвращает Map<Sting, String> c парами userName - password
    //в результирующий Map должны попасть userName и password
    //пользователей (ClientAuthData.Role.USER)
    private static Map<String, String> getUsersLoginPasswords(EnumMap<ClientAuthData.Role, List<ClientAuthData>> map){
        List<ClientAuthData> clientAuthData = map.get(ClientAuthData.Role.USER);
        if (clientAuthData == null) return null;
        Map<String, String> loginPassword = new HashMap<>();
        for (ClientAuthData data : clientAuthData) {
            loginPassword.put(data.getUserName(), data.getPassword());
        }
        return loginPassword;
    }


    public static Map<String,String> getUserByRole(EnumMap<ClientAuthData.Role, List<ClientAuthData>> map){
        List<ClientAuthData> user = map.get(ClientAuthData.Role.USER);
        Map<String,String> users = new HashMap<>();
        for (ClientAuthData client : user){
            users.put(client.getUserName(),client.getPassword());
        }
        return users;
    }
}
