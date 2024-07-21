package com.example.a02_deber

import java.time.LocalDate

data class Pais(
    var id: Long,
    var nombre: String,
    var superficie: Double,
    var esIndependiente: Boolean,
    var fechaFundacion: LocalDate,
    val ciudades: MutableList<Ciudad> = mutableListOf()
)
