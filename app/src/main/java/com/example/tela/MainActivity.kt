package com.example.tela

import Data.model.Player_ViewModel
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private val playerViewModel: Player_ViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ButonCriar = findViewById<Button>(R.id.id_criar1)

        ButonCriar.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                val players = withContext(Dispatchers.IO) {
                    playerViewModel.Verific()
                }
                print(players)
                val intent: Intent = if (players) {
                    Intent(this@MainActivity, LoadPlayer::class.java)
                } else {
                    Intent(this@MainActivity, Criar_Per1::class.java)
                }

                startActivity(intent)
            }
        }
    }
}
