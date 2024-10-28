package Data.model

import Data.dao.PlayerWithHabilidade
import Data.data.AppDatabase
import Data.entity.Habilidade_entity
import Data.entity.Player_entity
import Lib.Player.Player
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class Player_ViewModel(application: Application): AndroidViewModel(application) {
    private val playerDao = AppDatabase.getDatabase(application).playerDao()
    private val habilidadeDao = AppDatabase.getDatabase(application).habilidadeDao()

    val playerWithHabilidade: LiveData<List<PlayerWithHabilidade>> = playerDao.getPlayerWithHabilidade()

    fun insertHabilidade(habilidadeEntity: Habilidade_entity):Long{
        var id: Long = 1

        viewModelScope.launch {

            habilidadeDao.insertHalidade(habilidadeEntity)
        }

        return id
    }

    fun insertPlayer(player: Player_entity) {
        viewModelScope.launch {
            var conts:Int = 0
            val lists = habilidadeDao.getAll()
                for (i in lists){
                    conts = i
                }
            val newplayer = player.copy(id_habil = conts.toLong())
            print(newplayer)
            playerDao.insertPlayer(newplayer)
        }
    }

    fun deletePlayer(player: Player_entity, habilidade: Habilidade_entity){
        viewModelScope.launch {
            playerDao.deletePlayer(player)
            habilidadeDao.deleteHabilidade(habilidade)
        }
    }

    suspend fun Verific() : Boolean{
        val player = playerDao.getAllPlayer()
        var target: Boolean
        print(player)
        if(player.size == 0){
            target = false
        }
        else{
            target = true
        }
        print(target)
        return target
    }

    fun updateName(id: Int, name: String){
        viewModelScope.launch {
            val player = playerDao.returPlayer(id)

            val playerUpdate = player.copy(nome_player = name)

            playerDao.updatePlayer(playerUpdate)
        }
    }

}