package Lib.Raca

class Humano : Racas{
    override fun definirRaca() {
        print("Humano")
    }

    override fun HabilidadeRaca(): Array<Int> {
        //1-Forca 2-Destreza 3-Constituicao 4-Inteligencia 5-Sabedoria 6- Carisma
        return arrayOf(1,1,1,1,1,0)
    }

    override fun AtributosAdd(): String {
        return "Força: +1 Destreza: +1 Constituição: +1\nInteligência: +1 Sabedoria: +1"
    }
}