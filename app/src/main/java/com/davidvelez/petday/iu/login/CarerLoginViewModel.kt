package com.davidvelez.petday.iu.login


import android.text.Editable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class CarerLoginViewModel: ViewModel() {

    //Declaración de variables

    val lEmail: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val lPassword: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }



    //Declaración de funciones

    fun validarDatos(passwordLogin: String, emailLogin: String, passwordReg : String, emailReg: String):Boolean{

        if(passwordLogin == passwordReg && emailLogin ==emailReg)
            return true
        else {
            return false
        }

    }
}