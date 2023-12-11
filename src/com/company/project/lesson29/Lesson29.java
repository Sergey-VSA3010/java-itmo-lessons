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

        new SynchronizedClientService(tokens, lock, semaphore).start();
        new SynchronizedClientService(tokens, lock, semaphore).start();
        new SynchronizedClientService(tokens, lock, semaphore).start();
        new SynchronizedClientService(tokens, lock, semaphore).start();
        new SynchronizedClientService(tokens, lock, semaphore).start();

        ArrayBlockingQueue<String> tokensQueue =
                new ArrayBlockingQueue<>(3, true, Arrays.asList("123", "456", "789")); // true - флаг справедливости
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
        service.execute(() ->
                System.out.println("Задача №1"));
        service.execute(service01);
        service.execute(service01);
        service.execute(service01);
        service.shutdown();
        //List<Runnable> runnables = service.shutdownNow();

        //   Гибкий
        Lesson29Pool pool = new Lesson29Pool(3, 8,
                1000, TimeUnit.MICROSECONDS,
                new ArrayBlockingQueue<>(100));
        pool.execute(service01);
        pool.shutdown();

        // и другие методы ExecutorService

        ExecutorService cachedService = Executors.newCachedThreadPool();
        cachedService.execute(() -> {
            System.out.println("Cached pool Fast Task");
        });   // на быстрые задачи
        cachedService.shutdown();// не принимает новые задачи

        ExecutorService singlPool = Executors.newSingleThreadExecutor();
        Future<String> taskResultContainer = singlPool.submit(new RequestTask());

        String result = null;
        try {
            // result = taskResultContainer.get();
            result = taskResultContainer.get(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            System.out.println("у ожидающего потока был вызван метод interrupt");
        } catch (ExecutionException e) {
            System.out.println("во время выполнения задачи было выброшено исключение");
        } catch (TimeoutException e) {
            System.out.println("main поток не смог дождаться завершения задачи");
        }
        System.out.println(result);

        List<Future<String>> results = null;
        try {
            results = singlPool.invokeAll(Arrays.asList(new RequestTask(), new RequestTask()));

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (Future<String> future : results) {
            try {
                String res = future.get(11000, TimeUnit.MICROSECONDS);
                System.out.println(res);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (TimeoutException e) {
                throw new RuntimeException(e);
            }

        }
        singlPool.shutdown();

        //Executor;
        //ExecutorService;
        //ThreadPoolExecutor | ForkJoinPool;
        //Executors
        int maxThreads = Runtime.getRuntime().availableProcessors();

        ExecutorService stealing = Executors.newWorkStealingPool();
        // ExecutorService stealing = Executors.newWorkStealingPool(3);

        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        //forkJoinPool.invoke();


        ScheduledExecutorService scheduledExecutorService01 =
                Executors.newScheduledThreadPool(2);
        scheduledExecutorService01.scheduleAtFixedRate(() -> {
                    //Runnable
                    System.out.println("Задача,которая"
                            + "должна выполнятся каждые 3 минуты");

                },
                0,
                3, TimeUnit.MINUTES);

        scheduledExecutorService01.scheduleWithFixedDelay(() -> {
                    //Runnable
                    System.out.println("Задача,которая"
                            + "должна выполнятся каждые 3 минуты" +
                            "после окончания предыдущей");

                },
                0,
                3, TimeUnit.MINUTES);

        scheduledExecutorService01.schedule(() -> {
                    //Runnable
                    System.out.println("Задача,которая выполнится через 5 минут");

                },

                3, TimeUnit.MINUTES);
        scheduledExecutorService01.shutdown();
    }
}


