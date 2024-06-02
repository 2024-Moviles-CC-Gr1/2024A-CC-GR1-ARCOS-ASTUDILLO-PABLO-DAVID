import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    val paises = leerDatosDesdeJson("paises.json")

    while (true) {
        println("\nMenú CRUD")
        println("1. Crear País")
        println("2. Leer Países")
        println("3. Actualizar País")
        println("4. Eliminar País")
        println("5. Crear Ciudad")
        println("6. Leer Ciudades")
        println("7. Actualizar Ciudad")
        println("8. Eliminar Ciudad")
        println("9. Guardar y Salir")
        println("Elige una opción:")

        when (scanner.nextLine().toInt()) {
            1 -> {
                println("Nombre del País:")
                val nombre = scanner.nextLine()
                println("Superficie:")
                val superficie = scanner.nextLine().toDouble()
                println("Es Independiente (true/false):")
                val esIndependiente = scanner.nextLine().toBoolean()
                println("Fecha de Fundación (YYYY-MM-DD):")
                val fechaFundacion = LocalDate.parse(scanner.nextLine(), formatter)

                val nuevoPais = Pais(nombre, superficie, esIndependiente, fechaFundacion)
                crearPais(paises, nuevoPais)
                guardarDatosEnJson(paises, "paises.json") // Guardar después de crear
            }
            2 -> leerPaises(paises)
            3 -> {
                println("Nombre del País a actualizar:")
                val nombre = scanner.nextLine()
                val pais = paises.find { it.nombre == nombre }
                if (pais != null) {
                    while (true) {
                        println("\nActualizar País")
                        println("1. Nombre")
                        println("2. Superficie")
                        println("3. Independencia")
                        println("4. Fecha de Fundación")
                        println("5. Volver al menú principal")
                        println("Elige una opción:")

                        when (scanner.nextLine().toInt()) {
                            1 -> {
                                println("Nuevo nombre del País:")
                                val nuevoNombre = scanner.nextLine()
                                actualizarPaisNombre(pais, nuevoNombre)
                            }
                            2 -> {
                                println("Nueva superficie del País:")
                                val nuevaSuperficie = scanner.nextLine().toDouble()
                                actualizarPaisSuperficie(pais, nuevaSuperficie)
                            }
                            3 -> {
                                println("Es Independiente (true/false):")
                                val nuevaIndependencia = scanner.nextLine().toBoolean()
                                actualizarPaisIndependencia(pais, nuevaIndependencia)
                            }
                            4 -> {
                                println("Nueva fecha de Fundación (YYYY-MM-DD):")
                                val nuevaFechaFundacion = LocalDate.parse(scanner.nextLine(), formatter)
                                actualizarPaisFechaFundacion(pais, nuevaFechaFundacion)
                            }
                            5 -> break
                            else -> println("Opción no válida.")
                        }
                        guardarDatosEnJson(paises, "paises.json") // Guardar después de actualizar
                    }
                } else {
                    println("País no encontrado.")
                }
            }
            4 -> {
                println("Nombre del País a eliminar:")
                val nombre = scanner.nextLine()
                eliminarPais(paises, nombre)
                guardarDatosEnJson(paises, "paises.json") // Guardar después de eliminar
            }
            5 -> {
                println("Nombre del País al que pertenece la Ciudad:")
                val nombrePais = scanner.nextLine()
                val pais = paises.find { it.nombre == nombrePais }
                if (pais != null) {
                    println("Nombre de la Ciudad:")
                    val nombreCiudad = scanner.nextLine()
                    println("Población:")
                    val poblacion = scanner.nextLine().toInt()
                    println("Área:")
                    val area = scanner.nextLine().toDouble()
                    println("Es Capital (true/false):")
                    val esCapital = scanner.nextLine().toBoolean()
                    println("Fecha de Establecimiento (YYYY-MM-DD):")
                    val fechaEstablecimiento = LocalDate.parse(scanner.nextLine(), formatter)

                    val nuevaCiudad = Ciudad(nombreCiudad, poblacion, area, esCapital, fechaEstablecimiento)
                    crearCiudad(pais, nuevaCiudad)
                    guardarDatosEnJson(paises, "paises.json") // Guardar después de crear ciudad
                } else {
                    println("País no encontrado.")
                }
            }
            6 -> {
                println("Nombre del País para listar sus Ciudades:")
                val nombrePais = scanner.nextLine()
                val pais = paises.find { it.nombre == nombrePais }
                if (pais != null) {
                    leerCiudades(pais)
                } else {
                    println("País no encontrado.")
                }
            }
            7 -> {
                println("Nombre del País al que pertenece la Ciudad:")
                val nombrePais = scanner.nextLine()
                val pais = paises.find { it.nombre == nombrePais }
                if (pais != null) {
                    println("Nombre de la Ciudad a actualizar:")
                    val nombreCiudad = scanner.nextLine()
                    val ciudad = pais.ciudades.find { it.nombre == nombreCiudad }
                    if (ciudad != null) {
                        while (true) {
                            println("\nActualizar Ciudad")
                            println("1. Nombre")
                            println("2. Población")
                            println("3. Área")
                            println("4. Es Capital")
                            println("5. Fecha de Establecimiento")
                            println("6. Volver al menú principal")
                            println("Elige una opción:")

                            when (scanner.nextLine().toInt()) {
                                1 -> {
                                    println("Nuevo nombre de la Ciudad:")
                                    val nuevoNombre = scanner.nextLine()
                                    actualizarCiudadNombre(ciudad, nuevoNombre)
                                }
                                2 -> {
                                    println("Nueva población de la Ciudad:")
                                    val nuevaPoblacion = scanner.nextLine().toInt()
                                    actualizarCiudadPoblacion(ciudad, nuevaPoblacion)
                                }
                                3 -> {
                                    println("Nueva área de la Ciudad:")
                                    val nuevaArea = scanner.nextLine().toDouble()
                                    actualizarCiudadArea(ciudad, nuevaArea)
                                }
                                4 -> {
                                    println("Es Capital (true/false):")
                                    val nuevoEsCapital = scanner.nextLine().toBoolean()
                                    actualizarCiudadEsCapital(ciudad, nuevoEsCapital)
                                }
                                5 -> {
                                    println("Nueva fecha de Establecimiento (YYYY-MM-DD):")
                                    val nuevaFechaEstablecimiento = LocalDate.parse(scanner.nextLine(), formatter)
                                    actualizarCiudadFechaEstablecimiento(ciudad, nuevaFechaEstablecimiento)
                                }
                                6 -> break
                                else -> println("Opción no válida.")
                            }
                            guardarDatosEnJson(paises, "paises.json") // Guardar después de actualizar
                        }
                    } else {
                        println("Ciudad no encontrada.")
                    }
                } else {
                    println("País no encontrado.")
                }
            }
            8 -> {
                println("Nombre del País al que pertenece la Ciudad:")
                val nombrePais = scanner.nextLine()
                val pais = paises.find { it.nombre == nombrePais }
                if (pais != null) {
                    println("Nombre de la Ciudad a eliminar:")
                    val nombreCiudad = scanner.nextLine()
                    eliminarCiudad(pais, nombreCiudad)
                    guardarDatosEnJson(paises, "paises.json") // Guardar después de eliminar
                } else {
                    println("País no encontrado.")
                }
            }
            9 -> {
                guardarDatosEnJson(paises, "paises.json")
                println("Datos guardados. Saliendo...")
                break
            }
            else -> println("Opción no válida.")
        }
    }
}
