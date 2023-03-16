package com.example.vscore.SignUp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.vscore.Login.ui.LoginActivity
import com.example.vscore.R
import com.example.vscore.databinding.ActivitySignUpBinding

class SignUp : AppCompatActivity() {
    lateinit var binding:ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_sign_up)
        initListener()
    }

    private fun initListener() {
        binding.signInBtn.setOnClickListener {
            val intent= Intent(this@SignUp,LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}