package Data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "habilidade_player")
data class Habilidade_entity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val forca: Int,
    val destreza: Int,
    val constituicao: Int,
    val inteligencia: Int,
    val sabedoria: Int,
    val carisma: Int
)
