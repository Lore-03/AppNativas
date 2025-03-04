package com.example.alphago

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.alphago.PerfilActivity
import com.example.alphago.RecuperarActivity
import com.example.alphago.RegistroActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var button_ingresar: Button
    private lateinit var tv_contrasena: TextView
    private lateinit var tv_login_registrate: TextView

    override fun onCreate(saveInstanceState: Bundle?) {
        super.onCreate(saveInstanceState)
        setContentView(R.layout.activity_login)

        button_ingresar=findViewById(R.id.button_ingresar)
        tv_contrasena=findViewById(R.id.tv_contrasena)
        tv_login_registrate=findViewById(R.id.tv_login_registrate)

        fun validarCredenciales(): Boolean {
            val email = findViewById<TextView>(R.id.etuser_login).text.toString().trim()
            val password = findViewById<TextView>(R.id.etuser_contrasena).text.toString().trim()

            // Simulación de credenciales correctas
            val emailCorrecto = "usuario@example.com"
            val passwordCorrecta = "123456"

            return if (email == emailCorrecto && password == passwordCorrecta) {
                true // Credenciales correctas
            } else {
                false // Credenciales incorrectas
            }
        }

        // Ir al Home si el login es correcto
       button_ingresar.setOnClickListener {
            if (validarCredenciales()) {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish() // Cierra Login para que no vuelva atrás
            } else {
                Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
            }
        }
        // Ir a Activity recuperar contraseña
        tv_contrasena.setOnClickListener {
            val intent = Intent(this, RecuperarActivity::class.java)
            startActivity(intent)
        }

        // Ir a Activity Registrar
        tv_login_registrate.setOnClickListener {
            val intent = Intent(this, RecuperarActivity::class.java)
            startActivity(intent)
        }


    }
}