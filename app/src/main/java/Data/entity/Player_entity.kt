package Data.entity


import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "player",
        foreignKeys = [ForeignKey(
            entity = Habilidade_entity::class,
            parentColumns = ["id"],
            childColumns = ["id_habil"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Raca_entity::class,
            parentColumns = ["id_raca"],
            childColumns = ["id_raca"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Classe_entity::class,
            parentColumns = ["id_classe"],
            childColumns = ["id_classe"],
            onDelete = ForeignKey.CASCADE
        )])
data class Player_entity(
    @PrimaryKey(autoGenerate = true) val id_player : Int = 0,
    val nome_player: String,
    val id_habil: Long, // Relacionado a Tabela de habilidade
    val id_raca:Int,
    val id_classe:Int
)
