package com.raphadrummond.myapplication;

public class U {

    public static final String BASE_URL = "http://sportsmatch.com.br/teste/teste.json";

    public static String checkNull(String value) {
        if (value.equals("null"))
            return"";
        else return value;



    }
}
