package com.example.alphago

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.alphago.R

class PerfilActivity : AppCompatActivity() {

    private lateinit var ivFotoPerfil: ImageView
    private lateinit var btnCambiarFoto: Button
    private lateinit var etNombrePerfil: EditText
    private lateinit var etCorreoPerfil: EditText
    private lateinit var etTelefonoPerfil: EditText
    private lateinit var btnGuardarPerfil: Button

    private val REQUEST_IMAGE_CAPTURE = 1  // Código para la cámara

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        ivFotoPerfil = findViewById(R.id.iv_foto_perfil)
        btnCambiarFoto = findViewById(R.id.btnCambiarFoto)
        etNombrePerfil = findViewById(R.id.etNombrePerfil)
        etCorreoPerfil = findViewById(R.id.etCorreoPerfil)
        etTelefonoPerfil = findViewById(R.id.etTelefonoPerfil)
        btnGuardarPerfil = findViewById(R.id.btnGuardarPerfil)

        btnCambiarFoto.setOnClickListener {
            abrirCamara()
        }

        btnGuardarPerfil.setOnClickListener {
            guardarDatosPerfil()
        }
    }

    private fun abrirCamara() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (intent.resolveActivity(packageManager) != null) {
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE)
        } else {
            Toast.makeText(this, "No se pudo abrir la cámara", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            ivFotoPerfil.setImageBitmap(imageBitmap)
        }
    }

    private fun guardarDatosPerfil() {
        val nombre = etNombrePerfil.text.toString().trim()
        val correo = etCorreoPerfil.text.toString().trim()
        val telefono = etTelefonoPerfil.text.toString().trim()

        if (nombre.isEmpty() || correo.isEmpty() || telefono.isEmpty()) {
            Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Perfil actualizado correctamente", Toast.LENGTH_SHORT).show()
            // Aquí puedes almacenar los datos en SharedPreferences o en una BD
        }
    }
}
