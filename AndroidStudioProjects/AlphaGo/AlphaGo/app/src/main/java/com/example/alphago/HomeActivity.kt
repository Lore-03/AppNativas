package com.example.alphago

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.alphago.PerfilActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var buttonComienza: Button

    override fun onCreate(savedInstanceState: Bundle?) { // Corregido el nombre del parámetro
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Verifica que el ID sea el correcto
        buttonComienza = findViewById(R.id.tv_registrate)

        buttonComienza.setOnClickListener {
            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()

            // Corregido: ahora abre PerfilActivity en lugar de HomeActivity
            val intent = Intent(this, PerfilActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
