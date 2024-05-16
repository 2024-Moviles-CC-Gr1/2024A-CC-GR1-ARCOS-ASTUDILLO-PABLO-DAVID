import java.util.*

fun main(){
    println("Hello World!")

    // variables inmutables (no se re asigna no vamos a usar el = )

    val inmutable : String = "Adrian";
    // inmutable = "Vicente" //ERROR!

    var mutable: String = "Adrian"
    mutable = "Vicente" // OK

    // VAL > VAR

    // Duck Typing
    val ejemploVariable = " Adrian Eguez "
    val edadEjemplo: Int = 12
    ejemploVariable.trim() //  Elimina los espacios al principio y al final de un string


    //variables primitivas

    val nombreProfesor: String = "Adrian Eguez"
    val sueldo: Double = 1.2
    val estadoCivil: Char = 'C'
    val mayorEdad: Boolean = true

    //Clases en java

    val fechaNacimiento: Date = Date()

    //When que es como un switch

    val estadoCivilWhen = "C"

    when(estadoCivilWhen){
        ("C") ->{
            println("Casado")
        }
        "S" -> {
            println("Soltero")
        }
        else -> {
            println("No sabemos")
        }
    }

    val esSoltero = (estadoCivilWhen == "S")
    val coqueteo = if (esSoltero) "Si" else "No" // if else chiquito


    calcularSueldo(10.00)
    calcularSueldo(10.00,15.00,20.00)

    //Named parameters
    // calcularSueldo(sueldo, tasa, bonoEspecial)
    calcularSueldo(10.00, bonoEspecial = 20.00)
    calcularSueldo(bonoEspecial = 20.00, sueldo = 10.00, tasa = 14.00)

    val sumaUno = Suma(1,1) //new Suma(1,1) en KOTLIN no hay "new"
    val sumaDos = Suma(null,1)
    val sumaTres = Suma(1,null)
    val sumaCuatro = Suma(null,null)

    sumaUno.sumar()
    sumaDos.sumar()
    sumaTres.sumar()
    sumaCuatro.sumar()

    println(Suma.pi)
    println(Suma.elevarAlCuadrado(2))
    println(Suma.historialSumas)

    //Arreglos
    //Estaticos
    val arregloEstatico: Array<Int> = arrayOf(1,2,3)
    println(arregloEstatico);
    //dinamicos
    val arregloDinamico: ArrayList<Int> = arrayListOf<Int>(
        1,2,3,4,5,6,7,8,9,10
    )

    println(arregloDinamico)
    arregloDinamico.add(11)
    arregloDinamico.add(12)
    println(arregloDinamico)

    //For each = > Unit
    //Iterar un arreglo

    val respuestaForEach: Unit = arregloDinamico
        .forEach {valorActual: Int ->
            println("Valor actual: $valorActual");
        }

    // "it" (en ingles "eso") significa el elemento iterado
    arregloDinamico.forEach { println("Valor Actual (it): $it"); }

    //MAP -> MUTA (Modifica cambia) el arreglo
    //1) Enviamos el nuevo valor de la iteracion
    //2) Nos devuelve un NUEVO ARREGLO con valores
    //de las iteraciones

    val respuestamap: List<Double> = arregloDinamico
        .map {valorActual: Int ->
            return@map valorActual.toDouble() + 100.00
        }
    println(respuestamap)

    val respuestaMapDos = arregloDinamico.map{it + 15}
    println(respuestaMapDos)

    // Filter - > Filtrar el ARREGLO

    // 1) Devolver una expresion (TRUE or FALSE)

    // 2) Nuevo arreglo FILTRADO

    println("Arreglo dinamico: " + arregloDinamico)

    val respuestaFilter: List<Int> = arregloDinamico
        .filter{ valorActual:Int ->
            // Expresion o CONDICION
            val mayoresACinco: Boolean = valorActual > 5
            return@filter mayoresACinco
        }

    val respuestaFilterDos = arregloDinamico.filter{ it <=5}
    println(respuestaFilter)
    println(respuestaFilterDos)

    // OR AND
    // OR -> ANY (Alguno cumple?)
    // And -> ALL (Todos cumplen?)
    val respuestaAny: Boolean = arregloDinamico
        .any{ valorActual: Int ->
            return@any (valorActual > 5)
        }
    println(respuestaAny) //True

    val respuestaAll: Boolean = arregloDinamico
        .all{ valorActual: Int ->
            return@all (valorActual > 5)
        }
    println(respuestaAll) //False

    // REDUCE -> Valor acumulado
    // Valor acumulado = 0 (Siempre empieza en 0 en kotlin)
    // [1, 2, 3, 4, 5] -> Acumular "SUMAR" estos valores del arreglo
    // valorIteracion1 = valorEmpieza + 1 = 0 + 1 = 1 -> Iteracion1
    // valor Iteracion2 = valorAcumuladoIteracion1 + 2 = 1 + 2 = 3 -> Iteracion2
    // valor Iteracion3 = valorAcumuladoIteracion2 + 3 = 3 + 3 = 6 -> Iteracion2

    val respuestaReduce: Int = arregloDinamico
        .reduce{acumulado: Int, valorActual: Int ->
            return@reduce (acumulado + valorActual) // -> Cambiar o usar la logica de negoci
        }
    println(respuestaReduce);

    // return@reduce acumulado + (itemCarrito.cantidad * itemCarrito.precio)



} // Termina la funcion main

//void -> Unit

fun imprimirNombre(nombre:String): Unit{
    print("Nombre: ${nombre}") //Template String
}

fun calcularSueldo(
    sueldo:Double, //Requerido
    tasa: Double = 12.00, //opcional pero por defecto
    bonoEspecial: Double? = null //Opcional (nullable)
    //Variable? -> '?' Es nullable (osea que peude en algun momenot ser nulo)
): Double{
    //Int -> Int? (nullable)
    //String -> String? (nullable)
    //Date -> Date? (nullable)

    if(bonoEspecial == null) {
        return sueldo * (100/tasa)
    }else{
        return sueldo * (100/tasa) * bonoEspecial
    }
}

abstract class NumerosJava{
    protected val numeroUno:Int
    private val numeroDos: Int
    constructor(
        uno:Int,
        dos:Int
    ){
        this.numeroUno = uno
        this.numeroDos = dos
        println("Inicializando")
    }
}

abstract class Numeros( //Constructor Primario
    //caso 1) Parametro normal
    //uno: int, (parametro (sin modificar acceso)) )

    //caso 2) parametro y propiedad (atributo)
    //private var uno: Int (propiedad "instancia.uno")

    //caso 3) Parametro y propiedad publica (atributo)
    //var uno: Int (propiedad de la clase "instancia.uno") (public)

    protected val numeroUno: Int, // instancia.numeroUno)
    protected val numeroDos: Int, // instancia.numeroDos
){
    init{ // bloque constructor primario
        println("Inicializando")
    }


}

class Suma (//Constructor primario
    unoParametro: Int,
    dosParametro: Int
): Numeros( //clase papa, numeros (estamos extendiendo)
    unoParametro,
    dosParametro
){

    public var soyPublicoExplicito: String = "Explicito"
    val soyPublicoImplicito: String = "Implicito" //Publicas

    init{ //Bloque de codigo constructor primario

        this.numeroUno
        this.numeroDos

        numeroUno
        numeroDos // el this es opcional tanto para propiedades como para metodos

        this.soyPublicoExplicito
        soyPublicoImplicito

    }

    constructor( //constructor secundario
        uno:Int?,
        dos:Int
    ):this(
        if(uno==null) 0 else uno,
        dos
    )

    constructor( //constructor tercero
        uno:Int,
        dos:Int?
    ):this(
        uno,
        if (dos == null) 0 else dos,
    )

    constructor(
        uno: Int?,
        dos: Int?
    ) : this(
        if (uno == null) 0 else uno,
        if (dos == null) 0 else dos
    )

    //public fun sumar(): Init{ (es opcional el public)
    fun sumar(): Int{
        val total = numeroUno + numeroDos
        agregarHistorial(total)
        return total
    }

    companion object{ //comparte entre todas las instancias, similar al static
        //funciones y variables
        val pi = 3.14
        fun elevarAlCuadrado(num:Int): Int{
            return num * num
        }

        val historialSumas = arrayListOf<Int>()
        fun agregarHistorial(valorTotalSuma:Int){
            historialSumas.add(valorTotalSuma)
        }

    }

}