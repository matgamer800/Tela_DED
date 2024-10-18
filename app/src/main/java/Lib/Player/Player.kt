package Lib.Player

import Lib.Classes.Classes
import Lib.Raca.*

class Player {
    val Nome: String
    val Raca:Racas
    val Classe:Classes
    val HabilidadePlayer:Habilidade
    var Vida:Int =10
    var Nivel:Int = 1
    var Xp:Float =0.0f

    constructor(nome:String, habilidade: Habilidade,racas: String,classes: Classes){
        this.Nome = nome
        this.Classe = classes
        this.Raca = acharRaca(racas)
        var arrayRaca: Array<Int>
        arrayRaca = this.Raca.HabilidadeRaca()
        habilidade.atualizarHabilidade(arrayRaca)
        this.HabilidadePlayer = habilidade
        Vida = HabilidadePlayer.Calcvida(Vida)
    }

    private fun acharRaca(nomeRaca:String) : Racas{
        var RacaDefinido : Racas = Humano()

        when(nomeRaca){
                "Anão" -> {RacaDefinido = Anao()}
                "Anão da Colina" -> {RacaDefinido = Anao_Colina()}
                "Anão da Montanha" -> {RacaDefinido = Anao_Montanha()}
                "Elfo" -> {RacaDefinido = Elfo()}
                "Alto Elfo" -> {RacaDefinido =Alto_Elfo()}
                "Elfo da Floresta" -> {RacaDefinido =Elfo_Floresta()}
                "Elfo Negro (Drow)" -> {RacaDefinido =Drow()}
                "Meio-Elfo" -> {RacaDefinido =Meio_Elfo()}
                "Halfling" -> {RacaDefinido = Halfling()}
                "Halfling dos Pés Leves" -> {RacaDefinido = Helfling_Pes_Leve()}
                "Halfling Robusto" -> {RacaDefinido =Helfling_Robusto()}
                "Humano" -> {RacaDefinido =Humano()}
                "Draconato" -> {RacaDefinido =Draconato()}
                "Gnomo" -> {RacaDefinido =Gnomo()}
                "Gnomo da Floresta" -> {RacaDefinido =Gnomo_Floresta()}
                "Gnomo das Rochas" -> {RacaDefinido =Gnomo_Rochas()}
                "Meio-Orc" -> {RacaDefinido = Meio_Orc()}
                "Tieflings" -> {RacaDefinido = Tiefling()}
        }
        return RacaDefinido
    }

    fun returnHabil(): Array<Int>{
        val array = this.HabilidadePlayer.exibir()
        return array
    }

    fun returnVida(): Int{
        return this.Vida
    }
}
