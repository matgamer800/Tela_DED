package Data.repository

import Data.dao.Habilidade_Dao
import Data.entity.Habilidade_entity

class Habilidade_Repesitory(private val habilidadeDao: Habilidade_Dao) {
    suspend fun insertHabilidade(habilidadeRepesitory: Habilidade_entity){
        habilidadeDao.insertHalidade(habilidadeRepesitory)
    }
    suspend fun updateHabilidade(habilidadeRepesitory: Habilidade_entity){
        habilidadeDao.updateHabilidade(habilidadeRepesitory)
    }

    suspend fun getHabilidade(id:Int){
        habilidadeDao.getHabilidadeById(id)
    }
}