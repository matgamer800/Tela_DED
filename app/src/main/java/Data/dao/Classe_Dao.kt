package Data.dao

import Data.entity.Classe_entity
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface Classe_Dao {
    @Insert
    suspend fun insertClasse(vararg classe:Classe_entity)

    @Query("SELECT id_classe FROM classes")
    suspend fun returnIdClasses(): List<Int>

    @Query("SELECT id_classe FROM classes WHERE nome_classe = :classe")
    suspend fun atribuirClasse(classe:String): Int

    @Query("SELECT nome_classe FROM classes WHERE id_classe = :id")
    suspend fun returnNameClasse(id:Int): String
}