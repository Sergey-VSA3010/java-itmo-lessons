package com.company.project.lesson10.staticmodifier;

public sealed interface Auth permits GAuth,AppAuth{// допуступные разрешения
    boolean login(String username, String password);
    boolean logout();

    static Auth getAuth(String authType) {
        Auth auth;
        if (authType.equals("github")) {
            auth = new GAuth();
        } else {
            auth = new AppAuth();
        }
        return auth;
    }
}