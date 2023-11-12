package com.company.project.lesson12.record;

import java.time.LocalDateTime;

public class lesson12Record {
    public static void main(String[] args) {
        Review review = new Review(1, "234567", LocalDateTime.now());
        Review review1 = new Review(2,"123456",LocalDateTime.now());
    }
}
