package Data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "classes")
data class Classe_entity(
    @PrimaryKey(autoGenerate = true) val id_classe: Int = 0,
    val Nome_classe:String
)
