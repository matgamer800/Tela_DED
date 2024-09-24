import Classes.Barbaro
import Player.Habilidade
import Player.Player
import Raca.Humano


fun main(args: Array<String>) {
    println("!----------------Novo Personagem----------------!")
    val habilidad = Habilidade(9,9,9,0,0,0)
    val playerNew = Player("matheus", habilidad,Humano(),Barbaro())
    playerNew.exibirplayer()

}