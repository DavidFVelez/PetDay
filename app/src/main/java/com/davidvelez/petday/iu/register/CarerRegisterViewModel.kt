package com.davidvelez.petday.iu.register
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CarerRegisterViewModel : ViewModel() {

    val passwordReg: MutableLiveData<String> = MutableLiveData()
    val emailReg: MutableLiveData<String> = MutableLiveData()
    val vPassword: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val vRPassword: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun validarContrasena(password: String, repPassword: String, email: String) {

        if (password == repPassword) {
            if (password.length >= 6) {
                passwordReg.value = password
                emailReg.value = email
                vRPassword.value = ""
            } else {
                vPassword.value = "Error. La contraseña debe ser de almenos 6 caracteres"
            }
        } else {
            vRPassword.value = "Las contraseñas no son iguales"

        }
    }

}