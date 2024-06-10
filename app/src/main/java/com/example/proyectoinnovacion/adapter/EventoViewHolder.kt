package com.example.proyectoinnovacion.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.proyectoinnovacion.Evento
import com.example.proyectoinnovacion.R

class EventoViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val  nombre = view.findViewById<TextView>(R.id.nombre)
    val  fecha_evento = view.findViewById<TextView>(R.id.fecha_evento)
    val  img_evento = view.findViewById<ImageView>(R.id.img_evento)

    fun render(evento: Evento) {
        nombre.text = evento.nombre
        fecha_evento.text = evento.fecha_evento
        Glide.with(img_evento.context).load(evento.img_evento).into(img_evento)
    }
}