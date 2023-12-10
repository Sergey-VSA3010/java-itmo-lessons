package com.company.project.lesson29;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class Lesson29 {
        public static void main(String[] args) {
              /*Fruit fruit01 = new Fruit(Fruit.FruitType.BANANA, 150, 10);
        Fruit fruit02 = new Fruit(Fruit.FruitType.BANANA, 150, 10);
        // Взаимная блокировка потоков
        Thread thread01 = new Thread(()->{
            synchronized (fruit02){
                // инструкции
                synchronized (fruit01) {
                    // инструкции
                }
            }
        });
        Thread thread02 = new Thread(()->{
            synchronized (fruit01){
                // инструкции
                synchronized (fruit02) {
                    // инструкции
                }
            }
        });
        thread01.start();
        thread02.start();*/
            List<String> tokens = new ArrayList<>(
                    Arrays.asList("123", "456", "789"));
            ReentrantLock lock = new ReentrantLock(true);
            Semaphore semaphore = new Semaphore(tokens.size()/*true*/);

            // токены нужны только для подключения
            // токен можно использовать только один раз
            // использованный токен нужно заменить новым

            new SynchronizedClientService(tokens,lock,semaphore).start();
            new SynchronizedClientService(tokens,lock,semaphore).start();
            new SynchronizedClientService(tokens,lock,semaphore).start();
            new SynchronizedClientService(tokens,lock,semaphore).start();
            new SynchronizedClientService(tokens,lock,semaphore).start();

            ArrayBlockingQueue<String> tokensQueue =
                    new ArrayBlockingQueue<>(3,true,Arrays.asList("123", "456", "789")); // true - флаг справедливости
             //если используем весь конструктор
            QueueClientService service01 = new QueueClientService(tokensQueue);
            QueueClientService service02 = new QueueClientService(tokensQueue);
            QueueClientService service03 = new QueueClientService(tokensQueue);

            new Thread(service01).start();
            new Thread(service01).start();
            new Thread(service01).start();
            new Thread(service01).start();

            // пулы потоков

            ExecutorService service = Executors.newFixedThreadPool(3);
            //[T1,T2,T3] пул на три потока
            service.execute(()->
                    System.out.println("Задача №1"));
            service.execute(service01);
            service.execute(service01);
            service.execute(service01);
            service.shutdown();
            //List<Runnable> runnables = service.shutdownNow();

            //   Гибкий
            Lesson29Pool pool = new Lesson29Pool(3,8,
                    1000, TimeUnit.MICROSECONDS,
                    new ArrayBlockingQueue<>(100));
            pool.execute(service01);
            pool.shutdown();


        }
    }


