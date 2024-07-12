package com.example.shortnews.UI

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.shortnews.databinding.ActivitySignupScreenBinding
import com.google.firebase.auth.FirebaseAuth


class SignupScreen : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivitySignupScreenBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupScreenBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.signUpbtn.setOnClickListener {
            signUpBtn()
        }

        binding.login.setOnClickListener {
            val intent = Intent(applicationContext, LoginScreen::class.java)
            startActivity(intent)
        }
    }

    private fun signUpBtn() {
        val email = binding.signUppageemail.text.toString()
        val password = binding.signUppagepassword.text.toString()
        val name = binding.signuUppagename.text.toString()

        if (email.isBlank() || password.isBlank()) {
            Toast.makeText(this, "Fill all the blanks", Toast.LENGTH_SHORT).show()
        } else {
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) {
                    if (it.isSuccessful) {
                        Toast.makeText(this, "Account created", Toast.LENGTH_SHORT).show()
                        val intent = Intent(applicationContext, LoginScreen::class.java)
                            .putExtra("name",name.toString())
                        startActivity(intent)
                    }
                }
        }

    }
}

