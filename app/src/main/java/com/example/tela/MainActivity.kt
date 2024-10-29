package com.example.tela


import Data.model.Player_ViewModel
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var playerViewModel: Player_ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicialização correta do ViewModel
        playerViewModel = ViewModelProvider(this).get(Player_ViewModel::class.java)

        val buttonCriar = findViewById<Button>(R.id.id_criar1)
        buttonCriar.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                playerViewModel.initCallBack()
                val players = withContext(Dispatchers.IO) {
                    playerViewModel.Verific()
                }

                val intent: Intent = if (players != false) {
                    Intent(this@MainActivity, LoadPlayer::class.java)
                } else {
                    Intent(this@MainActivity, Criar_Per1::class.java)
                }
                startActivity(intent)
            }
        }
    }
}
