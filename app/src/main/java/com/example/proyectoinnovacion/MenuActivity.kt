package com.example.proyectoinnovacion

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth

enum class ProviderType{
    BASIC
}

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnVerEvento = findViewById<Button>(R.id.btn_ver_evento)
        btnVerEvento.setOnClickListener{
            goToViewEvent()
        }
        goToLogin()
    }

    private fun goToViewEvent(){
        val i = Intent(this, ListEventoActivity::class.java)
        startActivity(i)
    }

    private fun goToLogin(){
        /*val i = Intent(this, MainActivity::class.java)
        startActivity(i)
        finish()*/
        title = "Inicio"
        val btnLogout = findViewById<Button>(R.id.btn_logout)
        btnLogout.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            finish()
        }
    }
}