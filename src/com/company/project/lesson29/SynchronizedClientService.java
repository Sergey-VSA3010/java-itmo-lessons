package com.company.project.lesson29;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedClientService extends Thread {
    private final List<String> tokens;

    //аналог Synchronized
    private ReentrantLock reentrantLock;
    // разрешение на доступ к ресурсу(любому)
    private Semaphore semaphore;

    public SynchronizedClientService(List<String> tokens,
                                     ReentrantLock reentrantLock,
                                     Semaphore semaphore) {
        this.tokens = tokens;
        this.reentrantLock = reentrantLock;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        String token;
        try {
            semaphore.acquire(2);// запрос разрешения
            reentrantLock.lock();// блокируется
            token = tokens.remove(0);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            reentrantLock.unlock();
        }
        String newToken = makeRequest(token);
        synchronized (tokens){
            tokens.add(newToken);
        }
        semaphore.release(2);

    }

    private String makeRequest(String token) {
        try {
            System.out.println(Thread.currentThread().getName() +
                    " connected with token " + token);
            Thread.sleep(100);
            return UUID.randomUUID().toString();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}