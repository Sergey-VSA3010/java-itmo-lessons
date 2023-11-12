package com.company.project.lesson10.staticmodifier;
class FormAuth extends AppAuth{}
public /*final*/ /*sealed*/ non-sealed class AppAuth implements Auth{/*permits FormAth*/
    //
    Auth auth;
    @Override
    public boolean login(String username, String password) {

        return false;
    }

    @Override
    public boolean logout() {
        return false;
    }
}