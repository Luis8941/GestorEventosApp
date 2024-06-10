package com.example.proyectoinnovacion

import com.google.gson.annotations.SerializedName

data class Evento(@SerializedName("id_evento")
                  val id_evento: Int,
                  @SerializedName("nombre")
                  val nombre: String,
                  @SerializedName("descripcion")
                  val descripcion: String,
                  @SerializedName("fecha_evento")
                  val fecha_evento: String,
                  @SerializedName("img_evento")
                  val img_evento: String
)
