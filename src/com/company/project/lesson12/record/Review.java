package com.company.project.lesson12.record;

import java.time.LocalDateTime;
// Review - название
// (long id, String text, LocalDateTime createdAt) - заголовок(header)
// со списком компонентов(внутри скобок)
// не могут наследоваться
// не могут иметь наследников(final)
// могут имплементировать интерфейсы,включая sealed
// могут быть вложенными и могут иметь вложенные записи
// могут обьявляться с generic типами

public record Review(long id, String text, LocalDateTime createdAt) {
    // тело записи(record)
    // нельзя обьявлять не static поля

    // можем написать реализацию канонический(canonical) конструктора
    //public record Review(long id, String text, LocalDateTime createdAt) {}
    // или написать реализацию компактного(compact) конструктора
    public Review /* (по умолчанию принимает компоненты записи)*/{
        if( id < 0 || text.trim().length() < 5 || createdAt == null)
            throw new IllegalArgumentException("Переданы невалидные данные");
        // по умол
    }
    // можно перегрузить конструктор,
    // но в них необходимо вызвать один из обьвленных
    public Review(String text){
        this(0,text);
    }
    public Review(long id,String text){
        this(id,text,null);
    }
    // можно объявлять собственные методы(статические и нет)
    // можно написать собственную логику геттеров,
    // equals,hashCode и ToString
    @Override
    public String text(){
        return text.toLowerCase();
    }
}

