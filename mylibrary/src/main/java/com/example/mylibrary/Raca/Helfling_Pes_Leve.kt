package Raca

class Helfling_Pes_Leve : Racas {
    override fun definirRaca() {
        print("Helfling Pés Leves")
    }

    override fun HabilidadeRaca(): Array<Int> {
        //1-Forca 2-Destreza 3-Constituicao 4-Inteligencia 5-Sabedoria 6- Carisma
        return arrayOf(0,0,0,0,0,1)
    }
}