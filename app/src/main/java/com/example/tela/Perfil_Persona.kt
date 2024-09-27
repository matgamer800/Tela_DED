package com.example.tela

import Lib.Classes.Barbaro
import Lib.Player.Habilidade
import Lib.Player.Player
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView

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

        val nomePer = findViewById<TextView>(R.id.id_nome_personagem)
        val racaPer = findViewById<TextView>(R.id.id_raca_personagem)
        val classePer = findViewById<TextView>(R.id.id_classe_personagem)

        val vidaPer = findViewById<TextView>(R.id.id_vida_personagem)

        val forcaPer = findViewById<TextView>(R.id.id_forca_personagem)
        val destrezaPer = findViewById<TextView>(R.id.id_destreza_personagem)
        val constituicaoPer = findViewById<TextView>(R.id.id_contituicao_personagem)
        val inteligenciaPer = findViewById<TextView>(R.id.id_inteligencia_personagem)
        val sabedoriaPer = findViewById<TextView>(R.id.id_sabedoria_personagem)
        val carismaPer = findViewById<TextView>(R.id.id_carisma_personagem)

        val habilidade = Player.returnHabil()
        val vida = Player.returnVida()


        nomePer.setText(Nome)
        racaPer.setText(raca)
        classePer.setText("Barbaro")
        vidaPer.setText(vida.toString())
        forcaPer.setText(habilidade[0].toString())
        destrezaPer.setText(habilidade[1].toString())
        constituicaoPer.setText(habilidade[2].toString())
        inteligenciaPer.setText(habilidade[3].toString())
        sabedoriaPer.setText(habilidade[4].toString())
        carismaPer.setText(habilidade[5].toString())









    }

}