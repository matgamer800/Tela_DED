package Lib.Raca

class Anao : Racas{
    override fun definirRaca() {
        print("Anão")
    }

    override fun HabilidadeRaca(): Array<Int> {
    //1-Forca 2-Destreza 3-Constituição 4-Inteligencia 5-Sabedoria 6- Carisma
        return arrayOf(0,0,2,0,0,0)
    }

    override fun AtributosAdd(): String {
        return "Constituição: +2"
    }
}