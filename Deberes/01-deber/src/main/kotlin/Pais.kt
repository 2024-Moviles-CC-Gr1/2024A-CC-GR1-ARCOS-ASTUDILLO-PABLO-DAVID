import java.time.LocalDate

data class Pais(
    var nombre: String,
    var superficie: Double,
    var esIndependiente: Boolean,
    var fechaFundacion: LocalDate,
    val ciudades: MutableList<Ciudad> = mutableListOf()
)
