package Lib.Raca

class Tiefling :Racas {
    override fun definirRaca() {
        print("Tiefling")
    }

    override fun HabilidadeRaca(): Array<Int> {
        //1-Forca 2-Destreza 3-Constituicao 4-Inteligencia 5-Sabedoria 6- Carisma
        return arrayOf(0,0,0,1,0,2)
    }

    override fun AtributosAdd(): String {
        return "Inteligência: +1 Carisma: +2"
    }
}