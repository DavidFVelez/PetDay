package com.davidvelez.petday.iu.useroptions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.davidvelez.petday.R
import com.davidvelez.petday.databinding.ActivityUserOptionsBinding
import com.davidvelez.petday.iu.main.MainActivity

class UserOptionsActivity : AppCompatActivity() {
    private lateinit var userOptionsBinding: ActivityUserOptionsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userOptionsBinding = ActivityUserOptionsBinding.inflate(layoutInflater)

        val view = userOptionsBinding.root
        setContentView(view)

        userOptionsBinding.botonDueno.setOnClickListener {
            val dueno_mascota = Intent(this,MainActivity::class.java)
            startActivity(dueno_mascota)
        }

        userOptionsBinding.botonCuidador.setOnClickListener {
            val cuidador_mascota = Intent(this,MainActivity::class.java)
            startActivity(cuidador_mascota)
        }
    }
}