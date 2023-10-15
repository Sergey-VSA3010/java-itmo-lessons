package com.company.project.lesson07;
import java.util.Random;
public class lesson07 {
    public static void main(String[] args) {
        Author author2 = new Author(4,"Den");
        Author author3 = new Author();
        Author author = new Author(2);
        Author author1 = new Author(4,"Jack");
        System.out.println(author.name);
        author.name = "Tom";
        author.id = 123;
        author.age = 34;
        author.getInfo();
        Book book3 = new Book("hyj",4);

        String info02 = author2.getInfo();
        author2.getInfo();


        Book book1 = new Book("qwert");
        book1.setName("qwweer");
        book3.addAuthor(author1);
        System.out.println(author.name + " " + author.age);
        System.out.println();
        System.out.println(author1.getInfo());

    }
}
