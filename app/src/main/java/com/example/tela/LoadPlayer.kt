package com.example.tela


import Data.model.Player_ViewModel
import PlayerAdapter
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class LoadPlayer : AppCompatActivity() {
    private val playerViewModel: Player_ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_load_player)

        val newPlay_button = findViewById<Button>(R.id.id_newPlayer)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = PlayerAdapter(
            onEditClick = { playerWithHabilidade ->
                // Código para abrir a activity de edição
                //val intent = Intent(this, EditarNomeActivity::class.java)
                intent.putExtra("player_id", playerWithHabilidade.player.id_player)
                startActivity(intent)
            },
            onDeleteClick = { playerWithHabilidade ->
                // Código para deletar o player usando o ViewModel
                playerViewModel.deletePlayer(playerWithHabilidade.player,playerWithHabilidade.habilidade)
            },
            onRunClick = { playerWithHabilidade ->
                // Código para ir para a próxima activity
                //val intent = Intent(this, NextActivity::class.java)
                intent.putExtra("player_id", playerWithHabilidade.player.id_player)
                startActivity(intent)
            }
        )
        recyclerView.adapter = adapter

        playerViewModel.playerWithHabilidade.observe(this, Observer { players ->
            players?.let {
                adapter.submitList(it)
            }
        })

        newPlay_button.setOnClickListener{
            val intent = Intent(this,Criar_Per1::class.java)
            startActivity(intent)
        }



    }
}