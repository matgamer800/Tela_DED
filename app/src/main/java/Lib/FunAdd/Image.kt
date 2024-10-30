package Lib.FunAdd

import com.example.tela.R

class Image {
    fun getImageResource(characterType: String): Int {
        return when (characterType) {
            "Humano" -> R.drawable.humano
            else -> R.drawable.esboco
        }
    }
}

