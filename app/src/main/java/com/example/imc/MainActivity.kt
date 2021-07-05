package com.example.imc

import kotlinx.android.synthetic.main.activity_main.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_result_imc.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()

    }
    private fun setListeners() {
       Altura?.doAfterTextChanged { text -> }

        //Toast.makeText( this, text.toString(), Toast.LENGTH_SHORT).show()

        peso?.doOnTextChanged { text, _, _, _ ->
            //Main?.text = text
        }
        calcular?.setOnClickListener{
            calcularIMC(peso.text.toString(), Altura.text.toString())
        }

    }
          private fun calcularIMC(peso:String , Altura: String){
              val peso = peso.toFloatOrNull()
              val Altura = Altura.toFloatOrNull()
              if (peso != null && Altura != null) {

                  val imc = peso / (Altura * Altura)
                 textTitulo.text = "Seu IMC é: $imc "  
              }


          }



        }



