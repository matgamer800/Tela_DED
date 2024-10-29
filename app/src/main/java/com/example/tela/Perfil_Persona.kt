package com.example.tela

import Data.data.AppDatabase
import Data.entity.Habilidade_entity
import Data.entity.Player_entity
import Data.model.Player_ViewModel
import Lib.Classes.Barbaro
import Lib.Player.Habilidade
import Lib.Player.Player
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Locale

class Perfil_Persona : AppCompatActivity() {
    private val playerViewModel: Player_ViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil_persona)


        val Nome = intent.getStringExtra("nome").toString()
        val raca = intent.getStringExtra("raca").toString()
        val classe = intent.getStringExtra("Classe").toString()

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

        val imgraca = findViewById<ImageView>(R.id.id_racaImagem)

        definirImagemPorRaca(raca,imgraca,this)

        nomePer.setText(Nome)
        racaPer.setText(raca)
        classePer.setText(classe)
        vidaPer.setText(vida.toString())
        forcaPer.setText(habilidade[0].toString())
        destrezaPer.setText(habilidade[1].toString())
        constituicaoPer.setText(habilidade[2].toString())
        inteligenciaPer.setText(habilidade[3].toString())
        sabedoriaPer.setText(habilidade[4].toString())
        carismaPer.setText(habilidade[5].toString())

        val forcaHabil = habilidade[0]
        val destrezahabil = habilidade[1]
        val contituicaohabil = habilidade[2]
        val inteligenciahabil = habilidade[3]
        val sabedoriahabil = habilidade[4]
        val carismahabil = habilidade[5]

        val nextPage = findViewById<Button>(R.id.Id_criar)

        nextPage.setOnClickListener{

            CoroutineScope(Dispatchers.IO).launch {
                val habilidadeid = playerViewModel.insertHabilidade(Habilidade_entity(forca = forcaHabil, destreza = destrezahabil, constituicao = contituicaohabil, inteligencia = inteligenciahabil, sabedoria = sabedoriahabil, carisma = carismahabil))
                Log.d("DatabaseDebug", "ID da Habilidade inserida: $habilidadeid")
                if(habilidadeid>=0){
                    playerViewModel.insertPlayer(Player_entity(nome_player = Nome, id_habil = habilidadeid))
                }
                else{
                    Log.e("DatabaseError", "Falha ao inserir habilidade")
                }
            }

            val intent = Intent(this,LoadPlayer::class.java)
            startActivity(intent)
        }


    }

    //Ver o que dá para fazer
    fun definirImagemPorRaca(raca: String, imageView: ImageView, activity: AppCompatActivity) {
        when (raca.toLowerCase(Locale.ROOT)) {
            "humano" -> imageView.setImageResource(
                activity.resources.getIdentifier(
                    "humano",
                    "drawable",
                    activity.packageName
                )
            )

            "elfo" -> imageView.setImageResource(
                activity.resources.getIdentifier(
                    "elfo",
                    "drawable",
                    activity.packageName
                )
            )

            else -> imageView.setImageResource(
                activity.resources.getIdentifier(
                    "padrao",
                    "drawable",
                    activity.packageName
                )
            ) // Caso seja uma raça não identificada, usar uma imagem padrão
        }
    }
}


