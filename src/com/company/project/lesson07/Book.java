package com.company.project.lesson07;
import java.util.Random;
public class Book {
    private String name;//  значение по умолчанию null (как и для всех стальных ссылочных типов)
    private boolean isPublished; //значение по умолчанию false(для типа Boolean)
    private Author [] authors = new Author[4];
    private  int numberOfAutors;

    public Book(String name) {
        setName(name);
    }
    public Book(String name,int numberOfAutors){
        this.name = name;
        setNumberOfAutors(numberOfAutors);
    }
    public String getName() {//Getter

        return name;
    }

    public void setName(String name){// Setter
        // if(name == null) return;
        if(name == null){
            throw new IllegalArgumentException("not null!");
        }
        this.name = name;
    }

    public int getNumberOfAutors() {
        return numberOfAutors = 1 + (int) (Math.random() * 4);
    }

    public void setNumberOfAutors(int numberOfAutors) {
        if (numberOfAutors == 0){
            throw new IllegalArgumentException("Номер должен быть!");
        }
        this.numberOfAutors = numberOfAutors;
    }
    public void addAuthor (Author author) {

        
        for (int i = 0; i < authors.length;i++ ) {
            if (authors[i] == null) {
                authors[i] = new Author();

                return;
            }

        }
    }
}
