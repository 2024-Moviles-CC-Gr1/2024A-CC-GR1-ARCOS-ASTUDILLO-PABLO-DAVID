class Pais {
    val nombre: String
    val numeroTotalIngredientes: Int
    val superficie: Double
    val esIndependiente: Boolean
    val fechaFundacion: String,
    val ciudades: MutableList<Ciudad> = mutableListOf()
}