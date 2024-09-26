package Raca

class Anao_Colina : Racas {
    override fun definirRaca() {
        print("Anão da Colina")
    }

    override fun HabilidadeRaca(): Array<Int> {
        //1-Forca 2-Destreza 3-Constituicao 4-Inteligencia 5-Sabedoria 6- Carisma
        return arrayOf(0, 0, 0, 0, 1, 0)
    }
}