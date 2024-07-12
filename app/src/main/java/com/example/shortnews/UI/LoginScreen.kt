package com.example.shortnews.UI

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.shortnews.databinding.ActivityLoginScreenBinding

class LoginScreen : AppCompatActivity() {

    private lateinit var binding: ActivityLoginScreenBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginScreenBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.button.setOnClickListener{
            loginButton()
        }

        binding.signup.setOnClickListener {
            val intent = Intent(applicationContext, SignupScreen::class.java)
            startActivity(intent)
        }
    }

   private fun loginButton() {
       val email = binding.loginEditText.text.toString()
       val pass = binding.loginEdittextPassword.text.toString()

       if (email.isBlank() || pass.isBlank()) {
           Toast.makeText(this, "Fill all the blanks", Toast.LENGTH_SHORT).show()
       } else {
                       Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show()
                       val intent = Intent(applicationContext, MainActivity::class.java)
                       startActivity(intent)
                   }
    }
}

