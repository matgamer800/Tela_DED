package com.example.tela


import Lib.Classes.PreviewClasse
import Lib.Raca.PreviewRaca
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import android.widget.AdapterView
import android.widget.AdapterViewFlipper
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView



class Criar_Per1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_criar_per1)

        val butoNext = findViewById<Button>(R.id.id_criaPerso2)

        val spiner = findViewById<Spinner>(R.id.spinner_raca)

        val spinerClas = findViewById<Spinner>(R.id.id_pinner_classe)

        val textClas = findViewById<TextView>(R.id.id_info_classe)

        val Nome = findViewById<EditText>(R.id.id_NomePer)

        val atributos = findViewById<TextView>(R.id.atributos)

        spinerClas.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: android.view.View?, position: Int, id: Long) {
                val classe = parent.getItemAtPosition(position).toString()
                val previews = PreviewClasse()
                val InfoResult = previews.returnInfo(classe)
                textClas.text = InfoResult // Atualiza o TextView com os atributos
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                textClas.text = "Selecione uma Classe"
            }
        }

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
            val classe = spinerClas.selectedItem.toString()

            intet.putExtra("NomePer",nomes)
            intet.putExtra("RacaPer",raca)
            intet.putExtra("ClassePer",classe)

            startActivity(intet)

        }

    }

}