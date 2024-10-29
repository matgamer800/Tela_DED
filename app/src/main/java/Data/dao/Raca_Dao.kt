package Data.dao

import Data.entity.Raca_entity
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface Raca_Dao {
    @Insert
    suspend fun inserirRacas(vararg racas: Raca_entity)

    @Query("SELECT id_raca FROM racas")
    suspend fun returnId(): List<Int>
}