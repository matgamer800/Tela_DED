package com.example.tela

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ButonCriar = findViewById<Button>(R.id.id_criar1)

        ButonCriar.setOnClickListener{
            val intent = Intent(this,Criar_Per1::class.java)
            startActivity(intent)
        }
    }
}
