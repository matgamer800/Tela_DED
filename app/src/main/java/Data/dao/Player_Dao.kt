package Data.dao

import Data.entity.Habilidade_entity
import Data.entity.Player_entity
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface Player_Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlayer(playerEntity: Player_entity)

    @Update
    suspend fun updatePlayer(playerEntity: Player_entity)

    @Delete
    suspend fun deletePlayer(playerEntity: Player_entity)

    @Query("SELECT * FROM player")
    fun getAllPlayer(): LiveData<List<Player_entity>>

    @Query("SELECT * FROM player WHERE id_player = :id")
    suspend fun getPlayerById(id:Long): Player_entity?
}