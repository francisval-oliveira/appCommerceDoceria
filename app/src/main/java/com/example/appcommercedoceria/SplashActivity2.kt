package com.example.appcommercedoceria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

@Suppress("DEPRECATION")
class SplashActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash2)

        val intent: Intent = Intent(this, MainActivity::class.java)


        Handler() .postDelayed(Runnable {

            startActivity(intent)
            finish()




        }, 3000)



    }
}

