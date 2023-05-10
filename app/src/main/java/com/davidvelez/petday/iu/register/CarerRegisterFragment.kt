package com.davidvelez.petday.iu.register

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.davidvelez.petday.R
import com.davidvelez.petday.databinding.FragmentCarerRegisterBinding

class CarerRegisterFragment : Fragment() {

    companion object {
        fun newInstance() = CarerRegisterFragment()
    }

    private lateinit var carerRegisterBinding: FragmentCarerRegisterBinding
    private lateinit var carerRegisterViewModel: CarerRegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        carerRegisterBinding = FragmentCarerRegisterBinding.inflate(inflater, container, false)
        return carerRegisterBinding.root
//        return inflater.inflate(R.layout.fragment_carer_register, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        carerRegisterViewModel = ViewModelProvider(this).get(CarerRegisterViewModel::class.java)
        // TODO: Use the ViewModel

        val valPassword = Observer<String> { vPassword ->
            carerRegisterBinding.contrasenhaUsuarioRegisterTextInputLayout.error = vPassword
        }
        carerRegisterViewModel.vPassword.observe(viewLifecycleOwner, valPassword)

        val valRepPassword = Observer<String> { vRPassword ->
            carerRegisterBinding.nombreUsuarioRegisterEditText.setText(vRPassword)
            if(vRPassword =="") {
                findNavController().navigate(CarerRegisterFragmentDirections.actionCarerRegisterFragmentToCarerLoginFragment())
                carerRegisterBinding.repetirContrasenhaUsuarioRegisterTextInputLayout.error =
                    null // Elimina el texto de error
                carerRegisterBinding.repetirContrasenhaUsuarioRegisterTextInputLayout.isErrorEnabled =
                    false // Desactiva el mensaje de error
            }
            else {
                carerRegisterBinding.repetirContrasenhaUsuarioRegisterTextInputLayout.error = vRPassword
                carerRegisterBinding.repetirContrasenhaUsuarioRegisterEditText.setText(" ")
            }
        }



        carerRegisterViewModel.vRPassword.observe(viewLifecycleOwner, valRepPassword)

        carerRegisterBinding.botonRegistrarseFragmentRegistro.setOnClickListener{

            carerRegisterViewModel.validarContrasena(
                carerRegisterBinding.contrasenhaUsuarioRegisterEditText.text.toString(),
                carerRegisterBinding.repetirContrasenhaUsuarioRegisterEditText.text.toString(),
                carerRegisterBinding.correoRegisterEditText.text.toString()

            )

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var test = carerRegisterBinding.contrasenhaUsuarioRegisterEditText.text.toString()
        carerRegisterBinding.nombreUsuarioRegisterEditText.setText(test)
    }

}

