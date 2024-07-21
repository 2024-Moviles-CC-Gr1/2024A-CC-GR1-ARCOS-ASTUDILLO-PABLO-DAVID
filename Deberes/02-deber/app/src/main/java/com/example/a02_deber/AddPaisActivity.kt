package com.example.a02_deber

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalDate

class AddPaisActivity : AppCompatActivity() {

    private lateinit var db: DatabaseHelper
    private lateinit var nombreEditText: EditText
    private lateinit var superficieEditText: EditText
    private lateinit var independienteEditText: EditText
    private lateinit var fechaFundacionEditText: EditText
    private lateinit var addButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_pais)

        db = DatabaseHelper(this)
        nombreEditText = findViewById(R.id.nombreEditText)
        superficieEditText = findViewById(R.id.superficieEditText)
        independienteEditText = findViewById(R.id.independienteEditText)
        fechaFundacionEditText = findViewById(R.id.fechaFundacionEditText)
        addButton = findViewById(R.id.addButton)

        addButton.setOnClickListener {
            val nombre = nombreEditText.text.toString()
            val superficie = superficieEditText.text.toString().toDouble()
            val esIndependiente = independienteEditText.text.toString().toInt() == 1
            val fechaFundacion = LocalDate.parse(fechaFundacionEditText.text.toString())

            val pais = Pais(0, nombre, superficie, esIndependiente, fechaFundacion)
            db.addPais(pais)
            finish()
        }
    }
}
