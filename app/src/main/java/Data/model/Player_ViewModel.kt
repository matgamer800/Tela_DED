package Data.model

import Data.entity.Player_entity
import Data.repository.Player_Repository
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class Player_ViewModel(private val repository: Player_Repository) : ViewModel() {

    private val _players: LiveData<List<Player_entity>> = repository.getAllPlayers()

    val players: LiveData<List<Player_entity>> get() = _players

    fun create(playerEntity: Player_entity) = viewModelScope.launch {
        repository.createPlayer(playerEntity)
    }
    fun update(playerEntity: Player_entity) = viewModelScope.launch {
        repository.updatePlayer(playerEntity)
    }
    fun getplayer(id:Long) = viewModelScope.launch {
        repository.getPlayerByid(id)
    }

}

class PlayerViewModelFactory(private val repository: Player_Repository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(Player_ViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return Player_ViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
