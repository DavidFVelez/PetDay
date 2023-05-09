package com.davidvelez.petday.iu.register

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.davidvelez.petday.R
import com.davidvelez.petday.databinding.FragmentCarerRegisterBinding
import com.davidvelez.petday.iu.bottomnavigation.BottomNavigationActivity
import com.davidvelez.petday.iu.login.CarerLoginFragmentDirections
import com.davidvelez.petday.iu.main.MainActivity


class CarerRegisterFragment : Fragment() {

   private lateinit var carerRegisterBinding: FragmentCarerRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        carerRegisterBinding=FragmentCarerRegisterBinding.inflate(inflater,container,false)
        val view = carerRegisterBinding.root


        carerRegisterBinding.botonRegistrarseFragmentRegistro.setOnClickListener {
            val registrar = Intent(activity, BottomNavigationActivity::class.java)
            startActivity(registrar)
        }



        return view
    }


}
