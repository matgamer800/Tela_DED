package ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import Data.entity.Habilidade_entity
import Data.repository.Habilidade_Repesitory
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.launch

class Habilidade_ViewModel(private val habilidadeRepository: Habilidade_Repesitory) : ViewModel() {

    private val _habilidadeId = MutableLiveData<Long>()
    val habilidadeId: LiveData<Long> get() = _habilidadeId

    fun insertHabilidade(habilidade: Habilidade_entity) {
        viewModelScope.launch {
            habilidadeRepository.insertHabilidade(habilidade)
        }
    }
}
class HabilidadeViewModelFactory(private val repository: Habilidade_Repesitory) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(Habilidade_ViewModel::class.java)) {
            return Habilidade_ViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
