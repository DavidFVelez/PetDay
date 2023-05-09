package com.davidvelez.petday.iu.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.davidvelez.petday.R
import com.davidvelez.petday.databinding.FragmentInicioCuidadorBinding
import com.davidvelez.petday.databinding.FragmentInicioDuenoBinding


class InicioDuenoFragment : Fragment() {
    private lateinit var inicioDuenoFragmentBinding:FragmentInicioDuenoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        inicioDuenoFragmentBinding = FragmentInicioDuenoBinding.inflate(inflater, container, false)
        val view = inicioDuenoFragmentBinding.root

        return view
    }
}