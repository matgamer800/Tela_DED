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

    @Query("SELECT * FROM habilidade WHERE id = :id")
    suspend fun getHabilidadeById(id:Int): Habilidade_entity?

    @Query("SELECT id FROM habilidade")
    suspend fun getAll(): List<Int>
}