package com.example.vscore.Login.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.vscore.R
import com.example.vscore.SignUp.ui.SignUp
import com.example.vscore.databinding.ActivityLoginBinding
import com.example.vscore.databinding.ActivitySignUpBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this@LoginActivity,R.layout.activity_login)
        initListener()
    }

    private fun initListener() {
        binding.signUpBtn.setOnClickListener {
            val intent= Intent(this@LoginActivity,SignUp::class.java)
            startActivity(intent)
            finish()
        }
    }
}