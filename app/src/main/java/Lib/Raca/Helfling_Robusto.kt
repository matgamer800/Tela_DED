package Lib.Raca

class Helfling_Robusto :Racas {
    override fun definirRaca() {
        print("Helfling Robusto")
    }

    override fun HabilidadeRaca(): Array<Int> {
        //1-Forca 2-Destreza 3-Constituicao 4-Inteligencia 5-Sabedoria 6- Carisma
        return arrayOf(0,0,1,0,0,0)
    }

    override fun AtributosAdd(): String {
        return "Constituição: +1"
    }
}