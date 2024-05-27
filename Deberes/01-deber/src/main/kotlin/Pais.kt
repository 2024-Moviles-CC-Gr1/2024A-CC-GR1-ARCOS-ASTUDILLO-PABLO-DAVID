data class Pais(
    var nombre: String,
    var superficie: Double,
    var esIndependiente: Boolean,
    var fechaFundacion: String,
    var ciudades: MutableList<Ciudad> = mutableListOf()
)

