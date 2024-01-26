package org.example

import kotlin.reflect.typeOf

fun main() {
    println("------Ejercicio TDD - Validación de Cédula Ecuatoriana------")
    testFunctionSuccess()
    testFunctionFailed()

    println("")

    println("------Ejercicio TDD - Validación de placa automóvil Ecuador ------")
    testFunctionSuc()
    testFunctionFailure()
}

fun validatedCi(ced: String): Boolean{

    var num: Int = 0
    var sum = 0
    var result: Int

    for (i in 0 until ced.length){
        // println("Estoy en" + " " +  ced[i])
        num = ced[i].toString().toInt()

        if (i%2 == 0){ // condición para ver si la posición es par y realizar la operación de multiplicación
            num = num * 2
            if (num >  9){ // condición en caso de ser número mayor a 9
                num = num - 9
            }
        }
        sum = sum + num // Suma los dígitos obtenidos al total
    }

    if(sum % 10 != 0) { // condición para identificar el dígito verificador (último dígito de la cédula)
        result = 10 - (sum % 10)

        // Compara el dígito verificador obtenido con el último dígito de la cédula
        if(result == num){ //  cuando se acabe el bucle for, 'num' se quedará con el último número de la ced
            print("La cédula ingresada: " + ced + ", ES Ecuatoriana --> ")
            return true
        }else{
            print("La cédula ingresada: " + ced + ", NO ES Ecuatoriana --> ")
            return false
        }
    }else{
        print("La cédula ingresada: " + ced + ", ES Ecuatoriana --> ")
        return true
    }
}


// -------------Sección de testo-------------
fun testFunctionSuccess (){
    println("Prueba de testeo correcto")
    val actualValue = validatedCi("0107425761")

    val expectedValue = true

    if (actualValue == expectedValue){
        println("SUCCESS")
    }else{
        println("FAILED")
    }
}

fun testFunctionFailed (){
    println("Prueba de testeo incorrecto")
    val actualValue = validatedCi("0107425762")

    val expectedValue = false

    if (actualValue == expectedValue){
        println("SUCCESS")
    }else{
        println("FAILED")
    }
}

// ******************************************************************************************************************

fun validatedLicensePlate(plate: String): Boolean{
    val regexPlate = Regex("^[A-Z]{3}-\\d{4}\$")

    if (regexPlate.matches(plate)){
        print("La placa de automóvil: " + plate + ", ES ecuatoriana --> ")
        return true
    }else{
        print("La placa de automóvil: " + plate + ", NO ES ecuatoriana --> ")
        return false
    }
}

// -------------Sección de testo-------------
fun testFunctionSuc() {
    println("Prueba de testeo correcto")
    val plate = "AUX-3214"
    val actualValue = validatedLicensePlate(plate)
    val expectedValue = true

    if (actualValue == expectedValue) {
        println("SUCCESS")
    } else {
        println("FAILED")
    }
}

fun testFunctionFailure() {
    println("Prueba de testeo incorrecto")
    val plate = "AUX-24"
    val actualValue = validatedLicensePlate(plate)
    val expectedValue = false

    if (actualValue == expectedValue) {
        println("SUCCESS")
    } else {
        println("FAILED")
    }
}