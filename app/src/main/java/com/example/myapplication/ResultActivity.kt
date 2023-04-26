package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val btnCalcNew  = findViewById<Button>(R.id.btnCalcNew)

        btnCalcNew.setOnClickListener {
            val intentMain = Intent(this, MainActivity::class.java)
            startActivity(intentMain)
        }

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvIMC: TextView = findViewById(R.id.tvIMC)
        val result: Float = intent.getFloatExtra("Extra_Result" , 0.0f)
        val tvImcT: TextView = findViewById(R.id.tvImcT)

        tvIMC.text = result.toString()

        var ImcT = ""

        ImcT = if (result <16.5f) {
            "Peso severamente abaixo do normal"
        } else if (result in 16.5f..18f) {
            "Peso abaixo do normal"
        } else if (result in 18.5f..24.99f) {
            "Peso normal"
        } else if (result in 25f..29.99f) {
            "Sobrepeso"
        }  else if (result in 30f..34.99f) {
            "Obesidade I"
        }  else if (result in 35f..39.99f) {
            "Obesidade II"
        } else {
            "Obesidade Mórbida"
        }
            tvImcT.text = ImcT

    }

     override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}