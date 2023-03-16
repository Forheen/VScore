package com.example.vscore.SignUp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.vscore.Login.ui.LoginActivity
import com.example.vscore.R
import com.example.vscore.SignUp.model.SignUpRequestModel
import com.example.vscore.SignUp.viewmodel.SignUpViewModel
import com.example.vscore.databinding.ActivitySignUpBinding
import com.talen_titan.utility.PrefUtil

class SignUp : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding
    lateinit var viewModel: SignUpViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        viewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)
        initListener()
        observeRegisterApiResponse()
    }

    private fun initListener() {
        binding.signInBtn.setOnClickListener {
            val intent = Intent(this@SignUp, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.signUpBtn.setOnClickListener {
            callRegisterApi()
        }
    }

    private fun callRegisterApi() {
        val name = binding.edtUsername.text.toString()
        val email = binding.edtEmail.text.toString()
        val password = binding.edtPassword.text.toString()
        viewModel.callRegisterApi(SignUpRequestModel(name, email, password))
    }

    private fun observeRegisterApiResponse() {
        viewModel.registerResponseMutableLiveData.observe(this, Observer {
            val intent = Intent(this@SignUp, LoginActivity::class.java)
            startActivity(intent)
            finish()
        })
    }
}