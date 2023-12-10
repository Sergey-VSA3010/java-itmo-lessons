package com.company.project.lesson22;

public class Walk implements IAction<Unit>{

    @Override
    public void execute(Unit unit){
        System.out.println("unit Walk");
    }
}
