package com.example.tela

import Data.model.PlayerViewModelFactory
import Data.model.Player_ViewModel
import Lib.Raca.PreviewRaca
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels


class Criar_Per1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_criar_per1)

        val butoNext = findViewById<Button>(R.id.id_criaPerso2)

        val spiner = findViewById<Spinner>(R.id.spinner_raca)

        val Nome = findViewById<EditText>(R.id.id_NomePer)

        val atributos = findViewById<TextView>(R.id.atributos)

        spiner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: android.view.View?, position: Int, id: Long) {
                val raca = parent.getItemAtPosition(position).toString()
                val previews = PreviewRaca()
                val atributosResult = previews.returnAtributos(raca)
                atributos.text = atributosResult // Atualiza o TextView com os atributos
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                atributos.text = "Selecione uma raça"
            }
        }

        butoNext.setOnClickListener{
            //val selectedPosition = spiner.selectedItemPosition
            val intet = Intent(this,Criar_Per2::class.java)
            val raca = spiner.selectedItem.toString()
            val nomes = Nome.text.toString()

            intet.putExtra("NomePer",nomes)
            intet.putExtra("RacaPer",raca)

            startActivity(intet)

        }

    }

}