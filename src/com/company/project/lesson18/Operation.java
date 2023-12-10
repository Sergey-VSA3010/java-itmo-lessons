package com.company.project.lesson18;

@FunctionalInterface
public interface Operation {
    double action(double a, double b);

    default Operation addOperation(Operation other){
        //double action(double a,double b);
        return (a,b)-> action(a,b) + other.action(a,b);
    }
}
