package com.davidvelez.petday.iu.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.davidvelez.petday.R
import com.davidvelez.petday.databinding.FragmentCarerLoginBinding


class CarerLoginFragment : Fragment() {
    private  lateinit var carerLoginBinding: FragmentCarerLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        carerLoginBinding = FragmentCarerLoginBinding.inflate(inflater, container, false)
        val view=carerLoginBinding.root

        carerLoginBinding.sinoHayCuenta.setOnClickListener {
            findNavController().navigate(CarerLoginFragmentDirections.actionCarerLoginFragmentToCarerRegisterFragment())
        }


        return view

    }


}