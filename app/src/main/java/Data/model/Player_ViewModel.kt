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
            val lists = habilidadeDao.getAll()

            for (i in lists){
                i
            }


            id = habilidadeDao.insertHalidade(habilidadeEntity)
        }
        return id
    }

    fun insertPlayer(player: Player_entity) {
        viewModelScope.launch {
            playerDao.insertPlayer(player)
        }
    }

}