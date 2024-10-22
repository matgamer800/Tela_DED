package Data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "habilidade")
data class Habilidade_entity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val forca: Int,
    val destreza: Int,
    val constituicao: Int,
    val inteligencia: Int,
    val sabedoria: Int,
    val carisma: Int
)
