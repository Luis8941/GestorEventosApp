package com.example.proyectoinnovacion

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectoinnovacion.adapter.EventoAdapter
import com.example.proyectoinnovacion.databinding.ActivityListEventoBinding

import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ListEventoActivity : AppCompatActivity() {

    var binding : ActivityListEventoBinding?=null

    private  lateinit var  recycleView : RecyclerView
    private lateinit var adapter: EventoAdapter
    private lateinit var api: EventoAPI
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityListEventoBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        recycleView = findViewById(R.id.listRecyclerEvento)
        recycleView.layoutManager = LinearLayoutManager(this)

        val retrofit = Retrofit.Builder().baseUrl("http://10.0.2.2/").addConverterFactory(
            GsonConverterFactory.create(
                GsonBuilder().create())).build()

        api = retrofit.create(EventoAPI::class.java)

        cargarDatos(api)
    }
    private fun cargarDatos(api: EventoAPI) {
        val call = api.obtenerEventos()
        call.enqueue(object : Callback<EventoResponse> {
            override fun onResponse(
                call: Call<EventoResponse>,
                response: Response<EventoResponse>
            ) {
                if(response.isSuccessful){
                    val eventos = response.body()?.rows
                    adapter = eventos?.let { EventoAdapter(it)} !!
                    recycleView.adapter = adapter
                }
            }

            override fun onFailure(call: Call<EventoResponse>, t: Throwable) {
                Log.e("Error_API", "Error al obtener los eventos: ${t.message}")
                Toast.makeText(this@ListEventoActivity, "Error al obtener los estudiantes", Toast.LENGTH_LONG).show()
            }

        })
    }
}