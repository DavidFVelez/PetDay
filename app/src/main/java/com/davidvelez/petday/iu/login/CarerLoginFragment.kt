package com.davidvelez.petday.iu.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.davidvelez.petday.databinding.FragmentCarerLoginBinding
import com.davidvelez.petday.iu.register.CarerRegisterViewModel


class CarerLoginFragment : Fragment() {

    private lateinit var carerLoginViewModel: CarerLoginViewModel
    private lateinit var carerRegisterViewModel: CarerRegisterViewModel
    private lateinit var carerLoginBinding: FragmentCarerLoginBinding

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        carerRegisterViewModel = ViewModelProvider(requireActivity()).get(CarerRegisterViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        carerLoginBinding = FragmentCarerLoginBinding.inflate(inflater, container, false)
        val view = carerLoginBinding.root

        carerLoginViewModel = ViewModelProvider(requireActivity())[CarerLoginViewModel::class.java]
        carerRegisterViewModel = ViewModelProvider(requireActivity())[CarerRegisterViewModel::class.java]

        val emailObserver = Observer<String> { lEmail ->
        }
        carerLoginViewModel.lEmail.observe(viewLifecycleOwner, emailObserver)

        val passwordObserver = Observer<String> { lPassword ->
        }
        carerLoginViewModel.lPassword.observe(viewLifecycleOwner, passwordObserver)

        val passwordRegObserver = Observer<String> { passwordReg ->
        }
        carerRegisterViewModel.passwordReg.observe(viewLifecycleOwner, passwordRegObserver)

        val emailRegObserver = Observer<String> { emailReg ->

        }
        carerRegisterViewModel.emailReg.observe(viewLifecycleOwner, emailRegObserver)


        carerLoginBinding.sinoHayCuenta.setOnClickListener {
            findNavController().navigate(CarerLoginFragmentDirections.actionCarerLoginFragmentToCarerRegisterFragment())
        }

        carerLoginBinding.entrar.setOnClickListener {
            if (carerLoginViewModel.validarDatos(
                    carerLoginBinding.contraseAEditText.text.toString(),
                    carerLoginBinding.correoEditText.text.toString(),
                    carerRegisterViewModel.passwordReg.value.toString(),
                    carerRegisterViewModel.emailReg.value.toString()))
            {

                findNavController().navigate(CarerLoginFragmentDirections.actionCarerLoginFragmentToBottomNavigationActivity())
            } else {
                Toast.makeText(requireContext(), "Credenciales invalidos", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
}



