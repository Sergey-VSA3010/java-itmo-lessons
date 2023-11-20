package com.company.project.lesson20.task;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class Task01 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student(1, "Женя", Student.Gender.MALE, LocalDate.now().minusYears(10)),
                new Student(2, "Олег", Student.Gender.MALE, LocalDate.now().minusYears(7)),
                new Student(3, "Алена", Student.Gender.FEMALE, LocalDate.now().minusYears(6)),
                new Student(4, "Иван", Student.Gender.MALE, LocalDate.now().minusYears(12)),
                new Student(5, "Алексей", Student.Gender.MALE, LocalDate.now().minusYears(9)),
                new Student(6, "Петр", Student.Gender.MALE, LocalDate.now().minusYears(9)),
                new Student(7, "Иван", Student.Gender.MALE, LocalDate.now().minusYears(17)),
                new Student(8, "Петр", Student.Gender.MALE, LocalDate.now().minusYears(5)),
                new Student(9, "Алена", Student.Gender.FEMALE, LocalDate.now().minusYears(8)),
                new Student(10, "Алена", Student.Gender.FEMALE, LocalDate.now().minusYears(10)),
                new Student(11, "Григорий", Student.Gender.MALE, LocalDate.now().minusYears(7)),
                new Student(12, "Ирина", Student.Gender.FEMALE, LocalDate.now().minusYears(6))
        ));

        // Используя методы Stream API:
        //  1. Разделить учеников на две группы: мальчиков и девочек. Результат: Map<Student.Gender, ArrayList<Student>>

        Map<Student.Gender, ArrayList<Student>> genderInfo = students.stream()
                .collect(Collectors.groupingBy(Student::getGender,
                        Collectors.toCollection(ArrayList::new)));
        System.out.println(genderInfo);
        //  2. Найти средний возраст учеников

        double middleAge = students.stream()
                .map(studentsAge -> Period.between(studentsAge.getBirth(), LocalDate.now()).getYears())
                .collect(Collectors.averagingInt(age -> age));

        System.out.println(middleAge);
        //  3. Найти самого младшего ученика - Stream -> min(Comparator<Student>): int compare(T o1, T o2);

        Optional<Student> minAgeStudent = students.stream()
                .min(Comparator.comparing(studentsAge ->
                        Period.between(studentsAge.getBirth(), LocalDate.now()).getYears()));
        System.out.println("Самый младший ученик: " + minAgeStudent);

        Optional<Student> maxAgeStudent = students.stream()
                .max(Comparator.comparing(studentsAge ->
                        Period.between(studentsAge.getBirth(), LocalDate.now()).getYears()));
        System.out.println("Самый старший ученик: " + maxAgeStudent);

        //  5. Собрать учеников в группы по году рождения, результат - Map<Integer, List<Student>>

        Map<Integer, ArrayList<Student>> mapYearInfo = students.stream()
                .collect(Collectors.groupingBy(year -> year.getBirth().getYear()
                        , Collectors.toCollection(ArrayList::new)));
        System.out.println(mapYearInfo);

        //  6. Отсортировать по полу, дате рождения, имени (в обратном порядке),
        //  собрать в список (ArrayList)


        List <Student> sortstudents = students.stream()
                .sorted(Comparator.comparing(Student::getGender))
                .sorted(Comparator.comparing(Student::getBirth))
                .sorted(Comparator.comparing(Student::getName, Comparator.reverseOrder()))
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(sortstudents);

        // 7. Собрать в список всех учеников с именем == someName
        //  String someName = "Петр";

        List <Student> nameSt = students.stream()
                .filter(name -> name
                        .getName().equals("Петр"))
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(nameSt);


        //  8. Собрать Map<Student.Gender, Integer>,
        //  где Student.Gender - пол,
        //  Integer - суммарный возраст учеников данного пола

        Map<Student.Gender, Integer> sumAge = students.stream()
                .collect(Collectors.toMap(Student::getGender, v -> Period.between(v.getBirth(), LocalDate.now()).getYears(),
                        (v1, v2) -> v1 + v2));
        System.out.println(sumAge);

        System.out.println(LocalDate.now().minusYears(10));

    }
}