package com.davidvelez.petday.iu.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.davidvelez.petday.databinding.ActivitySplashBinding
import com.davidvelez.petday.iu.useroptions.UserOptionsActivity
import java.util.*
import kotlin.concurrent.timerTask

class SplashActivity : AppCompatActivity() {
    private lateinit var splashhBinding:ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashhBinding= ActivitySplashBinding.inflate(layoutInflater)
        val  view =splashhBinding.root
        setContentView(view)

        val timer = Timer()
        timer.schedule(
            timerTask {
                val intent = Intent(this@SplashActivity, UserOptionsActivity::class.java)
                startActivity(intent)
                finish()
            }, 2000
        )

    }

    override fun onStart() {
        super.onStart()
        Log.d("onStart","OK")
    }
    override fun onResume() {
        super.onResume()
        Log.d("onResume","OK")
    }

    override fun onPause() {
        super.onPause()
        Log.d("onPause","OK")
    }

    override fun onStop() {
        super.onStop()
        Log.d("onStop","OK")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("onRestart","OK")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("onDestroy","OK")
    }


}