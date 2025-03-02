package com.example.alphago

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.miapp.RecuperarActivity
import com.example.miapp.RegistroActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(saveInstanceState: Bundle?) {
        super.onCreate(saveInstanceState)
        setContentView(R.layout.activity_login)

        // Ir a Registro
        tv_login_registrate.setOnClickListener {
            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }

// Ir a Recuperar Contraseña
        tv_contrasena.setOnClickListener {
            val intent = Intent(this, RecuperarActivity::class.java)
            startActivity(intent)
        }

// Ir al Home si el login es correcto
        btnLogin.setOnClickListener {
            if (validarCredenciales()) {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish() // Cierra Login para que no vuelva atrás
            } else {
               Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
            }
        }

    }
}