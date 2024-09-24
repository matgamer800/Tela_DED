package com.example.tela

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast


class Criar_Per1 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_criar_per1)

        val butoNext = findViewById<Button>(R.id.id_criaPerso2)

        val spiner = findViewById<Spinner>(R.id.spinner_raca)

        val Nome = findViewById<EditText>(R.id.id_NomePer).text.toString()


        butoNext.setOnClickListener{
            //val selectedPosition = spiner.selectedItemPosition
            val intet = Intent(this,Criar_Per2::class.java)
            val raca = spiner.selectedItem.toString()

            intet.putExtra("NomePer",Nome)
            intet.putExtra("RacaPer",raca)

            startActivity(intet)

        }

    }

}