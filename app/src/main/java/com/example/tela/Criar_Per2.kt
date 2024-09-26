package com.example.tela

import Lib.Classes.Barbaro
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import Lib.Player.Player
import Lib.Player.Habilidade
import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView


class Criar_Per2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_criar_per2)

        //Usado para resgatar o valor da activity anterior
        val Nome = intent.getStringExtra("NomePer")
        val Raca = intent.getStringExtra("RacaPer")

        //Edit Text dos atributos
        val forca = findViewById<EditText>(R.id.id_forcas)
        val destreza = findViewById<EditText>(R.id.id_destreza)
        val constitui = findViewById<EditText>(R.id.id_constituicao)
        val inteligencia = findViewById<EditText>(R.id.id_inteligencia)
        val sabed = findViewById<EditText>(R.id.id_sabedoria)
        val carisma = findViewById<EditText>(R.id.id_carisma)

        //Botão de finalizar
        val Finalizar = findViewById<Button>(R.id.id_fianaliza)

        //botões para aumentar ou diminuir
        val MaisForca = findViewById<Button>(R.id.id_forcamais)
        val MenosForca = findViewById<Button>(R.id.id_forcamenos)

        MaisForca.setOnClickListener{
            addAtributo(forca)
        }
        MenosForca.setOnClickListener{
            removeAtributo(forca)
        }

        val Maisdestreza = findViewById<Button>(R.id.id_destrezamais)
        val Menosdestreza = findViewById<Button>(R.id.id_destrezamenos)

        Maisdestreza.setOnClickListener{
            addAtributo(destreza)
        }
        Menosdestreza.setOnClickListener{
            removeAtributo(destreza)
        }

        val Maisconstitui= findViewById<Button>(R.id.id_constituicaomais)
        val Menosconstitui = findViewById<Button>(R.id.id_constituicaomenos)

        Maisconstitui.setOnClickListener{
            addAtributo(constitui)
        }
        Menosconstitui.setOnClickListener{
            removeAtributo(constitui)
        }

        val Maisinteligencia= findViewById<Button>(R.id.id_inteligenciamais)
        val Menosinteligencia = findViewById<Button>(R.id.id_inteligenciamenos)

        Maisinteligencia.setOnClickListener{
            addAtributo(inteligencia)
        }
        Menosinteligencia.setOnClickListener{
            removeAtributo(inteligencia)
        }

        val Maissabed= findViewById<Button>(R.id.id_sabedoriamais)
        val Menossabed = findViewById<Button>(R.id.id_sabedoriamenos)

        Maissabed.setOnClickListener{
            addAtributo(sabed)
        }
        Menossabed.setOnClickListener{
            removeAtributo(sabed)
        }

        val Maiscarisma= findViewById<Button>(R.id.id_carismamais)
        val Menoscarisma = findViewById<Button>(R.id.id_carismamenos)

        Maiscarisma.setOnClickListener{
            addAtributo(carisma)
        }
        Menoscarisma.setOnClickListener{
            removeAtributo(carisma)
        }

        val up = findViewById<TextView>(R.id.id_pontos)

        fun addTextWatcher(editText: EditText) {
            val maxPoints = 27
            editText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    // Soma o valor atual de todos os EditTexts
                    val totalPoints = (forca.text.toString().toIntOrNull() ?: 0) +
                            (destreza.text.toString().toIntOrNull() ?: 0) +
                            (constitui.text.toString().toIntOrNull() ?: 0) +
                            (inteligencia.text.toString().toIntOrNull() ?: 0) +
                            (sabed.text.toString().toIntOrNull() ?: 0) +
                            (carisma.text.toString().toIntOrNull() ?: 0)



                    // Se a soma total dos pontos ultrapassar o limite, impede nova edição
                    if (totalPoints > maxPoints) {
                        editText.error = "Limite de 27 pontos atingido"
                        editText.setText(s?.substring(0, before)) // Reverte a alteração feita
                        editText.setSelection(before) // Posiciona o cursor no lugar correto
                    }
                    else{
                        var T = 27 - totalPoints
                        up.setText(T.toString())
                    }
                }

                override fun afterTextChanged(s: Editable?) {
                }
            })
        }

        addTextWatcher(forca)
        addTextWatcher(destreza)
        addTextWatcher(constitui)
        addTextWatcher(inteligencia)
        addTextWatcher(sabed)
        addTextWatcher(carisma)



        limitnumber(forca)
        limitnumber(inteligencia)
        limitnumber(destreza)
        limitnumber(constitui)
        limitnumber(sabed)
        limitnumber(carisma)

        val volta = findViewById<Button>(R.id.id_voltar)

        Finalizar.setOnClickListener{
            val forcaN  = convertnumber(forca)
            val destrezaN = convertnumber(destreza)
            val constituiN = convertnumber(constitui)
            val inteligenciaN = convertnumber(inteligencia)
            val sabedN = convertnumber(sabed)
            val carismaN = convertnumber(carisma)

            val intent = Intent(this,Perfil_Persona::class.java)

            intent.putExtra("forca",forcaN)
            intent.putExtra("destreza",destrezaN)
            intent.putExtra("constituicao",constituiN)
            intent.putExtra("inteligencia",inteligenciaN)
            intent.putExtra("sabedoria",sabedN)
            intent.putExtra("carisma",carismaN)
            intent.putExtra("raca",Raca)
            intent.putExtra("nome",Nome)


            startActivity(intent)
        }
        volta.setOnClickListener{
            val intent = Intent(this,Criar_Per1::class.java)
            startActivity(intent)
        }

    }

    /*Funções*/

    fun limitnumber(buton:EditText){

        buton.inputType = InputType.TYPE_CLASS_NUMBER

        val minvalue = 0
        val maxvalue = 9

        buton.filters = arrayOf(InputFilter { source, start, end, dest, dstart, dend ->
            try {
                val input = (dest.subSequence(0,dstart).toString() + source.toString() + dest.subSequence(dend, dest.length)).toInt()
                if (input in minvalue .. maxvalue) null else ""
            }
            catch (e:NumberFormatException){
                ""
            }
        })
    }

    fun convertnumber(edittext: EditText) : Int{
        val textValue = edittext.text.toString()
        val numberValue = if (textValue.isNotEmpty()) textValue.toInt() else 0

        return numberValue
    }

    fun addAtributo(editText: EditText){
        var cu = editText.text.toString()
        var numberValue = if (cu.isNotEmpty()) cu.toInt() else 0

        // Aumenta o valor até 9
        if (numberValue < 9) {
            numberValue++
            editText.setText(numberValue.toString())
        }
    }

    fun removeAtributo(editText: EditText){
        var cu = editText.text.toString()
        var numberValue = if (cu.isNotEmpty()) cu.toInt() else 0

        // Diminui o valor até 0
        if (numberValue > 0) {
            numberValue--
            editText.setText(numberValue.toString())
        }
    }



}