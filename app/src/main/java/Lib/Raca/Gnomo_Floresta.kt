package Lib.Raca

class Gnomo_Floresta : Racas{
    override fun definirRaca() {
        print("Gnomo da Foloresta")
    }

    override fun HabilidadeRaca(): Array<Int> {
        //1-Forca 2-Destreza 3-Constituicao 4-Inteligencia 5-Sabedoria 6- Carisma
        return arrayOf(0,1,0,0,0,0)

    }

    override fun AtributosAdd(): String {
        return "Destreza: +1"
    }
}