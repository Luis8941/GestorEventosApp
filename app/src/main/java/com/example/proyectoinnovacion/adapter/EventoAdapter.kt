package com.example.proyectoinnovacion.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.proyectoinnovacion.Evento
import com.example.proyectoinnovacion.R

class EventoAdapter(private val eventoList: List<Evento>):RecyclerView.Adapter<EventoViewHolder>(){

    private var onItemClick : OnClickListener ? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_element_event, parent, false)
        return EventoViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventoViewHolder, position: Int) {
        val ItemViewModel = eventoList[position]
        holder.render(ItemViewModel)
    }

    override fun getItemCount(): Int {
        return eventoList.size
    }

    /*class ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView) {
        val txtNombre : TextView = ItemView.findViewById(R.id.nombre)
        val txtFechaEvento : TextView = ItemView.findViewById(R.id.fecha_evento)
        val txtImgEvento : TextView = ItemView.findViewById(R.id.img_evento)
    }*/

    fun setOnItemClickListener(listener: OnClickListener){
        onItemClick = listener
    }

    interface  OnItemClickListener{
        fun onItemClick(evento: Evento)
    }
}