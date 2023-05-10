package com.davidvelez.petday.iu.login

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.davidvelez.petday.R
import com.davidvelez.petday.databinding.FragmentCarerLoginBinding
import com.davidvelez.petday.iu.register.CarerRegisterViewModel


class CarerLoginFragment : Fragment() {

    private lateinit var carerLoginViewModel: CarerLoginViewModel
    private lateinit var carerRegisterViewModel: CarerRegisterViewModel
    private lateinit var carerLoginBinding: FragmentCarerLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        carerLoginBinding = FragmentCarerLoginBinding.inflate(inflater, container, false)
        val view = carerLoginBinding.root

        carerLoginViewModel = ViewModelProvider(this)[CarerLoginViewModel::class.java]
        carerRegisterViewModel = ViewModelProvider(this)[CarerRegisterViewModel::class.java]

        val emailObserver = Observer<String> { lEmail ->
            // Aquí puedes realizar alguna acción en función del cambio en el valor del email
        }

        carerLoginViewModel.lEmail.observe(viewLifecycleOwner, emailObserver)

        val passwordObserver = Observer<String> { lPassword ->
            // Aquí puedes realizar alguna acción en función del cambio en el valor de la contraseña
        }

        val passwordRegObserver = Observer<String> { passwordReg ->

//            var passwordReg = passwordReg
            carerLoginBinding.twitter.setText(passwordReg)
        }
        carerRegisterViewModel.passwordReg.observe(viewLifecycleOwner, passwordRegObserver)

        val emailRegObserver = Observer<String> { emailReg ->
//           var emailReg = emailReg
            carerLoginBinding.google.setText(emailReg)
        }
        carerRegisterViewModel.emailReg.observe(viewLifecycleOwner, emailRegObserver)
        carerLoginViewModel.lPassword.observe(viewLifecycleOwner, passwordObserver)

        carerLoginBinding.sinoHayCuenta.setOnClickListener {
            findNavController().navigate(CarerLoginFragmentDirections.actionCarerLoginFragmentToCarerRegisterFragment())
        }

        carerLoginBinding.entrar.setOnClickListener {
            val passwordLogin = carerLoginBinding.contraseAEditText.text.toString()
            val emailLogin = carerLoginBinding.correoEditText.text.toString()
            var passwordReg = carerRegisterViewModel.passwordReg.value ?: ""
            var emailReg = carerRegisterViewModel.emailReg.value ?: ""

            carerLoginBinding.facebook.setText(emailReg)
            if (carerLoginViewModel.validarDatos(passwordLogin, emailLogin, passwordReg, emailReg)) {
                // Aquí puedes realizar alguna acción cuando los datos sean válidos
                // Por ejemplo, navegar a otra pantalla
                findNavController().navigate(CarerLoginFragmentDirections.actionCarerLoginFragmentToInicioDuenoFragment())
            } else {
                // Aquí puedes mostrar un mensaje de error al usuario
                Toast.makeText(requireContext(), "Invalid credentials", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
}



