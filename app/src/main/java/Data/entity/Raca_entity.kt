package Data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "raca")
data class Raca_entity(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,

    val nome_raca:String
)
