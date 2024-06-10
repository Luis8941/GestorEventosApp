package com.example.proyectoinnovacion

import retrofit2.Call
import retrofit2.http.GET

interface EventoAPI {
    @GET("eventos_api")
    fun obtenerEventos(): Call<EventoResponse>
}