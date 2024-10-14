package Lib.Raca

class PreviewRaca {
    fun returnAtributos(raca:String) : String{
        var RacaDefinido : Racas = Humano()

        when(raca){
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

        val rec = RacaDefinido.AtributosAdd()
        return rec
    }
}