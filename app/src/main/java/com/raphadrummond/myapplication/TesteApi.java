package com.raphadrummond.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TesteApi {

    @GET("teste.json")
    Call<List<MainActivity>> getTeste();

}
