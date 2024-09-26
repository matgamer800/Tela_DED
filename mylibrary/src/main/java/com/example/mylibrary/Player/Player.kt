package Player

import Classes.Classes
import Raca.*


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
    fun exibirplayer(){
        println()
        println("Nome: "+this.Nome)
        println()

        print("Raça: ")
        this.Raca.definirRaca()
        println()
        println()
        print("Classe: ")
        this.Classe.definirClasse()
        println()
        println()
        println("Habilidades:")
        this.HabilidadePlayer.exibir()

        println()
        println("Pontos de Vida: "+this.Vida)
        println()
        println("Nivel: "+ this.Nivel)
    }
    /*
        Apenas para ter a ideia:
        Não deixar que realize o import na main
        deve-se utilizar when para definir classes e racas
        
    */
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



}
