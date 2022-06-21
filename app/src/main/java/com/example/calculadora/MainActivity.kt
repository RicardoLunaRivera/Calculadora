package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //creamos las variables double
    private var num1:Double=0.0
    private var num2:Double=0.0
    private var operacion:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //se declaran todos los botones y sus números
        btnUno.setOnClickListener{numeroPresionado("1")}
        btnDos.setOnClickListener{numeroPresionado("2")}
        btnTres.setOnClickListener{numeroPresionado("3")}
        btnCuatro.setOnClickListener{numeroPresionado("4")}
        btnCinco.setOnClickListener{numeroPresionado("5")}
        btnSeis.setOnClickListener{numeroPresionado("6")}
        btnSiete.setOnClickListener{numeroPresionado("7")}
        btnOcho.setOnClickListener{numeroPresionado("8")}
        btnNueve.setOnClickListener{numeroPresionado("9")}
        btnCero.setOnClickListener{numeroPresionado("0")}

        // se agrega funcionalidad a las operaciones
        btnSuma.setOnClickListener{operacionPresionada(SUMA)}
        btnResta.setOnClickListener { operacionPresionada(RESTA) }
        btnMultiplicacion.setOnClickListener { operacionPresionada(MULTIPLICACION) }
        btnDivision.setOnClickListener { operacionPresionada(DIVISION) }

        //Agregamos funcionalidad al boton de limpiar
        btnLimpiar.setOnClickListener {
            num1 = 0.0
            num2 = 0.0
            txtResultado.text=""
            operacion= NO_OPERACION
        }

        //Agregamos funcionalidad al botón Igual
        btnIgual.setOnClickListener {
            var resultado =when(operacion){
                SUMA -> num1+num2
                RESTA -> num1-num2
                MULTIPLICACION->num1*num2
                DIVISION -> num1/num2
                else -> 0
            }
            txtResultado.text=resultado.toString()
        }


    }

    //función para imprimir en pantalla el número presionado
    private fun numeroPresionado(digito:String){
        txtResultado.text = "${txtResultado.text}$digito"

        if(operacion== NO_OPERACION){
            num1 = txtResultado.text.toString().toDouble()
        }else{
            num2= txtResultado.text.toString().toDouble()
        }

    }

    //funcion para ver qué operacion se ejecutará
    private fun operacionPresionada(operacion: Int){
        this.operacion = operacion

        txtResultado.text = ""
    }

    //Creamos las constantes para las operaciones
    companion object{
        const val SUMA =1
        const val RESTA=2
        const val MULTIPLICACION =3
        const val DIVISION =4
        const val NO_OPERACION =0
    }
}