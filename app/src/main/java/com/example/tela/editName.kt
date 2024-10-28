package com.example.tela

import Data.model.Player_ViewModel
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class editName : AppCompatActivity() {

    private val playerViewmodel: Player_ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_edit_name)

        val playerId = intent.getStringExtra("player_id")
        val id = playerId?.toIntOrNull() ?: -1 // Aqui, -1 é um valor padrão. Ajuste conforme necessário

        if (id == -1) {
            // Trate o caso em que o ID é inválido (ex: mostrando uma mensagem de erro, ou finalizando a activity)
            // Exemplo:
            Toast.makeText(this, "ID do jogador inválido", Toast.LENGTH_SHORT).show()
            finish()
            return
        }
        val editNametext = findViewById<EditText>(R.id.id_editName_player)

        val buttonEdit = findViewById<Button>(R.id.id_buttonEditName)


        buttonEdit.setOnClickListener{

            CoroutineScope(Dispatchers.IO).launch {
                playerViewmodel.updateName(id,editNametext.text.toString())
            }

            val intent = Intent(this,LoadPlayer::class.java)
            startActivity(intent)
        }

    }
}