package com.example.ejemplocalculadoramvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ejemplocalculadoramvvm.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    // Configurar binding

    private lateinit var  mainBinding: ActivityMainBinding
    private lateinit var  mainViewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)

        val view = mainBinding.root
        setContentView(view)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]


        val sumaObserver = Observer<Double> {suma ->
            mainBinding.resulltTextView.text = suma.toString()
        }
        mainViewModel.suma.observe(this, sumaObserver)

        val restaObserver = Observer<Double> {resta ->
            mainBinding.resulltTextView.text = resta.toString()
        }
        mainViewModel.resta.observe(this, restaObserver)

        val multplicarObserver = Observer<Double> {multiplicar ->
            mainBinding.resulltTextView.text = multiplicar.toString()
        }
        mainViewModel.multiplicacion.observe(this, multplicarObserver)

        val dividirObserver = Observer<Double> {dividir ->
            mainBinding.resulltTextView.text = dividir.toString()
        }
        mainViewModel.multiplicacion.observe(this, dividirObserver)


        val errorMsgObserver = Observer<String> {errorMsg ->
            Snackbar.make(view,"Debe digitar dos numeros", Snackbar.LENGTH_INDEFINITE)
                .setAction("Aceptar") {}
                .show()
        }

        mainViewModel.errorMsg.observe(this, errorMsgObserver)

        mainBinding.addButton.setOnClickListener{
            mainViewModel.validateNumbersSuma(mainBinding.firstNumberEditText.text.toString(), mainBinding.secondNumberEditText.text.toString())
        }

        mainBinding.substractButton.setOnClickListener{
            mainViewModel.validateNumbersResta(mainBinding.firstNumberEditText.text.toString(), mainBinding.secondNumberEditText.text.toString())
        }

        mainBinding.multiplyButton.setOnClickListener{
            mainViewModel.validateNumbersMultiplicacion(mainBinding.firstNumberEditText.text.toString(), mainBinding.secondNumberEditText.text.toString())
        }

        mainBinding.divideButton.setOnClickListener{
            mainViewModel.validateNumbersDivision(mainBinding.firstNumberEditText.text.toString(), mainBinding.secondNumberEditText.text.toString())
        }

    }
}
