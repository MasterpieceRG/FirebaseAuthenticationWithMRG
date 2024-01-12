package com.example.firebaseauthenticationwithmrg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.firebaseauthenticationwithmrg.databinding.ActivitySignUpPageBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class SignUpPage : AppCompatActivity() {
    private lateinit var binding:ActivitySignUpPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySignUpPageBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val email = binding.emailEt.text.toString()
        val pass = binding.passEt.text.toString()
        val conPass = binding.conpassEt.text.toString()
        binding.goSignin.setOnClickListener {

            if(email.isEmpty() || pass.isEmpty() || conPass.isEmpty()) {
                Toast.makeText(this, "Please fill the fields", Toast.LENGTH_SHORT).show()
            }else if(pass != conPass) {
                Toast.makeText(this, "Password and Confirm password should be same", Toast.LENGTH_SHORT).show()
            }else if(pass.length < 8) {
                Toast.makeText(this, "Password should be at least 8 characters", Toast.LENGTH_SHORT).show()
            }else {
                Firebase.auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this@SignUpPage, SignInPage::class.java)
                        startActivity(intent)
                    }else {
                        Toast.makeText(this, it.exception?.localizedMessage, Toast.LENGTH_SHORT).show()
                    }
                    Toast.makeText(this, "Sign up Successful", Toast.LENGTH_SHORT).show()
                }
            }


        }
    }
}