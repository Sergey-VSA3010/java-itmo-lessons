package com.company.project.lesson07;
import java.util.Random;
public class Author {
    // св-ва, поля, атрибуты
    public long id;// значение по умолчанию 0
    public String name;// null
    public int age;
    public Author(){};// чтобы создавать объект без параметров


public Author(long authorId){
    id = authorId;
}
public Author(long authorId, String name){

    this(authorId);// чтобы не дублировать инструкции
                   // (вызов другог конструктора должен быть первым)
    this.name = name;//this от объекта

}

// методы
    public void printInfo(){
        System.out.print("Автор: id=" + id + ", name= " + name);
        // return
    }

    public String getInfo(){

    return "Автор: id=" + id + ", name= " + name;
    }
    public void getInfo(String prefix) {
        if (prefix == null) {
            throw new IllegalArgumentException("not null!");
        }


    }
}
