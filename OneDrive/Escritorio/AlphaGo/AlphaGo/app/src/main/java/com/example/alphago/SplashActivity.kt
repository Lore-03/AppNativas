package com.example.alphago

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Log.d("SplashActivity", "onCreate: Iniciando Activity")

        // Configurar el temporizador de redirección a HomeActivity
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_TIME_OUT)
    }

    override fun onStart() {
        super.onStart()
        Log.d("SplashAvtivity", "onStart: Activity Splash esta en primer plano")
    }

    override fun onPause() {
        super.onPause()
        Log.d("SplashAvtivity", "onStart: Activity Splash esta en pausa")
    }

    override fun onStop() {
        super.onStop()
        Log.d("SplashAvtivity", "onStart: Activity Splash esta en pausa")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("SplashAvtivity", "onStart: Activity Splash esta  en destruido")
    }


}
