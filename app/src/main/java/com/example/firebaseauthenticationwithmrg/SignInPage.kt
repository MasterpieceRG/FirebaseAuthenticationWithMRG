package com.example.firebaseauthenticationwithmrg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firebaseauthenticationwithmrg.databinding.ActivitySignInPageBinding

class SignInPage : AppCompatActivity() {
    private lateinit var binding: ActivitySignInPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySignInPageBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.goSignup.setOnClickListener {
            startActivity(Intent(this@SignInPage, SignUpPage::class.java))
        }


    }
}