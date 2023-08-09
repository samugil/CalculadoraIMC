package com.example.myapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView

class ResultActivity:AppCompatActivity(){

    companion object{

        const val EXTRA_IMC = "Extra_Result"
        fun startIntent(context: Context, imc: Float): Intent {
            return Intent(context, ResultActivity::class.java)
                .apply {
                    putExtra(EXTRA_IMC, imc)
                }

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val btnCalcNew = findViewById<Button>(R.id.btnCalcNew)

        btnCalcNew.setOnClickListener {
            val intentMain = Intent(this, MainActivity::class.java)
            startActivity(intentMain)
        }

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // criação de nova varavel para chamar na função com dados da tela do calculo
        var ImcT = intent.getFloatExtra(EXTRA_IMC, 0.0f)
        classficacao(ImcT)

        //Variavel movida para a função
        //val result: Float = intent.getFloatExtra("Extra_Result" , 0.0f)
        //val tvImcT: TextView = findViewById(R.id.tvImcT)


        // Variavel e logica movida para a função
        //var ImcT = ""

//        ImcT = if (result <16.5f) {
//            "Peso severamente abaixo do normal"
//        } else if (result in 16.5f..18f) {
//            "Peso abaixo do normal"
//        } else if (result in 18.5f..24.99f) {
//            "Peso normal"
//        } else if (result in 25f..29.99f) {
//            "Sobrepeso"
//        }  else if (result in 30f..34.99f) {
//            "Obesidade I"
//        }  else if (result in 35f..39.99f) {
//            "Obesidade II"
//        } else {
//            "Obesidade Mórbida"
//        }
//            tvImcT.text = ImcT

    }

    fun classficacao(
        result: Float = intent.getFloatExtra("Extra_Result", 0.0f),
        tvImcT: TextView = findViewById(R.id.tvImcT)
    ): String {

        val tvIMC: TextView = findViewById(R.id.tvIMC)
        tvIMC.text = result.toString()
        var ImcT = ""
        ImcT = if (result < 16.5f) {
            "Peso severamente abaixo do normal"
        } else if (result in 16.5f..18f) {
            "Peso abaixo do normal"
        } else if (result in 18.5f..24.99f) {
            "Peso normal"
        } else if (result in 25f..29.99f) {
            "Sobrepeso"
        } else if (result in 30f..34.99f) {
            "Obesidade I"
        } else if (result in 35f..39.99f) {
            "Obesidade II"
        } else {
            "Obesidade Mórbida"
        }
        tvImcT.text = ImcT

        return ImcT
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }

}
