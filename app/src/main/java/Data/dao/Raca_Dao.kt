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

    @Query("SELECT id_raca FROM racas WHERE nome_raca = :raca")
    suspend fun atribuiRaca(raca:String): Int

    @Query("SELECT nome_raca FROM racas  WHERE id_raca = :id")
    suspend fun returnNameRaca(id:Int): String
}