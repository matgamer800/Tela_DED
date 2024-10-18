package Data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "classes")
data class Classes_entity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nome_classe:String
)
