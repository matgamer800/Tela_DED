package Data.data

import Data.dao.Raca_Dao
import Data.entity.Raca_entity

class CallBacksPopulation{
    suspend fun popalatioRaca_Database(Raca:Raca_Dao){

        val Racas_init = listOf(
            Raca_entity(id_raca = 1, Nome_raca = "Anão"),
            Raca_entity(id_raca = 2,Nome_raca = "Anão da Colina"),
            Raca_entity(id_raca = 3,Nome_raca = "Anão da Montanha"),
            Raca_entity(id_raca = 4,Nome_raca = "Elfo"),
            Raca_entity(id_raca = 5,Nome_raca = "Alto Elfo"),
            Raca_entity(id_raca = 6,Nome_raca = "Elfo da Floresta"),
            Raca_entity(id_raca = 7,Nome_raca = "Elfo Negro (Drow)"),
            Raca_entity(id_raca = 8,Nome_raca = "Meio-Elfo"),
            Raca_entity(id_raca = 9,Nome_raca = "Halfling"),
            Raca_entity(id_raca = 10,Nome_raca = "Halfling dos Pés Leves"),
            Raca_entity(id_raca = 11,Nome_raca = "Halfling Robusto"),
            Raca_entity(id_raca = 12,Nome_raca = "Humano"),
            Raca_entity(id_raca = 13,Nome_raca = "Draconato"),
            Raca_entity(id_raca = 14,Nome_raca = "Gnomo"),
            Raca_entity(id_raca = 15,Nome_raca = "Gnomo da Floresta"),
            Raca_entity(id_raca = 16,Nome_raca = "Gnomo das Rochas"),
            Raca_entity(id_raca = 17,Nome_raca = "Meio-Orc"),
            Raca_entity(id_raca = 18,Nome_raca = "Tieflings")
        )
        Racas_init.forEach { Raca.inserirRacas(it)}
    }
}


