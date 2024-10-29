package Lib.Classes

import Lib.Raca.Alto_Elfo
import Lib.Raca.Anao
import Lib.Raca.Anao_Colina
import Lib.Raca.Anao_Montanha
import Lib.Raca.Draconato
import Lib.Raca.Drow
import Lib.Raca.Elfo
import Lib.Raca.Elfo_Floresta
import Lib.Raca.Gnomo
import Lib.Raca.Gnomo_Floresta
import Lib.Raca.Gnomo_Rochas
import Lib.Raca.Halfling
import Lib.Raca.Helfling_Pes_Leve
import Lib.Raca.Helfling_Robusto
import Lib.Raca.Humano
import Lib.Raca.Meio_Elfo
import Lib.Raca.Meio_Orc
import Lib.Raca.Racas
import Lib.Raca.Tiefling

class PreviewClasse {
    fun returnInfo(classe:String) : String{
        var ClasseDefinido : Classes = Bardo()

        when(classe){
            "Artífice" -> {ClasseDefinido = Artifice()
            }
            "Bárbaro" -> {ClasseDefinido = Barbaro()
            }
            "Bardo" -> {ClasseDefinido = Bardo()
            }
            "Bruxo" -> {ClasseDefinido = Bruxo()
            }
            "Clérigo" -> {ClasseDefinido = Clerigo()
            }
            "Druida" -> {ClasseDefinido = Druida()
            }
            "Feiticeiro" -> {ClasseDefinido = Feiticeiro()
            }
            "Guardião" -> {ClasseDefinido = Guardiao()
            }
            "Guerreiro" -> {ClasseDefinido = Guerreiro()
            }
            "Ladino" -> {ClasseDefinido = Ladino()
            }
            "Mago" -> {ClasseDefinido = Mago()
            }
            "Monge" -> {ClasseDefinido = Monge()
            }
            "Paladino" -> {ClasseDefinido = Paladino()
            }

        }

        val rec = ClasseDefinido.returnInfo()
        return rec
    }
}