package com.example.tela

import Lib.Classes.Barbaro
import Lib.Player.Habilidade
import Lib.Player.Player
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

class Perfil_Persona : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil_persona)

        val Nome = intent.getStringExtra("nome").toString()
        val raca = intent.getStringExtra("raca").toString()

        //Habiblidade

        val forca = intent.getIntExtra("forca",0)

        val destrezas = intent.getIntExtra("destreza",0)

        val constituicao = intent.getIntExtra("constituicao",0)
        val inteligencia = intent.getIntExtra("inteligencia",0)
        val sabedoria = intent.getIntExtra("sabedoria",0)
        val carisma = intent.getIntExtra("carisma",0)

        val habil = Habilidade(forca,destrezas,constituicao,inteligencia,sabedoria,carisma)

        val Player = Player(Nome,habil,raca,Barbaro())



    }

}