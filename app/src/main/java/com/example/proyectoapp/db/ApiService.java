package com.example.proyectoapp.db;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Field;
import retrofit2.http.POST;

public interface ApiService {
    @FormUrlEncoded
    @POST("registrar.php")
    Call<Void> registerUser(
            @Field("nombre") String nombre,
            @Field("apellido") String apellido,
            @Field("email") String email,
            @Field("contraseña") String contraseña
    );
}