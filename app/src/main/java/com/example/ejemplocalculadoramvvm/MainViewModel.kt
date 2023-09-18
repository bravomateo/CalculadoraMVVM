package com.example.ejemplocalculadoramvvm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    // Operacion Suma
    val suma : MutableLiveData<Double> by lazy {
        MutableLiveData<Double>()
    }

    // Operacion Resta
    val resta : MutableLiveData<Double> by lazy {
        MutableLiveData<Double>()
    }

    // Operacion Multiplicacion
    val multiplicacion : MutableLiveData<Double> by lazy {
        MutableLiveData<Double>()
    }

    // Operacion Division
    val division : MutableLiveData<Double> by lazy {
        MutableLiveData<Double>()
    }


    // Mensaje de error
    private val _errorMsg: MutableLiveData<String> = MutableLiveData()
    val errorMsg: LiveData <String> = _errorMsg

    fun validateNumbersSuma(number1: String, number2: String) {
        if (number1.isEmpty() || number2.isEmpty()) {
            _errorMsg.value = "Debe ingresae dos números para sumar"
        }
        else {
            suma.value = number1.toDouble() + number2.toDouble()
        }
    }

    fun validateNumbersResta(number1: String, number2: String) {
        if (number1.isEmpty() || number2.isEmpty()) {
            _errorMsg.value = "Debe ingresae dos números para restar"
        }
        else {
            suma.value = number1.toDouble() - number2.toDouble()
        }
    }

    fun validateNumbersMultiplicacion(number1: String, number2: String) {
        if (number1.isEmpty() || number2.isEmpty()) {
            _errorMsg.value = "Debe ingresae dos números para multiplicar"
        }
        else {
            suma.value = number1.toDouble() * number2.toDouble()
        }
    }

    fun validateNumbersDivision(number1: String, number2: String) {
        if (number1.isEmpty() || number2.isEmpty()) {
            _errorMsg.value = "Debe ingresae dos números para dividir"
        }
        else {
            suma.value = number1.toDouble() / number2.toDouble()
        }
    }


}