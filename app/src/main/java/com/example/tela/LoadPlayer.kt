package com.example.tela


import Data.model.Player_ViewModel
import PlayerAdapter
import android.os.Bundle
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

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = PlayerAdapter()
        recyclerView.adapter = adapter

        playerViewModel.playerWithHabilidade.observe(this, Observer { players ->
            players?.let {
                adapter.submitList(it)
            }
        })

    }
}