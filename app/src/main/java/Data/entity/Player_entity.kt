package Data.entity

import Lib.Classes.Classes
import Lib.Raca.Racas
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
            entity =Classes_entity::class,
            parentColumns = ["id"],
            childColumns = ["id_classe"],
            onDelete = ForeignKey.CASCADE
        )
        ])
data class Player_entity(
    @PrimaryKey(autoGenerate = true)
    val id_player : Int = 0,
    val nome_player: String,

    val id_habil: Int, // Relacionado a Tabela de habilidade

    val id_classe: Int, //Relacionado a Tabela de Classes




)
