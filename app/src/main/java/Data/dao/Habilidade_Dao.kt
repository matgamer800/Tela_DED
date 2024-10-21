package Data.dao

import Data.entity.Habilidade_entity
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface Habilidade_Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHalidade(habilidadeEntity: Habilidade_entity): Long

    @Update
    suspend fun updateHabilidade(habilidadeEntity: Habilidade_entity)

    @Query("SELECT * FROM habilidade_player WHERE id = :id")
    suspend fun getHabilidadeById(id:Long): Habilidade_entity?
}