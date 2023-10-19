package com.company.project.lesson09;
//
public class Point {
    private final int x =0;
    private final int y;

    public Point(int y){
        this.y = y;
    }


    public /* final*/ void printInfo(){
        System.out.println(x);
        System.out.println(y);

    }
}
