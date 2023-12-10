package com.company.project.lesson25;

import java.io.*;
import java.util.ArrayList;

public class Lesson25 {
    public static void main(String[] args) {
        Rate full = new Rate(1, Rate.RateType.FULL);

        Trader trader = new Trader(1, new ArrayList<>(), full,"fdfsds","12345");

        Item item01 = new Item(1, "Стол", 12000, trader);
        Item item02 = new Item(2, "Диван", 78000, trader);
        Item item03 = new Item(3, "Стул", 4500, trader);
        Item item04 = new Item(4, "Люстра", 9300, trader);

        trader.addItem(item01);
        trader.addItem(item02);
        trader.addItem(item03);
        trader.addItem(item04);

         //write(trader);
        //Trader traderFromFile = read();
        write(full);
        write(item02);
        write(trader);
        Rate fullFromFill = read();//ClassCastException
        System.out.println(fullFromFill.equals(full));// false

        Item itemFromFile = read();//ClassCastException
        System.out.println(itemFromFile.equals(item01)); //false

        Trader traderFromFile = read();
        System.out.println(traderFromFile.equals(trader));
    }
    public static <T>void write(T t){
        try(FileOutputStream fileOutput = new FileOutputStream("file.bin");
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput)) {
            //try{
            objectOutput.writeObject(t);
            //}catch (IOException e){
            //System.out.println("Ошибка сериализации writeObject/записи в файл");
        }catch (FileNotFoundException e){
            System.out.println("Ошибка создания файла");
        }catch (IOException e){
            System.out.println("Ошибка сериализации writeObject/записи в файл");
        }
    }
    public  static <T> T read() {
        try (FileInputStream fileInput = new FileInputStream("file.bin");
             ObjectInputStream objectInput = new ObjectInputStream(fileInput)) {

            return (T) objectInput.readObject();// чтение ,десериализация

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
             //throw new RuntimeException(e);
            System.out.println("Ошибка чтения");
        }catch (ClassNotFoundException e){
            System.out.println("Ошибка десериализации, нужный класс не найден");
        }
        return null;

    }
}
