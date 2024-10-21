package Data.repository

import Data.dao.Habilidade_Dao
import Data.dao.Player_Dao
import Data.entity.Player_entity
import androidx.lifecycle.LiveData

class Player_Repository(private val playerDao: Player_Dao, private val habilidadeDao: Habilidade_Dao) {
    suspend fun createPlayer(player: Player_entity){
        playerDao.insertPlayer(player)
    }

    suspend fun updatePlayer(player: Player_entity){
        playerDao.updatePlayer(player)
    }

    suspend fun deletePlayer(player: Player_entity){
        playerDao.deletePlayer(player)
    }

    fun getAllPlayers(): LiveData<List<Player_entity>>{
        return playerDao.getAllPlayer()
    }

    suspend fun getPlayerByid(id:Long) : Player_entity?{
         return playerDao.getPlayerById(id)
    }
}