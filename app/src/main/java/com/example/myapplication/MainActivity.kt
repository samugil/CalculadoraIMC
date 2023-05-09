package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // codigo comentado para uso da função
//        val edtPeso: EditText = findViewById(R.id.edtPeso)
//        val edtAltura: EditText = findViewById(R.id.edtAltura)
        val btnCal: Button = findViewById(R.id.btnCalc)



        btnCal.setOnClickListener {
            CalcIMC()
        // codigo comentado para uso da função
//            val AlturaStr = edtAltura.text.toString()
//            val PesoStr = edtPeso.text.toString()
//
//            if (AlturaStr.isNotEmpty() && PesoStr.isNotEmpty()) {
//                val altura: Float = AlturaStr.toFloat()
//                val peso: Float = PesoStr.toFloat()
//                val result: Float = peso / (altura * altura)
//
//
//
//                val intentResult = Intent(this, ResultActivity::class.java)
//                    .apply {
//                        putExtra("Extra_Result", result)
//                    }
//                startActivity(intentResult)
//            } else {
//                Toast.makeText(this, "Por favor preencher todos os campos", Toast.LENGTH_SHORT)
//                    .show()
//            }


        }

    }

    // criada nova função
    fun CalcIMC ( edtPeso: EditText = findViewById(R.id.edtPeso), edtAltura: EditText = findViewById(R.id.edtAltura)) {

        val AlturaStr = edtAltura.text.toString()
        val PesoStr = edtPeso.text.toString()

        if (AlturaStr.isNotEmpty() && PesoStr.isNotEmpty()) {
            val altura: Float = AlturaStr.toFloat()
            val peso: Float = PesoStr.toFloat()
            val result: Float = peso / (altura * altura)



            val intentResult = Intent(this, ResultActivity::class.java)
                .apply {
                    putExtra("Extra_Result", result)
                }
            startActivity(intentResult)

        } else {
            Toast.makeText(this, "Por favor preencher todos os campos", Toast.LENGTH_SHORT)
                .show()

        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}