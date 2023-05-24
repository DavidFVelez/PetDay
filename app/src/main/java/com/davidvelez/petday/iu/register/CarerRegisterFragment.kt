package com.davidvelez.petday.iu.register
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.davidvelez.petday.databinding.FragmentCarerRegisterBinding

class CarerRegisterFragment : Fragment() {

    companion object {

    }
    private lateinit var carerRegisterBinding: FragmentCarerRegisterBinding
    private lateinit var carerRegisterViewModel: CarerRegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        carerRegisterBinding = FragmentCarerRegisterBinding.inflate(inflater, container, false)
        return carerRegisterBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        carerRegisterViewModel = ViewModelProvider(requireActivity()).get(CarerRegisterViewModel::class.java)

        //Declaración de variables
        val passwordRegObserver = Observer<String> { passwordReg ->
        }
        carerRegisterViewModel.passwordReg.observe(viewLifecycleOwner, passwordRegObserver)

        val emailRegObserver = Observer<String> { emailReg ->
        }
        carerRegisterViewModel.emailReg.observe(viewLifecycleOwner, emailRegObserver)

        val valPassword = Observer<String> { vPassword ->
            carerRegisterBinding.contrasenhaUsuarioRegisterTextInputLayout.error = vPassword
        }
        carerRegisterViewModel.vPassword.observe(viewLifecycleOwner, valPassword)


        val valRepPassword = Observer<String> { vRPassword ->
            if(vRPassword =="") {
                findNavController().navigate(CarerRegisterFragmentDirections.actionCarerRegisterFragmentToCarerLoginFragment())
                carerRegisterBinding.repetirContrasenhaUsuarioRegisterTextInputLayout.error =
                    null // Elimina el texto de error
                carerRegisterBinding.repetirContrasenhaUsuarioRegisterTextInputLayout.isErrorEnabled =
                    false // Desactiva el mensaje de error
            }
            else {
                if (vRPassword=="Las contraseñas no son iguales"){
                    Toast.makeText(requireContext(), vRPassword, Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(requireContext(), vRPassword, Toast.LENGTH_SHORT).show()
                }



            }
        }

        carerRegisterViewModel.vRPassword.observe(viewLifecycleOwner, valRepPassword)

        carerRegisterBinding.botonRegistrarseFragmentRegistro.setOnClickListener{
            carerRegisterViewModel.validarContrasena(
                carerRegisterBinding.contrasenhaUsuarioRegisterEditText.text.toString(),
                carerRegisterBinding.repetirContrasenhaUsuarioRegisterEditText.text.toString(),
                carerRegisterBinding.correoRegisterEditText.text.toString(),
                carerRegisterBinding.nombreUsuarioRegisterEditText.text.toString(),
                carerRegisterBinding.telefonoUsuarioRegisterEditText.text.toString()

            )
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}

