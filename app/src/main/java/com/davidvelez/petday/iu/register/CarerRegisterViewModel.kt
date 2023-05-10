package com.davidvelez.petday.iu.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.davidvelez.petday.iu.login.CarerLoginFragmentDirections

class CarerRegisterViewModel : ViewModel() {

    val vPassword: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val vRPassword: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val passwordReg: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val emailReg: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }


    fun validarContrasena(password: String, repPassword: String, email: String) {
        passwordReg.value = "Usuario"
        emailReg.value = "usuario"
        if (password == repPassword) {
            if (password.length >= 6) {
                vPassword.value = ""
                vRPassword.value = ""
                passwordReg.value = password
                emailReg.value = email
            } else {
                vPassword.value = "Error. La contraseña debe ser de almenos 6 caracteres"
            }
        } else {
            vRPassword.value = "Las contraseñas no son iguales"
        }
    }

}