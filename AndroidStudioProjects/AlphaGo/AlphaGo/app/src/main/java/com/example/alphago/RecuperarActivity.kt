package com.example.alphago

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.alphago.LoginActivity
import com.example.alphago.R

class RecuperarActivity : AppCompatActivity() {

    private lateinit var etCorreoRecuperar: EditText
    private lateinit var btnEnviarCorreo: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recuperar_c)

        etCorreoRecuperar = findViewById(R.id.etCorreoRecuperar)
        btnEnviarCorreo = findViewById(R.id.btnEnviarCorreo)

        btnEnviarCorreo.setOnClickListener {
            val correo = etCorreoRecuperar.text.toString().trim()

            if (validarCorreo(correo)) {
                enviarCorreoRecuperacion(correo)
            } else {
                Toast.makeText(this, "Ingrese un correo válido", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validarCorreo(correo: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(correo).matches()
    }

    private fun enviarCorreoRecuperacion(correo: String) {
        // Aquí se podría integrar Firebase Auth o una API para enviar el correo
        Toast.makeText(this, "Se ha enviado un enlace de recuperación a $correo", Toast.LENGTH_LONG).show()

        btnEnviarCorreo.setOnClickListener {
            Toast.makeText(this, "Correo de recuperación enviado", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}
