package com.company.project.lesson10.staticmodifier;


public  final class GAuth implements Auth,Runnable{

    //public GAuth(String property) {
    //    super(property);
    //}

    @Override
    public boolean login(String username, String password) {
        return false;
    }

    @Override
    public boolean logout() {
        return false;
    }


    @Override
    public void run() {

    }
}

