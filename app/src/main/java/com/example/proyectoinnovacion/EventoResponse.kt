package com.example.proyectoinnovacion

import com.google.gson.annotations.SerializedName

data class EventoResponse(@SerializedName("rows")
                          val rows: List<Evento>,
                          @SerializedName("mensaje")
                          val mensaje : String,
                          @SerializedName("estado")
                          val estado : Int
)
