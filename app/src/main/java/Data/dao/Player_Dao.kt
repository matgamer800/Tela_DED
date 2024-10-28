package Data.dao

import Data.entity.Habilidade_entity
import Data.entity.Player_entity
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Embedded
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Relation
import androidx.room.Transaction
import androidx.room.Update

@Dao
interface Player_Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlayer(playerEntity: Player_entity): Long

    @Query("SELECT * FROM player")
    suspend fun getAllPlayer(): List<Player_entity>

    @Delete
    suspend fun deletePlayer(player: Player_entity)

    @Query("SELECT * FROM player WHERE id_player = :id")
    suspend fun returPlayer(id: Int): Player_entity

    @Update
    suspend fun updatePlayer(player: Player_entity)

    @Transaction
    @Query("SELECT * FROM player")
    fun getPlayerWithHabilidade(): LiveData<List<PlayerWithHabilidade>>
}
data class PlayerWithHabilidade(
    @Embedded val player:Player_entity,
    @Relation(
        parentColumn = "id_habil",
        entityColumn = "id"
    )
    val habilidade: Habilidade_entity
)