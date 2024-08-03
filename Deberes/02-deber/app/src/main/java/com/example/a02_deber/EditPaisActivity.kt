package com.example.a02_deber

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalDate

class EditPaisActivity : AppCompatActivity() {

    private lateinit var db: DatabaseHelper
    private lateinit var nombreEditText: EditText
    private lateinit var superficieEditText: EditText
    private lateinit var independienteEditText: EditText
    private lateinit var fechaFundacionEditText: EditText
    private lateinit var editButton: Button
    private var paisId: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_pais)

        db = DatabaseHelper(this)
        nombreEditText = findViewById(R.id.nombreEditText)
        superficieEditText = findViewById(R.id.superficieEditText)
        independienteEditText = findViewById(R.id.independienteEditText)
        fechaFundacionEditText = findViewById(R.id.fechaFundacionEditText)
        editButton = findViewById(R.id.editButton)

        paisId = intent.getLongExtra("PAIS_ID", 0)
        loadPaisData()

        editButton.setOnClickListener {
            val nombre = nombreEditText.text.toString()
            val superficie = superficieEditText.text.toString().toDouble()
            val esIndependiente = independienteEditText.text.toString().toInt() == 1
            val fechaFundacion = LocalDate.parse(fechaFundacionEditText.text.toString())

            val pais = Pais(paisId, nombre, superficie, esIndependiente, fechaFundacion)
            db.updatePais(pais)
            finish()
        }
    }

    private fun loadPaisData() {
        val pais = db.getAllPaises().find { it.id == paisId }
        pais?.let {
            nombreEditText.setText(it.nombre)
            superficieEditText.setText(it.superficie.toString())
            independienteEditText.setText(if (it.esIndependiente) "1" else "0")
            fechaFundacionEditText.setText(it.fechaFundacion.toString())
        }
    }
}
