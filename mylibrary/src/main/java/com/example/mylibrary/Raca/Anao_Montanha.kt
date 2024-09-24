package Raca

class Anao_Montanha : Racas {
    override fun definirRaca() {
        print("Anão da Montanha")
    }

    override fun HabilidadeRaca(): Array<Int> {
        //1-Forca 2-Destreza 3-Constituicao 4-Inteligencia 5-Sabedoria 6- Carisma
        return arrayOf(2,0,0,0,0,0)
    }

}