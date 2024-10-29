package Data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "racas")
data class Raca_entity(
    @PrimaryKey(autoGenerate = true) val id_raca: Int = 0,
    val Nome_raca: String
)
