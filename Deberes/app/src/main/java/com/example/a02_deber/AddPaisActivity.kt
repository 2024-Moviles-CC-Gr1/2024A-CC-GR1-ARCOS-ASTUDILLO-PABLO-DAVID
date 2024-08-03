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
    private lateinit var independenciaEditText: EditText
    private lateinit var fechaFundacionEditText: EditText
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_pais)

        db = DatabaseHelper(this)
        nombreEditText = findViewById(R.id.edittext_nombre)
        superficieEditText = findViewById(R.id.edittext_superficie)
        independenciaEditText = findViewById(R.id.edittext_independencia)
        fechaFundacionEditText = findViewById(R.id.edittext_fecha_fundacion)
        saveButton = findViewById(R.id.button_save_pais)

        saveButton.setOnClickListener {
            val nombre = nombreEditText.text.toString()
            val superficie = superficieEditText.text.toString().toDouble()
            val esIndependiente = independenciaEditText.text.toString().toBoolean()
            val fechaFundacion = LocalDate.parse(fechaFundacionEditText.text.toString())

            val nuevoPais = Pais(nombre = nombre, superficie = superficie, esIndependiente = esIndependiente, fechaFundacion = fechaFundacion)
            db.addPais(nuevoPais)
            finish()
        }
    }
}
