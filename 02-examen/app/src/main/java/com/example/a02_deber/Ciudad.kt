package com.example.a02_deber

import java.time.LocalDate

data class Ciudad(
    val id: Long,
    val nombre: String,
    val poblacion: Int,
    val area: Double,
    val esCapital: Boolean,
    val fechaEstablecimiento: LocalDate
)

