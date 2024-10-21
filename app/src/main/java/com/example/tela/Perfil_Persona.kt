package com.example.tela

import Data.data.AppDatabase
import Data.entity.Habilidade_entity
import Data.entity.Player_entity
import Data.model.PlayerViewModelFactory
import Data.model.Player_ViewModel
import Data.repository.Habilidade_Repesitory
import Lib.Classes.Barbaro
import Lib.Player.Habilidade
import Lib.Player.Player
import ViewModel.HabilidadeViewModelFactory
import ViewModel.Habilidade_ViewModel
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class Perfil_Persona : AppCompatActivity() {
    private lateinit var player_ViewModel:Player_ViewModel
    private lateinit var habilidadeViewModel:Habilidade_ViewModel


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

        val imgraca = findViewById<ImageView>(R.id.id_racaImagem)

        definirImagemPorRaca(raca,imgraca,this)

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

        val nextPage = findViewById<Button>(R.id.Id_criar)

        nextPage.setOnClickListener{

            habilidadeViewModel.habilidadeId.observe(this, Observer { id ->
                if (id != null) {
                    val player = Player_entity(nome_player = Nome, id_habil = id)

                    // Insere o Player usando o PlayerViewModel
                    player_ViewModel.create(player)
                }
            })

            // Exemplo de como criar e inserir uma nova habilidade
            val habilidade = Habilidade_entity(forca = forca, destreza = destrezas, constituicao = constituicao, inteligencia = inteligencia, sabedoria = sabedoria, carisma = carisma)

            // Insere a habilidade e aguarda o retorno do ID
            habilidadeViewModel.insertHabilidade(habilidade)
        }

            //val habilidade = Habilidade_entity(forca = forca, destreza = destrezas, constituicao = constituicao, inteligencia = inteligencia, sabedoria = sabedoria, carisma = carisma)
            //val player = Player_entity(nome_player = Nome, id_habil = 0)

            //player_ViewModel.create(player)
            //Quando criar o personagem
            val intent = Intent(this,LoadPlayer::class.java)
            startActivity(intent)
        }


    }

    //Ver o que dá para fazer
    fun definirImagemPorRaca(raca: String, imageView: ImageView, activity: AppCompatActivity) {
        when (raca.toLowerCase()) {
            "humano" -> imageView.setImageResource(activity.resources.getIdentifier("humano", "drawable", activity.packageName))
            "elfo" -> imageView.setImageResource(activity.resources.getIdentifier("elfo", "drawable", activity.packageName))
            else -> imageView.setImageResource(activity.resources.getIdentifier("padrao", "drawable", activity.packageName)) // Caso seja uma raça não identificada, usar uma imagem padrão
        }
    }


