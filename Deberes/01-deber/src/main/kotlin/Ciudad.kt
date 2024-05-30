import java.time.LocalDate

data class Ciudad(
    var nombre: String,
    var poblacion: Int,
    var area: Double,
    var esCapital: Boolean,
    var fechaEstablecimiento: LocalDate
)
