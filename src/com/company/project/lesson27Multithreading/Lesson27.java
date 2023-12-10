package com.company.project.lesson27Multithreading;

import java.util.ArrayList;
import java.util.List;

public class Lesson27 {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        stringList.add("4");// первый поток


        ThreadTask threadTask01 = new ThreadTask(stringList);// второй
        threadTask01.setName("ThreadTask 01");// установка имени( для отладки)
        threadTask01.setPriority(10);// устанавливает приоритет запуска потока.
        threadTask01.printList();

        ThreadTask threadTask02 = new ThreadTask(stringList);// третий
        threadTask02.setName("ThreadTask 02");// установка имени( для отладки)


        threadTask01.run();// не будет выполняться (не нужно)
        // Если вызвать в коде,
        // инструкции не будут выполняться в отдельном потоке.
        threadTask02.run();

        threadTask01.start();
        threadTask02.start();


        RunnableTask runnableTask = new RunnableTask("task");
        Thread threadWithRunnable = new Thread(runnableTask);
        System.out.println(threadWithRunnable.getState());
        threadWithRunnable.start();

        Thread threadWithLambda = new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName());
            }
        });

        // фоновый поток
        threadWithLambda.setName("Daemon");
        threadWithLambda.setDaemon(true);
        //threadWithLambda.start();

        List<Double> doubles = new ArrayList<>();

        Thread addToDoubles = new Thread(() -> {
            //while (true){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            doubles.add(Math.random());

        });
        addToDoubles.setName("addToDoubles");
        addToDoubles.start();// в очереди у планировщика (может и не заработать)
        try {
            addToDoubles.join(1000); // main поток -ждёт пока addToDoubles завершит свою работу
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(doubles);

        System.out.println("main");
        //Thread  interrupt - false
        //           .isInterrupted()-> false
        //           .interrupt() -> interrupted -> true
        //           .isInterrupted()-> true

        Thread thread = new Thread(()->{
            while (!Thread.currentThread().isInterrupted()){
                // инструкции потока
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){//interrupted -> false
                    Thread.currentThread().interrupt();//interrupted -> true
                }
            }
        });
        thread.start();
        thread.interrupt();//interrupted -> true
    }
}
