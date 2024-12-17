
package com.mdselim.testgpt

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Delay for 2 seconds before starting MainActivity
        Handler().postDelayed({
            // Start MainActivity after the splash screen
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000) // 2 seconds delay
    }
}
