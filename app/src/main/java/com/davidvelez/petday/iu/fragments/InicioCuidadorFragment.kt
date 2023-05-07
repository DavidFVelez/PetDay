package com.davidvelez.petday.iu.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.davidvelez.petday.R
import com.davidvelez.petday.databinding.FragmentInicioCuidadorBinding

class InicioCuidadorFragment : Fragment() {

    private lateinit var inicioCuidadorFragmentBinding: FragmentInicioCuidadorBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        inicioCuidadorFragmentBinding = FragmentInicioCuidadorBinding.inflate(inflater, container, false)
        val view = inicioCuidadorFragmentBinding.root

        return view
    }
}